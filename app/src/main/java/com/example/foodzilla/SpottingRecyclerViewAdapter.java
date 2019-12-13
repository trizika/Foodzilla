package com.example.foodzilla;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SpottingRecyclerViewAdapter extends RecyclerView.Adapter<SpottingRecyclerViewAdapter.ViewHolder> {

    private List<FoodSpottingsClass> spottings;
    private Context mContext;

    public SpottingRecyclerViewAdapter(List<FoodSpottingsClass> spottings, Context mContext){ //RecyclerViewAdapter constructor, what creates the recyclerViewAdapter
        this.spottings = spottings; //Setting the Contacts arraylist created above to the Contacts list passed in
        this.mContext = mContext; //pass in the context of the activity, which is passed into the constructor

    }




    @NonNull
    @Override
    public SpottingRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //determines how each view is created
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        //Inflate the view, taking from the user_item layout, which is just the specific xml for a single Contact
        //Check out the user_item layout to see what I'm talking about
        ViewHolder viewHolder = new ViewHolder(view); //Create a new viewholder, need this
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView1.setText(spottings.get(position).location);
        holder.button.setText("Learn More");
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SpottingInfo.class);
                intent.putExtra("picReference", spottings.get(position).picturelocation);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return  spottings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder { //class to hold each individual view to display to your recyclerview
        //basically holds the user_item

        TextView textView1; //imageView from user_item
        Button button;
        RelativeLayout parentlayout; //references who the parent is and the specific layout of the parent,
        //so you know where the imageView and textView are contained

        public ViewHolder(@NonNull View view){ //ViewHolder constructor
            super(view);

            textView1 = itemView.findViewById(R.id.spottingname);
            parentlayout = itemView.findViewById(R.id.RelativeView);
            button = itemView.findViewById(R.id.infobutton);
        }
    }



}
