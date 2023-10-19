package ua.com.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText number_field_one, number_field_two;
    private Button add_button;
    private Button move_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.resultTextView);
        number_field_one = findViewById(R.id.number_field_one);
        number_field_two = findViewById(R.id.number_field_two);
        add_button = findViewById(R.id.add_button);
        move_button = findViewById(R.id.button_to_move_toast);

        move_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        ToastAndAlertDialogActivity.class);
                startActivity(intent);
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(number_field_one.getText().toString());
                float num2 = Float.parseFloat(number_field_two.getText().toString());
                float result = num1 + num2;
                resultTextView.setText(String.valueOf(result));
            }
        });



    }
}



