package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean three = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        TextView bird = (TextView)findViewById(R.id.birdName);
        String birdName = bird.getText().toString();
        boolean questionOne = checkBird(birdName);

        CheckBox lexingtonCheckBox = findViewById(R.id.lexington_checkbox);
        boolean hasLexington = lexingtonCheckBox.isChecked();

        CheckBox salemCheckBox = findViewById(R.id.salem_checkbox);
        boolean hasSalem = salemCheckBox.isChecked();

        CheckBox sydneyCheckBox = findViewById(R.id.sydney_checkbox);
        boolean hasSydney = sydneyCheckBox.isChecked();

        CheckBox tokyoCheckBox = findViewById(R.id.tokyo_checkbox);
        boolean hasTokyo = tokyoCheckBox.isChecked();

        boolean questionTwo = checkboxChecker(hasLexington, hasSalem, hasSydney, hasTokyo);

        TextView ratified = (TextView)findViewById(R.id.ratifiedDate);
        String ratifiedDate = ratified.getText().toString();
        boolean questionFour = checkRatified(ratifiedDate);

        checkScore(questionOne, questionTwo, questionFour);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.state_number_51:
                if (checked)
                    three = false;
                    break;
            case R.id.state_number_52:
                if (checked)
                    three = false;
                    break;
            case R.id.state_number_53:
                if (checked)
                    three = false;
                    break;
            case R.id.state_number_50:
                if (checked)
                    three = true;
                    break;
        }
    }
    private void printScore(double score){
        double grade = score / 4;
        Toast.makeText(getApplicationContext(), "Your score is "+grade+"%.",
                Toast.LENGTH_SHORT).show();
    }

    private boolean checkBird(String name){
        if (name.toLowerCase().equals("eagle") || name.toLowerCase().equals("bald eagle")){
           return true;
        }else{
            return false;
        }
    }
    private boolean checkRatified(String year){
        int result = 0;
        try
        {
            // the String to int conversion happens here
            result = Integer.parseInt(year);
        }
        catch (NumberFormatException nfe)
        {
            Toast.makeText(getApplicationContext(), "Enter a number for question 4 please.",
                    Toast.LENGTH_SHORT).show();
        }
        if (result == 1788){
            return true;
        }else{
            return false;
        }
    }

    private boolean checkboxChecker(boolean lexington, boolean salem, boolean sydney, boolean tokyo){
        if (lexington && salem && !sydney && !tokyo ){
            return true;
        }else{
            return false;
        }
    }

    private void checkScore(boolean one, boolean two, boolean four){
        double score = 0;
        if (one){
            score += 1;
        }
        if (two){
            score += 1;
        }
        if (three){
            score += 1;
        }
        if (four){
            score += 1;
        }
        printScore(score);
    }
}
