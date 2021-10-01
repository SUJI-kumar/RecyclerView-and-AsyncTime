package com.example.student_time;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class p1adapter extends RecyclerView.Adapter<p1adapter.ViewHolder> {
    public List<p1modelclass> userList;

    public p1adapter (List<p1modelclass>userList){this.userList=userList;}
    @NonNull
    @Override
    public p1adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.p1item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final p1adapter.ViewHolder holder, int position) {
        int resources=userList.get(position).getImageview1();
        String name=userList.get(position).getTextview1();
        String msg=userList.get(position).getTextview3();
        String section=userList.get(position).getTextview2();
        String line=userList.get(position).getDivider();
        holder.setData(resources,name,msg,section,line);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageview;
        public TextView textview;
        public TextView textview2;
        public TextView textview3;
        public TextView divider;
        public Button delete;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.imageview1);
            textview=itemView.findViewById(R.id.textview);
            textview2=itemView.findViewById(R.id.textview2);
            textview3=itemView.findViewById(R.id.textview3);
            divider=itemView.findViewById(R.id.divider);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.recycler_layout);
            delete = itemView.findViewById(R.id.delete);
            delete.setVisibility(View.INVISIBLE);

            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    delete.setVisibility(View.INVISIBLE);

                    Intent i = new Intent(itemView.getContext(), p1_details.class);
                    i.putExtra("title","SUJIT");
                    itemView.getContext().startActivity(i);

                }
            });
            relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    delete.setVisibility(View.VISIBLE);
                    delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            delete.setVisibility(View.INVISIBLE);
                            deleteEntry(getAdapterPosition());
                        }
                    });
                    return true;
                }
            });


        }
        public void deleteEntry(int position){
            userList.remove(position);
            notifyDataSetChanged();
        }

        public void setData(int resources, String name, String msg, String section, String line) {
            imageview.setImageResource(resources);
            textview.setText(name);
            textview3.setText(msg);
            textview2.setText(section);
            divider.setText(line);
        }
    }
}
