package com.example.neo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.neo.Helper.DBHelper;
import com.example.neo.Model.LoginResponse;
import com.example.neo.Model.UserDetailsResponse;
import com.example.neo.R;
import com.example.neo.Retrofit.APIService;
import com.example.neo.Retrofit.ApiClient;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splashscreen extends AppCompatActivity {

    public static final int requestCode = 200;
    String accesstoken;
    private Handler splashhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(!isFinishing())
            {
                askpermission();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        splashhandler.postDelayed(runnable, 500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        splashhandler.removeCallbacks(runnable);
    }

    // Ask Permission
    protected void askpermission(){
        String[] permission = {
                "android.permission.INTERNET",
                "android.permission.CAMERA",
                "android.permission.ACCESS_NETWORK_STATE",
                "android.permission.ACCESS_WIFI_STATE",
                "android.permission.CHANGE_NETWORK_STATE",
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE",
                "android.permission.ACCESS_COARSE_LOCATION",
                "android.permission.ACCESS_FINE_LOCATION"
        };

        int permissionCamera = ContextCompat.checkSelfPermission(Splashscreen.this, Manifest.permission.CAMERA);
        int permissionInternet = ContextCompat.checkSelfPermission(Splashscreen.this, Manifest.permission.INTERNET);
        int permissionNetwork = ContextCompat.checkSelfPermission(Splashscreen.this, Manifest.permission.ACCESS_NETWORK_STATE);
        int permissionWIFI = ContextCompat.checkSelfPermission(Splashscreen.this, Manifest.permission.ACCESS_WIFI_STATE);
        int permissionChangeNetwork = ContextCompat.checkSelfPermission(Splashscreen.this, Manifest.permission.CHANGE_NETWORK_STATE);
        int permissionStorage = ContextCompat.checkSelfPermission(Splashscreen.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permissionWriteStorage = ContextCompat.checkSelfPermission(Splashscreen.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissionLocation = ContextCompat.checkSelfPermission(Splashscreen.this, Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionCorsaLocation = ContextCompat.checkSelfPermission(Splashscreen.this, Manifest.permission.ACCESS_COARSE_LOCATION);

        // Check Permission is granted or not
        if (
            permissionCorsaLocation != PackageManager.PERMISSION_GRANTED||
            permissionLocation != PackageManager.PERMISSION_GRANTED ||
            permissionWIFI != PackageManager.PERMISSION_GRANTED ||
            permissionChangeNetwork != PackageManager.PERMISSION_GRANTED||
            permissionInternet != PackageManager.PERMISSION_GRANTED||
            permissionNetwork != PackageManager.PERMISSION_GRANTED||
            permissionStorage != PackageManager.PERMISSION_GRANTED||
            permissionWriteStorage != PackageManager.PERMISSION_GRANTED||
            permissionCamera != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(Splashscreen.this,
                    permission,
                    requestCode);
        }
        else{
            checklogin();
        }

    }

    public void gotoGetStarted(){
        startActivity(new Intent(Splashscreen.this,Getstarted.class));
        finish();
    }
    public void gotomain(){
        startActivity(new Intent(Splashscreen.this, MainActivity.class));
        finish();
    }

    public void checklogin(){
        DBHelper dbHelper = new DBHelper(this   );
        if(dbHelper.getTokenCount() != 0){
            LoginResponse token = dbHelper.getToken();
            accesstoken = token.getData();
            getUserDetails(accesstoken);
            gotomain();
        }
        else {
            gotoGetStarted();
        }
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

                    DBHelper db = new DBHelper(Splashscreen.this);
                    if(db.getUserCount() == 0){
                        db.addUser(response.body());
                    }else{
                        db.updateUser(response.body());
                    }
                    db.close();
                }else if (response.body().getErrnum() == 101){
                    Toast.makeText(Splashscreen.this, "Get Data User Error", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Splashscreen.this, "Something Wrong!! Try Again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserDetailsResponse> call, Throwable t) {
                Log.i("error", t.getMessage());
                Toast.makeText(Splashscreen.this, "There is an error "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
