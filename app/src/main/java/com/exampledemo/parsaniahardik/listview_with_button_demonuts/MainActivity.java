package com.exampledemo.parsaniahardik.listview_with_button_demonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    public static ArrayList<Model> modelArrayList;
    private CustomAdapter customAdapter;
    private Button btnnext,btnsave;
    private String[] fruitlist = new String[]{"Apples", "Oranges", "Potatoes", "Tomatoes","Grapes"};

    public void getData()
    {
        modelArrayList.clear();
        File file=getApplicationContext().getFileStreamPath("Data.txt");
        String lineFromLine;

        if(file.exists())
        {
            try
            {
                BufferedReader reader=new BufferedReader(new InputStreamReader(openFileInput("Data.txt")));

                while((lineFromLine=reader.readLine())!= null)
                {
                    StringTokenizer tokens=new StringTokenizer(lineFromLine," ");
                    Model model=new Model(Integer.parseInt(tokens.nextToken()),tokens.nextToken());
                    modelArrayList.add(model);
                }
                reader.close();
            }
            catch(IOException e)
            {

            }
        }
    }
    public void saveData(View v)
    {
        try
        {
            FileOutputStream file=openFileOutput("Data.txt",MODE_PRIVATE);
            OutputStreamWriter outputfile= new OutputStreamWriter(file);

            for(int i=0;i<modelArrayList.size();i++)
            {
                outputfile.write(modelArrayList.get(i).getFruit()+" "+modelArrayList.get(i).getAttended_lecture()+"\n");
            }
            outputfile.flush();
            outputfile.close();

            Toast.makeText(MainActivity.this,"Successfully Saved",Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)
        {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        btnnext = (Button) findViewById(R.id.next);
        modelArrayList=new ArrayList<Model>();
        customAdapter = new CustomAdapter(this);
        getData();
        if(!(modelArrayList.size()==0))
        {
            lv.setAdapter(customAdapter);
        }
        else
        {
            Intent intent=new Intent(MainActivity.this,Addsubject.class);
            startActivity(intent);
            getData();
        }

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
            }
        });
    }


}
