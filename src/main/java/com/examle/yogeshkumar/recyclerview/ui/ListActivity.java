package com.examle.yogeshkumar.recyclerview.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.examle.yogeshkumar.recyclerview.R;
import com.examle.yogeshkumar.recyclerview.adapter.DerpAdapter;
import com.examle.yogeshkumar.recyclerview.model.Derpdata;
import com.examle.yogeshkumar.recyclerview.model.Listitem;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements DerpAdapter.ItemClickCallback {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";


    private ArrayList listData;

    RecyclerView recyclerView;
    DerpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listData=(ArrayList)Derpdata.getListData();

        recyclerView=(RecyclerView)findViewById(R.id.rec_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new DerpAdapter(Derpdata.getListData(),this);
        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallback(this);
    }

    public void onItemClick(int p) {
        Listitem item = (Listitem) listData.get(p);

        Intent i = new Intent(this, DetailActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_QUOTE, item.getTitle());
        extras.putString(EXTRA_ATTR, item.getSubTitle());
        i.putExtra(BUNDLE_EXTRAS, extras);

        startActivity(i);
    }

    @Override
    public void onSecondaryIconClick(int p) {
        Listitem item = (Listitem) listData.get(p);
        //update our data
        if (item.isFavourite()){
            item.setFavourite(false);
        } else {
            item.setFavourite(true);
        }
        //pass new data to adapter and update
        adapter.setListData(listData);
        adapter.notifyDataSetChanged();

    }
}
