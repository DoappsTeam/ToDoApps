package me.doapps.todoapps.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.database.Cursor;
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

    DataBaseManager dataBaseManager;

    final static String TAG = CreateTaskActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        dataBaseManager = new DataBaseManager(CreateTaskActivity.this);

        linearLayoutVerb = (LinearLayout) findViewById(R.id.linearLayoutVerb);
        linearLayoutObject = (LinearLayout) findViewById(R.id.linearLayoutObject);
        linearLayoutRegisterVerb= (LinearLayout) findViewById(R.id.register_verb);
        linearLayoutRegisterObject= (LinearLayout) findViewById(R.id.register_object);

        textViewVerb = (TextView) findViewById(R.id.textViewVerb);
        textViewObject= (TextView) findViewById(R.id.textViewObject);

        textViewVerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(CreateTaskActivity.this);
                View view = getLayoutInflater().inflate(R.layout.dialog_register_verbs, null);
                final EditText editTextVerb = (EditText) view.findViewById(R.id.edit_text_verb_name);
                ImageView imageViewRegisterVerb = (ImageView) view.findViewById(R.id.image_view_register_verb);
                dialog.setCancelable(true);
                dialog.setView(view);
                final Dialog dialogCreate = dialog.create();

                imageViewRegisterVerb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            String verb = editTextVerb.getText().toString();
                            if(verb!=null && !verb.equals(" ") && !verb.equals("")){
                                dataBaseManager.insertVerb(verb,0,1);
                                loadVerbs();//MEJORAR
                                dialogCreate.dismiss();
                            }else{
                                dialogCreate.dismiss();
                                Toast.makeText(CreateTaskActivity.this,"Ingrese un verbo adecuadamente",Toast.LENGTH_SHORT).show();
                            }
                        } catch(Exception e){
                            dialogCreate.dismiss();
                            Toast.makeText(CreateTaskActivity.this,"Ingrese un verbo adecuadamente",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialogCreate.setCancelable(true);
                dialogCreate.show();
            }
        });

        textViewObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(CreateTaskActivity.this);
                View view = getLayoutInflater().inflate(R.layout.dialog_register_objects, null);
                final EditText editTextObject = (EditText) view.findViewById(R.id.edit_text_object_name);
                ImageView imageViewRegisterObject = (ImageView) view.findViewById(R.id.image_view_register_object);
                dialog.setCancelable(true);
                dialog.setView(view);
                final Dialog dialogCreate = dialog.create();
                imageViewRegisterObject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            String object = editTextObject.getText().toString();
                            if(object!=null && !object.equals(" ") && !object.equals("")){
                                dataBaseManager.insertObject(object,0,1);
                                loadObjects();//MEJORAR
                                dialogCreate.dismiss();
                            }else{
                                dialogCreate.dismiss();
                                Toast.makeText(CreateTaskActivity.this,"Ingrese un objeto adecuadamente",Toast.LENGTH_SHORT).show();
                            }
                        } catch(Exception e){
                            dialogCreate.dismiss();
                            Toast.makeText(CreateTaskActivity.this,"Ingrese un objeto adecuadamente",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialogCreate.setCancelable(true);
                dialogCreate.show();
            }
        });

        Log.e("",loadVerbs()+"");
        Log.e("",loadObjects()+"");

    }

    public boolean loadVerbs(){
        try{
            //linearLayoutVerb = new LinearLayout(CreateTaskActivity.this);
            linearLayoutVerb.removeAllViews();
            ArrayList<String> array = new ArrayList<>();
            Cursor c = dataBaseManager.selectVerbs();
            while(c.moveToNext()){
                array.add(c.getString(0));
            }
            Button buttonVerbs;
            int rowsVerbs = 0;
            for(int i=0; i<array.size()/3+1; i++){
                LinearLayout column = new LinearLayout(CreateTaskActivity.this);
                column.setOrientation(LinearLayout.VERTICAL);
                for(int j=0; j<3; j++){
                    if(rowsVerbs<array.size()){
                        buttonVerbs = new Button(CreateTaskActivity.this);
                        buttonVerbs.setText(array.get(rowsVerbs));
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
            return true;
        }catch(Exception e){
            Log.e(TAG,"loadVerbs"+e.toString());
            return false;
        }
    }

    public boolean loadObjects(){
        try{
            //linearLayoutObject = new LinearLayout(CreateTaskActivity.this);
            linearLayoutObject.removeAllViews();
            ArrayList<String> array = new ArrayList<>();
            Cursor c = dataBaseManager.selectObjects();
            while(c.moveToNext()){
                array.add(c.getString(0));
            }
            Button buttonObject;
            int rowsObject =0;
            for(int i=0; i<array.size()/3+1; i++){
                LinearLayout column = new LinearLayout(CreateTaskActivity.this);
                column.setOrientation(LinearLayout.VERTICAL);
                for(int j=0; j<3; j++){
                    if(rowsObject<array.size()){
                        buttonObject = new Button(CreateTaskActivity.this);
                        buttonObject.setText(array.get(rowsObject));
                        buttonObject.setPadding(2,2,2,2);
                        buttonObject.setBackgroundResource(R.drawable.selector_act_bottom);
                        column.addView(buttonObject);
                        rowsObject++;
                    }else{
                        break;
                    }
                }
                linearLayoutObject.addView(column);
            }rowsObject = 0;
            return true;
        }catch(Exception e){
            Log.e(TAG,"loadObjects"+e.toString());
            return false;
        }
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
