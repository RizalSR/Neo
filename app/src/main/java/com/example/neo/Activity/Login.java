package com.example.neo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.neo.Helper.DBHelper;
import com.example.neo.Model.LoginRequest;
import com.example.neo.Model.LoginResponse;
import com.example.neo.Model.UserDetailsResponse;
import com.example.neo.R;
import com.example.neo.Retrofit.APIService;
import com.example.neo.Retrofit.ApiClient;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    Button btn_login;
    public EditText email,password;
    private ProgressDialog Pdialog;
    String accept, accesstoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.btn_login);
        email = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        start();
    }

    private void start(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {

                    loginProses();
                }
            }
        });
    }

    public boolean validate(){
        boolean valid = true;
        String txtemail = email.getText().toString();
        String txtpassword = password.getText().toString();

        if (txtemail.isEmpty()){
            email.setError("Please enter a valid username");
            valid = false;
        }else{
            email.setError(null);
        }

        if (txtpassword.isEmpty() ){//|| password.length() < 4 || password.length() > 16) {
            password.setError("Password between 4 and 16 characters");
            valid = false;
        } else {
            password.setError(null);
        }

        return valid;
    }

    private void loginProses(){
        // Start Progress Dialog
        Pdialog = new ProgressDialog(Login.this, R.style.Theme_AppCompat_DayNight_Dialog);
        Pdialog.setIndeterminate(true);
        Pdialog.setMessage("Authenticating...");
        Pdialog.setCancelable(false);
        Pdialog.show();
        //

        //Login
        String accept = "Application/json";
        String contenttype = "Content-Type/json";

        LoginRequest loginRequest = new LoginRequest(email.getText().toString(),password.getText().toString());
        APIService service = ApiClient.getClient().create(APIService.class);
        Call<LoginResponse> loginResponseCall =service.loginRequest(accept, contenttype, loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getErrnum() == 0){
                    Pdialog.hide();

                    // Save Token
                    DBHelper dbHelper = new DBHelper(Login.this);
                    if(dbHelper.getTokenCount() == 0){
                        dbHelper.addToken(response.body());
                    }else{
                        dbHelper.updateToken(response.body());
                    }
                    accesstoken = dbHelper.getToken().getData();
                    dbHelper.close();
                    getUserDetails(accesstoken);
                    Pdialog.cancel();
                    startActivity(new Intent(Login.this,MainActivity.class));
                    finish();
                }
                else if (response.body().getErrnum() == 101){
                    Pdialog.cancel();
                    failedDialog("Email or Password is Incorect");

                } else {
                    Pdialog.cancel();
                    failedDialog("Something Wrong, Please Try Again Later");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.i("error", t.getMessage());
                Toast.makeText(Login.this, "There is an error "+t.getMessage(), Toast.LENGTH_SHORT).show();
                Pdialog.cancel();
            }
        });
    }

    private void getUserDetails(String api_token){
        //Header
        String accept = "Application/json";
        String contenttype = "Content-Type/json";
        //Body
        HashMap<String,String> token = new HashMap<>();
        token.put("api_token",api_token);
        //Call
        APIService apiService = ApiClient.getClient().create(APIService.class);
        Call<UserDetailsResponse> userDetailsResponseCall = apiService.userDetailsRequest(accept,contenttype,token);
        userDetailsResponseCall.enqueue(new Callback<UserDetailsResponse>() {
            @Override
            public void onResponse(Call<UserDetailsResponse> call, Response<UserDetailsResponse> response) {
                if(response.body().getErrnum() == 0){
                    DBHelper db = new DBHelper(Login.this);
                    if(db.getUserCount() == 0){
                        db.addUser(response.body());
                    }else{
                        db.updateUser(response.body());
                    }
                    String name = db.getuser().getName();
                    db.close();
                    Toast.makeText(Login.this, "Selamat Datang "+name, Toast.LENGTH_SHORT).show();
                }else if (response.body().getErrnum() == 101){
                    Pdialog.cancel();
                    Toast.makeText(Login.this, "Get Data User Error", Toast.LENGTH_SHORT).show();
                }else{
                    Pdialog.cancel();
                    Toast.makeText(Login.this, "Something Wrong!! Try Again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserDetailsResponse> call, Throwable t) {
                Pdialog.cancel();
                Log.i("error", t.getMessage());
                Toast.makeText(Login.this, "There is an error "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void failedDialog(String message){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(Login.this, R.style.AlertDialogCustom);

        builder.setTitle("Warning!")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
