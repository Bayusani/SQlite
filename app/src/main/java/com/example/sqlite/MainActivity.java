package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

private Button btnStore, btnGetall;
private EditText etname;
private DatabaseHelper databaseHelper;
private TextView tvnames;
private ArrayList<String> arraylist;


databaseHelper = new DatabaseHelper(this);
tvnames = (TextView) findViewById(R.id.tvnames);

btnStore = (Button) findViewById(R.id.btnstore);
btnGetall = (Button) findViewById(R.id.btnget);
etname = (EditText) findViewById(R.id.etname);

btnStore.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        databaseHelper.addStudentDetail(etname.getText().toString());
        etname.setText("");
        Toast.makeText( MainActivity.this,
        "Stored Succesfully!", Toast.LENGHT.SHORT).show();
        }

        });

btnGetall.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view){
        arrayList = databaseHelper.getAllStudentsList();
        tvnames.setText("");
        for (int i = 0; i<arrayList.size(); i++){
            tvnames.setText(tvnames.getText().toString ()+ ", " +arrayList.get(i));
        }
        }
        })

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}