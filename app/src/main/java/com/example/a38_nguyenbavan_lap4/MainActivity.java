package com.example.a38_nguyenbavan_lap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edtpassword;
Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtpassword = findViewById(R.id.edtpassword);
        btnLogin = findViewById(R.id.btnLogin);
        final String strpassword = edtpassword.getText().toString();
        int dem=0;
        for (int i=0; i<strpassword.length();i++){

            if ((strpassword.charAt(i) <= 9) && (strpassword.charAt(i) >= 0)){
                dem++;
            }


        }
        final int finalDem = dem;
        btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(TextUtils.isEmpty(strpassword)) {
                   edtpassword.setError("Your Password");
                   return;
               }
               else
                   if(strpassword.length()<6)
                   {
                       edtpassword.setError("Your Password Must Have 6 Characters");
                   }
                   else
                       if( finalDem ==0){
                           edtpassword.setError("Your Password Must Have 1 Number");
                       }
                       
           }
       });

    }
}
