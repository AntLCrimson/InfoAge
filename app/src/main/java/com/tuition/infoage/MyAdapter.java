package com.tuition.infoage;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    int images[];
    String data1[], data2[];
    public MyAdapter(Context ct, String s1[], String s2[], int img[]){
        context = ct;
        data1 = s1; data2 = s2;
        images = img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater= LayoutInflater.from(context);
        View v= inflater.inflate(R.layout.model,parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.name.setText(data1[position]);
        holder.addr.setText(data2[position]);
        holder.img.setImageResource(images[position]);
        holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, Class1Activity.class);
                context.startActivity(intent);


            }
        });
    }
    @Override
    public int getItemCount(){
        return data1.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name, addr;
        RelativeLayout rl;
        //CheckBox checkBox;
        //ItemClickListener itemClickListener;
        public MyViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.txt2);
            addr = itemView.findViewById(R.id.txt3);
            img = itemView.findViewById(R.id.img1);
            rl= itemView.findViewById(R.id.rl);
            Toast.makeText(context, "hello",Toast.LENGTH_SHORT).show();
            //checkBox = itemView.findViewById(R.id.home1);
        }

    }


}

