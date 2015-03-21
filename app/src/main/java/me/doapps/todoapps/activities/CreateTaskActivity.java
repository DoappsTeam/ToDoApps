package me.doapps.todoapps.activities;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import doapps.me.todoapps.R;
import me.doapps.todoapps.adapters.ContainerFragment;
import me.doapps.todoapps.models.Values;


public class CreateTaskActivity extends ActionBarActivity {

    ArrayList<Values> arrayValues;
    private FragmentAdapter fragmentAdapter;
    private ViewPager viewPager;
    private CirclePageIndicator circlePageIndicator;
    Handler handler;
    Runnable update;

    Button verbSelected, objectSelected;

    ArrayList<String> verbs = new ArrayList<>();
    ArrayList<String> objects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        arrayValues = new ArrayList<>();

        Values values = new Values();
        values.addValue("Programar");
        values.addValue("Tomar Café");
        values.addValue("Diseñar");
        values.addValue("Dormir");
        arrayValues.add(values);
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

    public class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ContainerFragment.newInstance(arrayValues.get(position));
        }

        @Override
        public int getCount() {
            return arrayValues.size();
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }

    }

}
