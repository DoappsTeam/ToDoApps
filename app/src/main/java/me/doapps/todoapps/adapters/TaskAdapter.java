package me.doapps.todoapps.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import doapps.me.todoapps.R;
import me.doapps.todoapps.models.Task_DTO;

/**
 * Created by jonathan on 21/03/2015.
 */
public class TaskAdapter extends BaseAdapter {
    private ArrayList<Task_DTO> task_dtos;
    private Context context;
    private LayoutInflater inflater;

    public TaskAdapter(ArrayList<Task_DTO> task_dtos, Context context) {
        this.task_dtos = task_dtos;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return task_dtos.size();
    }

    @Override
    public Object getItem(int position) {
        return task_dtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        Task_DTO task_dto = task_dtos.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_task, parent, false);
            holder = new Holder();

            holder.verbName = (TextView) convertView.findViewById(R.id.verbName);
            holder.labelImportant = (TextView) convertView.findViewById(R.id.labelImportant);
            //holder.objectName = (TextView) convertView.findViewById(R.id.objectName);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.verbName.setText(task_dto.getVerbName());
        if(task_dto.getTaskState()==2){
            holder.labelImportant.setVisibility(View.VISIBLE);
        }


        //holder.objectName.setText(task_dto.getObjectName());

        return convertView;
    }

    /****/
    private static class Holder {
        TextView labelImportant;
        TextView verbName;
        //TextView objectName;
    }
}
