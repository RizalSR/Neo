package com.example.neo.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.neo.Model.ModelAddContact;
import com.example.neo.Model.ModelContact;
import com.example.neo.R;

import javax.security.auth.callback.Callback;

public class DialogFragmenContact extends DialogFragment {
    public CallbackResult callbackResult;
    public void setOnCallbackResult(final CallbackResult callbackResult) {
        this.callbackResult = callbackResult;
    }
    private int request_code = 3;
    private View view;
    ImageView close;
    TextView save;
    EditText name,bank;
    Spinner currency,gender;
    String txtc,txtg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_contact, container, false);
        name = (EditText) view.findViewById(R.id.contact_dialog_name);
        close = (ImageView) view.findViewById(R.id.contact_dialog_close);
        save = (TextView) view.findViewById(R.id.contact_dialog_save);
        bank = (EditText) view.findViewById(R.id.contact_dialog_bank);
        currency = (Spinner) view.findViewById(R.id.contact_dialog_spinner_c);
        gender = (Spinner) view.findViewById(R.id.contact_dialog_spinner_g);
        spinner1();
        spinner2();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataResult();
                dismiss();
            }
        });
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }


    private void spinner1(){
        //Spinner Initialize
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getContext(),
                        R.array.currency,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currency.setAdapter(adapter);
        currency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txtc = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void spinner2(){
        //Spinner Initialize
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getContext(),
                        R.array.gender,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txtg = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void sendDataResult() {
        String txtname = name.getText().toString();
        String txtbank = bank.getText().toString();

        ModelAddContact modelAddContact = new ModelAddContact(txtname,txtbank,txtc,txtg);

        if (callbackResult != null) {
            callbackResult.sendResult(request_code,modelAddContact);
        }
    }

    public void setRequestCode(int request_code) {
        this.request_code = request_code;
    }

    public interface CallbackResult {
        void sendResult(int requestCode, Object obj);
    }
}
