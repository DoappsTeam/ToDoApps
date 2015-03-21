package me.doapps.todoapps.adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;

import doapps.me.todoapps.R;
import me.doapps.todoapps.models.Values;

/**
 * Created by william on 21/03/2015.
 */
public class ContainerFragment extends Fragment {

    static Gson gson = new Gson();
    public static Values values;
    LinearLayout container;


    public static ContainerFragment newInstance(Values values){
        ContainerFragment container = new ContainerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("values", gson.toJson(values));
        container.setArguments(bundle);
        return container;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        values = gson.fromJson(getArguments().getString("values"), Values.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_container, container, false);
        container = (LinearLayout) view.findViewById(R.id.container);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for(int i=0; i<values.getCount(); i++){
            Button button = new Button(getActivity());
            button.setText(values.getValue(i));
            button.setPadding(2,2,2,2);
            button.setBackgroundResource(R.drawable.selector_act_bottom);
            container.addView(button);
        }

    }

}
