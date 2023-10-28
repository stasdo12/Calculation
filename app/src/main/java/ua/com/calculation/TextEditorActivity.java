package ua.com.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextEditorActivity extends AppCompatActivity {


    private EditText user_name_field, user_bio_field;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_editor);
        user_name_field = findViewById(R.id.user_name_field);
        user_bio_field = findViewById(R.id.user_bio_field);

    }




    public void saveData(View view){
        String user_name  = user_name_field.getText().toString();
        String user_bio = user_bio_field.getText().toString();

        try {
            FileOutputStream fileOutputStream = openFileOutput("user_data.txt", MODE_PRIVATE);
            fileOutputStream.write((user_name +  (". ") + user_bio).getBytes());
            fileOutputStream.close();


            user_name_field.setText("");
            user_bio_field.setText("");
            Toast.makeText(this, "Data saved!", Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {

           e.printStackTrace();
            Toast.makeText(this, "Can't open the file", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Writable error", Toast.LENGTH_LONG).show();

        }

    }

    public void getData(View view){

        try {
            FileInputStream fileInputStream = openFileInput("user_data.txt");
            InputStreamReader reader =  new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuilder stringBuffer = new StringBuilder();
            String lines = "";
            while ((lines = bufferedReader.readLine()) != null){
                stringBuffer.append(lines).append("\n");
            }
            Toast.makeText(this, stringBuffer, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}