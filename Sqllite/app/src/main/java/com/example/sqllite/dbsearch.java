package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import static com.example.sqllite.R.id.autocomplete;

public class dbsearch extends AppCompatActivity {

    private AutoCompleteTextView autocomplete;
    private Button button2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbsearch);
        autocomplete=findViewById(R.id.autocomplete);
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                button2_onClick(view);
            }

        });
    }

    private void button2_onClick(View view) {
        db database=new db(getApplicationContext());
        database.create(new MainContent("kevin","1234567890","01/12/2019","lunch","40"));
        database.create(new MainContent("kevin 1","0987654321","1/11/2019","lunch,omlette","90"));
        database.create(new MainContent("kevin 2","6381093841","21/10/2019","lunch,fish","150"));
        database.create(new MainContent("kevin 3","9750441234","11/09/2019","chapathi","30"));


    }

}
