package com.example.favouriteplaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;
    CheckBox check1, check2, check3, check4, check5;
    RadioGroup radioGroup;
    RadioButton selected;
    Button red, green, blue;
    TextView textView1, textView2, textView3;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.mainLayout);
        check1 = findViewById(R.id.checkbox1);
        check2 = findViewById(R.id.checkbox2);
        check3 = findViewById(R.id.checkbox3);
        check4 = findViewById(R.id.checkbox4);
        check5 = findViewById(R.id.checkbox5);

        radioGroup = findViewById(R.id.radiogroup);

        red = findViewById(R.id.button1);
        blue = findViewById(R.id.button3);
        green = findViewById(R.id.button2);

        textView1 = findViewById(R.id.textview1);
        textView2 = findViewById(R.id.textview2);

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favPlaces();
            }
        });

        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favPlaces();
            }
        });

        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favPlaces();
            }
        });

        check4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favPlaces();
            }
        });

        check5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favPlaces();
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                going(checkedId);
            }
        });


        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorToggle("#FF0000");
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorToggle("#00FF00");
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorToggle("#0000FF");
            }
        });



    }

    public void favPlaces(){
        text = "my favorite place(s): \n";

        boolean checked = false;

        if (check1.isChecked()) {
            text += check1.getText().toString() +"\n";
            checked = true;
        }
        if (check2.isChecked()) {
            text += check2.getText().toString() + "\n";
            checked = true;
        }
        if (check3.isChecked()) {
            text += check3.getText().toString() + "\n";
            checked = true;
        }
        if (check4.isChecked()) {
            text += check4.getText().toString() + "\n";
            checked = true;
        }
        if (check5.isChecked()) {
            text += check5.getText().toString() + "\n";
            checked = true;
        }

        if (!checked) text = "";

        textView1.setText(text);
    }

    private void going(int checkedId) {
        RadioButton selected = findViewById(checkedId);
       String text1 = selected.getText().toString();
        if (selected != null) {
            textView2.setText("I want to visit " + text1 + " in December");
        }
    }

    private void colorToggle(String colorHex) {
        int currentColor = ((ColorDrawable) layout.getBackground()).getColor();

        if (currentColor == Color.parseColor(colorHex)) {
            layout.setBackgroundColor(Color.WHITE);
        } else {
            layout.setBackgroundColor(Color.parseColor(colorHex));
        }
    }

}