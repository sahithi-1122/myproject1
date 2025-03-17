package com.example.fitness_tracker;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        EditText steps = findViewById(R.id.steps_input);


        Button calc=findViewById(R.id.calculate_button);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stepsText = steps.getText().toString();

                // Check if the input is empty
                if (stepsText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your steps!", Toast.LENGTH_SHORT).show();
                    return; // Exit early if input is empty
                }
                try {
                    // Parse the input to an integer
                    int steps = Integer.parseInt(stepsText);

                    // Create an Intent to start calorie_activity
                    Intent intent = new Intent(MainActivity.this, calorie_activity.class);

                    // Add steps value as an extra
                    intent.putExtra("steps", steps);

                    // Start the activity
                    startActivity(intent);
                }
                catch (NumberFormatException e) {
                    // Handle invalid number input
                    Toast.makeText(MainActivity.this, "Invalid input! Please enter a valid number.", Toast.LENGTH_SHORT).show();
                }


            }
        });






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}