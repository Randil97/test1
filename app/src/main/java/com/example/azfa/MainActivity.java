package com.example.azfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private TextView t1,t2,t3,t4,t5,t6,t7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1= (EditText) findViewById(R.id.editText);
        t2= (EditText) findViewById(R.id.editText2);
        t3= (EditText) findViewById(R.id.editText3);
        t4= (EditText) findViewById(R.id.editText4);
        t5= (EditText) findViewById(R.id.editText5);
        t6= (EditText) findViewById(R.id.editText6);
        t7= (EditText) findViewById(R.id.editText7);
        b1= (Button) findViewById(R.id.button);






        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DBhelper reservationDatabase = new DBhelper(getApplicationContext());
                long newID = reservationDatabase.addInfo(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString(),t5.getText().toString(),t6.getText().toString(),t7.getText().toString());
                Toast.makeText(MainActivity.this, "Yako ganiyee me wada karanne lassnata    Reservation ID: "+ newID, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),ship.class);
                startActivity(i);
                t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                t4.setText(null);
                t5.setText(null);
                t6.setText(null);
                t7.setText(null);



            }
        });
    }
}
