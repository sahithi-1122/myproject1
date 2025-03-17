package com.example.fitness_tracker;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;


import android.widget.TextView;
import android.widget.Toast;

public class calorie_activity extends AppCompatActivity {
    private double calculateCalories(int weight, int age1, int steps) {
        // MET value for walking at moderate speed (e.g., 3.5 METs)
        double met = 3.5;
        // Average step length in miles (e.g., 2,000 steps per mile)
        double stepsPerMile = 2000;
        // Convert steps to miles
        double miles = (double)steps / stepsPerMile;
        // Adjust the MET value based on age (example adjustment, you can refine this)
        double ageFactor = 1 - (age1 - 20) * 0.001;
        // Calories burned per mile = METs * weight (lbs) * miles * ageFactor
        double caloriesPerMile = met * weight * miles * ageFactor;
        return caloriesPerMile;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_calorie);
        Button bt=findViewById(R.id.calculate_button);
        EditText weight=findViewById(R.id.weight_input);
        EditText age=findViewById(R.id.age_input);
        TextView answer=findViewById(R.id.calories_burned);
        Button backButton=findViewById(R.id.back_button);
        bt.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View v) {
                                      String agetext=age.getText().toString();
                                      String weighttext=weight.getText().toString();
                                      int  weight1=Integer.parseInt(weighttext);
                                      int age1=Integer.parseInt(agetext);
                                      int steps = getIntent().getIntExtra("steps", 0);
                                      double a= calculateCalories(weight1,age1,steps);
                                      answer.setText("Calories Burned: " + Math.round(a));

                                  }

        });
                // Set an OnClickListener for the backButton to handle click events.
                backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
// Call finish() to close the current activity and return to the MainActivity.
                        finish();
                    }
                });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

}