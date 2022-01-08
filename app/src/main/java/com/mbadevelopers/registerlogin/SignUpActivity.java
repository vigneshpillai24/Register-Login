package com.mbadevelopers.registerlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialStyledDatePickerDialog;
import com.mbadevelopers.api.APIUrl;
import com.mbadevelopers.api.APIService;
import com.mbadevelopers.models.Data;
import com.mbadevelopers.models.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Button buttonSignUp;
    private EditText editTextFName, editTextLName, editTextEmail, editTextPassword, editTextPhoneCode, editTextPhone,editTextDate;
    private RadioGroup radioGender;
    private CheckBox checkBox;
    private DatePickerDialog datePickerDialog;

    String devicetype, devicetoken, osversion, devicemodel, appversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);

        editTextFName = (EditText) findViewById(R.id.editTextFName);
        editTextLName = (EditText) findViewById(R.id.editTextLName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPhoneCode = (EditText) findViewById(R.id.editTextPhoneCode);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);

        radioGender = (RadioGroup) findViewById(R.id.radioGender);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        checkBox = (CheckBox) findViewById(R.id.checkBox1);


    }

    public void dateset(View view) {

        DatePickerDialog dialog = new DatePickerDialog(this,this, 2022, 10, 07);
        dialog.show();
    }



    public void userSignUp(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        //getting the user values
        final RadioButton radioSex = (RadioButton) findViewById(radioGender.getCheckedRadioButtonId());

        String fname = editTextFName.getText().toString().trim();
        String lname = editTextLName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String pcode = editTextPhoneCode.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String gender = radioSex.getText().toString();
        String dob = editTextDate.getText().toString();
        String newsletter = "";

        if (checkBox.isChecked()){
            newsletter = "1";
        }
        else {
            newsletter = "0";
        }




        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        APIService service = retrofit.create(APIService.class);

        //Defining the user object as we need to pass it with the call
        Data data = new Data (email, password, fname, lname, gender, dob, pcode, phone,newsletter);

        //defining the call
        Call<Result> call = service.createUser(
                data.getEmail(),
                data.getPassword(),
                data.getFName(),
                data.getLName(),
                data.getGender(),
                data.getDob(),
                data.getPcode(),
                data.getPnumber(),
                data.getImage(),
                data.getDevicetype(),
                data.getDevicetoken(),
                data.getAppversion(),
                data.getOsversion(),
                data.getDevicemodel(),
                data.getNewletter()
        );

        //calling the api
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                //hiding progress dialog
                progressDialog.dismiss();

                //displaying the message from the response as toast
                Toast.makeText(getApplicationContext(), response.body().getMessage().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
       int yr = view.getYear();
       int mon = view.getMonth() + 1;
       int dy = view.getDayOfMonth();


        editTextDate.setText(yr + "-" +mon + "-" +dy);
    }

}