package me.doapps.todoapps.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import doapps.me.todoapps.R;
import me.doapps.todoapps.database.DataBaseManager;


public class CreateTaskActivity extends ActionBarActivity {

    LinearLayout linearLayoutVerb, linearLayoutObject, linearLayoutRegisterVerb, linearLayoutRegisterObject;

    TextView textViewVerb, textViewObject;

    ImageView imageViewRegisterVerb, imageViewRegisterObject;

    EditText editTextVerb, editTextObject;

    ArrayList<String> verbs = new ArrayList<>();
    ArrayList<String> objects = new ArrayList<>();

    DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        dataBaseManager = new DataBaseManager(CreateTaskActivity.this);

        linearLayoutVerb = (LinearLayout) findViewById(R.id.linearLayoutVerb);
        linearLayoutObject = (LinearLayout) findViewById(R.id.linearLayoutObject);
        linearLayoutRegisterVerb= (LinearLayout) findViewById(R.id.linearLayoutObject);
        linearLayoutRegisterObject= (LinearLayout) findViewById(R.id.linearLayoutObject);

        textViewVerb = (TextView) findViewById(R.id.textViewVerb);
        textViewObject= (TextView) findViewById(R.id.textViewObject);

        linearLayoutRegisterVerb.setVisibility(View.GONE);
        linearLayoutRegisterObject.setVisibility(View.GONE);

        imageViewRegisterVerb = (ImageView) findViewById(R.id.image_view_register_verb);
        imageViewRegisterObject= (ImageView) findViewById(R.id.image_view_register_verb);

        editTextVerb = (EditText) findViewById(R.id.edit_text_verb_name);
        editTextObject = (EditText) findViewById(R.id.edit_text_object_name);

        imageViewRegisterVerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String verb = editTextVerb.getText().toString();
                    if(verb!=null && verb.equals(" ") && verb.equals("")){
                        dataBaseManager.insertVerb(verb,0,1);
                        linearLayoutRegisterVerb.setVisibility(View.GONE);
                    }else{
                        Toast.makeText(CreateTaskActivity.this,"Ingrese un verbo adecuadamente",Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e){
                    Toast.makeText(CreateTaskActivity.this,"Ingrese un verbo adecuadamente",Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageViewRegisterObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutRegisterObject.setVisibility(View.GONE);
                try {
                    String object = editTextVerb.getText().toString();
                    if(object!=null && object.equals(" ") && object.equals("")){
                        dataBaseManager.insertVerb(object,0,1);
                        linearLayoutRegisterVerb.setVisibility(View.GONE);
                    }else{
                        Toast.makeText(CreateTaskActivity.this,"Ingrese un objeto adecuadamente",Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e){
                    Toast.makeText(CreateTaskActivity.this,"Ingrese un objeto adecuadamente",Toast.LENGTH_SHORT).show();
                }
            }
        });

        textViewVerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutVerb.setVisibility(View.VISIBLE);
            }
        });

        textViewObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutObject.setVisibility(View.VISIBLE);
            }
        });

        verbs = new ArrayList<>();

        verbs.add("Programar");
        verbs.add("Tomar");
        verbs.add("Diseñar");
        verbs.add("Dormir");
        verbs.add("Programar");
        verbs.add("Tomar");
        verbs.add("Diseñar");
        verbs.add("Dormir");
        verbs.add("Programar");
        verbs.add("Tomar");
        verbs.add("Diseñar");
        verbs.add("Dormir");
        verbs.add("Dormir2");

        objects.add("Laptop");
        objects.add("Celular");
        objects.add("Café");
        objects.add("Cama");
        objects.add("Sofa");
        objects.add("Laptop");
        objects.add("Celular");
        objects.add("Café");
        objects.add("Cama");
        objects.add("Sofa");
        objects.add("Laptop");
        objects.add("Celular");
        objects.add("Café");
        objects.add("Cama");
        objects.add("Sofa");

        Button buttonVerbs;
        int rowsVerbs = 0;
        for(int i=0; i<verbs.size()/3+1; i++){
            LinearLayout column = new LinearLayout(CreateTaskActivity.this);
            column.setOrientation(LinearLayout.VERTICAL);
            for(int j=0; j<3; j++){
                if(rowsVerbs<verbs.size()){
                    buttonVerbs = new Button(CreateTaskActivity.this);
                    Log.e("show",verbs.get(rowsVerbs)+"-"+rowsVerbs);
                    buttonVerbs.setText(verbs.get(rowsVerbs));
                    buttonVerbs.setPadding(2,2,2,2);
                    buttonVerbs.setBackgroundResource(R.drawable.selector_act_bottom);
                column.addView(buttonVerbs);
                    rowsVerbs++;
                }else{
                    break;
                }
            }
            linearLayoutVerb.addView(column);
        }rowsVerbs = 0;

        Button buttonObject;
        int rowsObject =0;
        for(int i=0; i<verbs.size()/3+1; i++){
            LinearLayout column = new LinearLayout(CreateTaskActivity.this);
            column.setOrientation(LinearLayout.VERTICAL);
            for(int j=0; j<3; j++){
                if(rowsObject<verbs.size()){
                    buttonObject = new Button(CreateTaskActivity.this);
                    Log.e("show",verbs.get(rowsObject)+"-"+rowsObject);
                    buttonObject.setText(verbs.get(rowsObject));
                    buttonObject.setPadding(2,2,2,2);
                    buttonObject.setBackgroundResource(R.drawable.selector_act_bottom);
                    column.addView(buttonObject);
                    rowsObject++;
                }else{
                    break;
                }
            }
            linearLayoutVerb.addView(column);
        }rowsObject = 0;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
