package com.charlezz.mvcsample.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.charlezz.mvcsample.R;
import com.charlezz.mvcsample.model.Person;

public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    Button delete;
    HolderClickListener listener;
    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        delete = itemView.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener !=null){
                    listener.onDeleteClick(MainViewHolder.this);
                }
            }
        });
    }

    public void setPerson(Person person){
        name.setText(person.getName());
    }

    public void setOnHolderClickListener(HolderClickListener listener) {
        this.listener = listener;
    }

    public interface HolderClickListener{
        void onDeleteClick(MainViewHolder viewHolder);
    }
}
