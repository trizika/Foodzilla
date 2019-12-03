package com.example.foodzilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AvailableEvents extends AppCompatActivity implements View.OnClickListener {



    TextView date1, date2,date3, date4;

    TextView name1, name2, name3, name4;

    Button bMEvents, bAEvents, BHostEvent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_events);


        date1 = findViewById(R.id.textviewEDate1);
        date2 = findViewById(R.id.textViewEDate2);
        date3 = findViewById(R.id.textViewEDate3);
        date4 = findViewById(R.id.textViewEDate4);

        name1 = findViewById(R.id.textViewEName1);
        name2 = findViewById(R.id.textViewEName2);
        name3 = findViewById(R.id.textViewEName3);
        name4 = findViewById(R.id.textViewEName4);

        name1.setOnClickListener(this);
        name2.setOnClickListener(this);
        name3.setOnClickListener(this);
        name4.setOnClickListener(this);






    }

    @Override
    public void onClick(View view) {

    }
}
