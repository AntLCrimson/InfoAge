package com.tuition.infoage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ClassesActivity extends AppCompatActivity {
    String s1[],s2[];
    int images[] = {R.drawable.pr1,R.drawable.pr2, R.drawable.pr3, R.drawable.pr4};

    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        s1 = getResources().getStringArray(R.array.addr);
        s2 = getResources().getStringArray(R.array.price);
        adapter = new MyAdapter(this, s1,s2, images);
        RecyclerView rv=(RecyclerView)findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        //rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
    }
}