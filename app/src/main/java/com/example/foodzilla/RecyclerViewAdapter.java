package com.example.foodzilla;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<EventClass> events;
    private Context mContext;

    public RecyclerViewAdapter(List<EventClass> events, Context mContext) { //RecyclerViewAdapter constructor, what creates the recyclerViewAdapter
        this.events = events; //Setting the Contacts arraylist created above to the Contacts list passed in
        this.mContext = mContext; //pass in the context of the activity, which is passed into the constructor

    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //determines how each view is created
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        //Inflate the view, taking from the user_item layout, which is just the specific xml for a single Contact
        //Check out the user_item layout to see what I'm talking about
        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view); //Create a new viewholder, need this
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textViewRDate.setText(events.get(position).eventdate);
        holder.textViewName.setText(events.get(position).eventname);
    }


    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder { //class to hold each individual view to display to your recyclerview
        //basically holds the user_item

        TextView textViewName; //imageView from user_item
        TextView textViewRDate;
        RelativeLayout parentlayout; //references who the parent is and the specific layout of the parent,
        //so you know where the imageView and textView are contained

        public ViewHolder(@NonNull View view) { //ViewHolder constructor
            super(view);

            textViewRDate = itemView.findViewById(R.id.textViewRDate);
            parentlayout = itemView.findViewById(R.id.RelativeView);
            textViewName = itemView.findViewById(R.id.textViewRName);
        }
    }
}

