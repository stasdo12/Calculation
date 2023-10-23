package ua.com.calculation;

import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ToastAndAlertDialogActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_and_alert_dialog);

        Button button = findViewById(R.id.button_to_calc);
        Button button_to_image = findViewById(R.id.move_to_image);
        Button button_alert = findViewById(R.id.button_alert);
        TextView mainText = findViewById(R.id.simpleText);



        button_to_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToastAndAlertDialogActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToastAndAlertDialogActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoAlert("Do you want to close app?");
//                showInfo(mainText.getText().toString(), button_alert);

            }
        });


    }


    //We can create a new method for two buttons, and choice this method in Design
    public void btnClick(View v){
        showInfo(((Button)v).getText().toString(), ((Button) v));
    }

    private void showInfoAlert(String info){
        AlertDialog.Builder builder = new AlertDialog.
                Builder(ToastAndAlertDialogActivity.this);
        builder.setTitle("Alert Info (BIG)")
                .setMessage(info)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    private void showInfo(String info, Button btn){
        btn.setText("Has already push");
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        Toast.makeText(ToastAndAlertDialogActivity.this, info, Toast.LENGTH_LONG).show();
    }



}