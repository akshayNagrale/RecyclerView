package com.example.recyclerview.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;
import com.example.recyclerview.Util.Contact;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Contact> contactList = new ArrayList<>();
    Context context;

    public Adapter(Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list, parent,false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, final int position) {
        holder.name.setText(contactList.get(position).getName());
        holder.email.setText(contactList.get(position).getEmail());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contactList.get(position).getName() + "Selected", Toast.LENGTH_SHORT).show();

            }
        });
        Glide.with(context)
                .asBitmap()
                .load(contactList.get(position).getImgUrl())
                .into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, email;
        private CardView parent;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            email = itemView.findViewById(R.id.txtEmail);
            parent = itemView.findViewById(R.id.parent);
            imageView = itemView.findViewById(R.id.imageView);
        }

    }
    public void setContactList(ArrayList<Contact> contactList){

        this.contactList = contactList;
        notifyDataSetChanged();

    }
}
