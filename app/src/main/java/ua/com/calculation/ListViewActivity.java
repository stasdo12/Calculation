package ua.com.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    private String[] namesArr = new String[]{"Jon", "Stan", "Bob", "Georg", "Alex"};
    private ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.ListView);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.disign_for_list_contacts, R.id.user_name, namesArr);
        listView.setAdapter(adapter);


    }


    public void moveToMainPage(View view){
        Intent intent = new Intent(this, TextEditorActivity.class);
        startActivity(intent);
    }

}