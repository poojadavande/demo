package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    EditText et_1,et_2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       et_1=findViewById(R.id.edit_1);
       et_2=findViewById(R.id.edit_2);
       btn=findViewById(R.id.btn_1);

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(et_1.getText().toString().isEmpty())
               {
                   et_1.setError("Username must not Empty");
               }
               else if(et_1.getText().toString().length()<5){
                   et_1.setError("Username must be Greater than 5 character");
               }
               else if(et_2.getText().toString().isEmpty())
               {
                   et_2.setError("Password must not Empty");
               }
               else if(et_2.getText().toString().length()<5) {
                   et_2.setError("Pasword must be Greater than 5 character");
               }
               else
               {
                   Intent i = new Intent(MainActivity.this,HomeActivity.class);
                   startActivity(i);
                   finish();
               }

           }
       });



    }
}