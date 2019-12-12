package com.example.foodzilla;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Contact> Contacts = new ArrayList<Contact>();
    private Context mContext;
    private OnNoteListener mOnNoteListener;



    public RecyclerViewAdapter(List<Contact> Contacts, Context mContext, OnNoteListener onNoteListener){ //RecyclerViewAdapter constructor, what creates the recyclerViewAdapter
        this.Contacts = Contacts; //Setting the Contacts arraylist created above to the Contacts list passed in
        this.mContext = mContext; //pass in the context of the activity, which is passed into the constructor
        this.mOnNoteListener = onNoteListener;
    }




    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //determines how each view is created
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewevents, parent, false);
        //Inflate the view, taking from the user_item layout, which is just the specific xml for a single Contact
        //Check out the user_item layout to see what I'm talking about
        ViewHolder viewHolder = new ViewHolder(view, mOnNoteListener); //Create a new viewholder, need this
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView1.setText(Contacts.get(position).name);
        holder.textView2.setText(Contacts.get(position).date);

    }

    @Override
    public int getItemCount() {
        return  Contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //class to hold each individual view to display to your recyclerview
        //basically holds the user_item

        TextView textView1; //imageView from user_item
        TextView textView2; //textView from user_item
        RelativeLayout parentlayout; //references who the parent is and the specific layout of the parent,
        //so you know where the imageView and textView are contained

        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View view, OnNoteListener onNoteListener){ //ViewHolder constructor
            super(view);

            textView1 = itemView.findViewById(R.id.textViewRName);
            textView2 = itemView.findViewById(R.id.textViewRDate);
            parentlayout = itemView.findViewById(R.id.parentLayout);
            this.onNoteListener = onNoteListener;

            view.setOnClickListener(this);



        }

        @Override
        public void onClick(View view) {

            onNoteListener.onNoteClick(getAdapterPosition());

        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);


    }
}
