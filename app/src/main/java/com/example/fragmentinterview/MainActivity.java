package com.example.fragmentinterview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFragment.onItemListener {


    TextView tvDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails = findViewById(R.id.tvDetails);

        //portrait mode
        if(findViewById(R.id.layout_default)!=null) {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listFragment))
                    .commit();
        }

        //landscape mode
        if(findViewById(R.id.layout_land ) !=null) {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFragment))
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .commit();
        }
    }

    @Override
    public void onItemClickListener(int index) {
        if(findViewById(R.id.layout_default) != null) {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listFragment))
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .addToBackStack(null)
                    .commit();
        }
        String [] descriptions = getResources().getStringArray(R.array.descritption);
        tvDetails.setText(descriptions[index]);
    }
}