package com.exampledemo.parsaniahardik.listview_with_button_demonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Addsubject extends AppCompatActivity {
    private EditText etFruit,etAtttendence;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsubject);

        etFruit=(EditText)findViewById(R.id.etfruit1);
        etAtttendence=(EditText)findViewById(R.id.etAttendence1);
        btnAdd=(Button)findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model model = new Model();
                String att=etAtttendence.getText().toString();
                model.setAttended_lecture(Integer.parseInt(att));
                model.setFruit(etFruit.getText().toString());
                try
                {
                    FileOutputStream file=openFileOutput("Data.txt",MODE_PRIVATE);
                    OutputStreamWriter outputfile= new OutputStreamWriter(file);
                    outputfile.write(model.getFruit()+" "+model.getAttended_lecture()+"\n");
                    outputfile.flush();
                    outputfile.close();

                    Toast.makeText(Addsubject.this,"Successfully Saved",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {

                }
                finish();
            }
        });

    }
}
