package me.doapps.todoapps.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.shamanland.fab.FloatingActionButton;

import java.util.ArrayList;

import doapps.me.todoapps.R;
import me.doapps.todoapps.adapters.TaskAdapter;
import me.doapps.todoapps.database.DataBaseManager;
import me.doapps.todoapps.dialogs.TaskDialog;
import me.doapps.todoapps.models.Task_DTO;

/**
 * Created by jonathan on 21/03/2015.
 */
public class ListTaskActivity extends ActionBarActivity implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    private ArrayList<Task_DTO> task_dtos;
    private ListView listTask;
    private FloatingActionButton fabCreateTask;
    private DataBaseManager manager;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_task);

        listTask = (ListView) findViewById(R.id.listTask);
        fabCreateTask = (FloatingActionButton) findViewById(R.id.fabCreateTask);

        fabCreateTask.setOnClickListener(this);
        listTask.setOnItemLongClickListener(this);
        listTask.setOnItemClickListener(this);

        manager = new DataBaseManager(this);

        /*insert*/
        /*for (int i = 0; i < 15; i++) {
            manager.insertTask("test");
        }*/
            /*select*/
        task_dtos = new ArrayList<>();
        cursor = manager.selectTask();
        //cursor = manager.selectTaskFilter();
        if (cursor.moveToFirst()) {
            do {
                int taskId = cursor.getInt(0);
                int taskState = cursor.getInt(5);
                String verName = cursor.getString(2);
                String objectName = cursor.getString(3);
                task_dtos.add(new Task_DTO(taskId, "taskName", "taskDueDate", "taskUpdatedAt", objectName, verName, 1, 1, taskState , 1, "taskCreatedAt"));
            } while (cursor.moveToNext());
        }
        listTask.setAdapter(new TaskAdapter(task_dtos, ListTaskActivity.this));

        /*task_dtos.add(new Task_DTO(1, "taskName", "taskDueDate", "taskUpdatedAt", "objectName", "verbName", 1, 1, 1, 1, "taskCreatedAt"));
        task_dtos.add(new Task_DTO(1, "taskName", "taskDueDate", "taskUpdatedAt", "objectName", "verbName", 1, 1, 1, 1, "taskCreatedAt"));
        task_dtos.add(new Task_DTO(1, "taskName", "taskDueDate", "taskUpdatedAt", "objectName", "verbName", 1, 1, 1, 1, "taskCreatedAt"));
        task_dtos.add(new Task_DTO(1, "taskName", "taskDueDate", "taskUpdatedAt", "objectName", "verbName", 1, 1, 1, 1, "taskCreatedAt"));
        task_dtos.add(new Task_DTO(1, "taskName", "taskDueDate", "taskUpdatedAt", "objectName", "verbName", 1, 1, 1, 1, "taskCreatedAt"));
        task_dtos.add(new Task_DTO(1, "taskName", "taskDueDate", "taskUpdatedAt", "objectName", "verbName", 1, 1, 1, 1, "taskCreatedAt"));
        task_dtos.add(new Task_DTO(1, "taskName", "taskDueDate", "taskUpdatedAt", "objectName", "verbName", 1, 1, 1, 1, "taskCreatedAt"));*/


    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(ListTaskActivity.this, CreateTaskActivity.class));
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "favorite", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Task_DTO task_dto = (Task_DTO) parent.getAdapter().getItem(position);
        final TaskDialog taskDialog = new TaskDialog(ListTaskActivity.this);
        taskDialog.show();
        taskDialog.setInterfaceDone(new TaskDialog.InterfaceDone() {
            @Override
            public void getDone(int taskId) {
                Log.e("done", "yee");
                manager.updateTask(String.valueOf(task_dto.getTaskId()), String.valueOf(taskId));
                taskDialog.dismiss();
            }
        });
        taskDialog.setInterfaceFavorite(new TaskDialog.InterfaceFavorite() {
            @Override
            public void getFavorite(int taskId) {
                Log.e("fav", "yee");
                manager.updateTask(String.valueOf(task_dto.getTaskId()), String.valueOf(taskId));
                taskDialog.dismiss();
            }
        });
        taskDialog.setInterfaceRemove(new TaskDialog.InterfaceRemove() {
            @Override
            public void getRemove(int taskId) {
                Log.e("remove", "yee");
                manager.updateTask(String.valueOf(task_dto.getTaskId()), String.valueOf(taskId));
                taskDialog.dismiss();
            }
        });
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }


    public void updateListview() {


    }
}
