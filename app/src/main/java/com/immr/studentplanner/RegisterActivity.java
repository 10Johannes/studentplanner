package com.immr.studentplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText username,password,repassword;
    private Button login, register;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        repassword = (EditText) findViewById(R.id.repassword);
        dbHandler = new DBHandler(this, null, null, 1);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass)||TextUtils.isEmpty(repass))
                    Toast.makeText(RegisterActivity.this, "Fill up the empty fields.",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = dbHandler.checkUsername(user);
                        if(!checkuser){
                            Boolean insert = dbHandler.addUser(user, pass);
                            if(insert){
                                Toast.makeText(RegisterActivity.this, "Registered successfully!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this,"Registration failed!",Toast.LENGTH_SHORT).show();
                                user = "";
                                pass = "";
                                repass = "";
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this,"Username already exists!",Toast.LENGTH_SHORT).show();
                            user = "";
                            pass = "";
                            repass = "";
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this,"Password does not match! ",Toast.LENGTH_SHORT).show();
                        user = "";
                        pass = "";
                        repass = "";
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}