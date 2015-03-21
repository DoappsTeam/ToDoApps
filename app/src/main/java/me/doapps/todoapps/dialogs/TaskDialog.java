package me.doapps.todoapps.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import doapps.me.todoapps.R;
import me.doapps.todoapps.models.Task_DTO;

/**
 * Created by jonathan on 21/03/2015.
 */
public class TaskDialog extends AlertDialog {
    private Task_DTO task_dto;
    private InterfaceDone interfaceDone;
    private InterfaceRemove interfaceRemove;
    private InterfaceFavorite interfaceFavorite;

    public TaskDialog(Context context) {
        super(context);
        initDialog();
    }

    protected TaskDialog(Context context, int theme) {
        super(context, theme);
        initDialog();
    }

    protected TaskDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initDialog();
    }

    private void initDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.dialog_task, null);
        setView(view);

        ImageButton btnDone = (ImageButton)view.findViewById(R.id.btnDone);
        ImageButton btnRemove = (ImageButton)view.findViewById(R.id.btnRemove);
        ImageButton btnFavorite = (ImageButton)view.findViewById(R.id.btnFavorite);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceDone.getDone(1);
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceRemove.getRemove(0);
            }
        });
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceFavorite.getFavorite(2);
            }
        });

        setCancelable(true);

    }

    /**Inner Interface**/
    public interface InterfaceDone{
        void getDone(int status);
    }
    public void setInterfaceDone(InterfaceDone interfaceDone){
        this.interfaceDone = interfaceDone;
    }

    public interface InterfaceRemove{
        void getRemove(int status);
    }
    public void setInterfaceRemove(InterfaceRemove interfaceRemove){
        this.interfaceRemove = interfaceRemove;
    }

    public interface InterfaceFavorite{
        void getFavorite(int status);
    }
    public void setInterfaceFavorite(InterfaceFavorite interfaceFavorite){
        this.interfaceFavorite = interfaceFavorite;
    }

}
