package com.example.recyclerview.Model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerview.Data.Adapter;
import com.example.recyclerview.R;
import com.example.recyclerview.Util.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contactList = new ArrayList<>();
    RecyclerView recyclerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        contactList.add(new Contact("Tom Cruise", "tom@gmail.com","https://data.whicdn.com/images/88808216/original.jpg"));
        contactList.add(new Contact("Cris Hamesworth","cris@gmail.com", "https://media.newstracklive.com/uploads/entertainment-news/hollywood-news/Dec/25/big_thumb/ghh1_5e0330bc40062.jpg"));
        contactList.add(new Contact("Robert","robert@gmail.com", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRPyHbi4Kqupdu3v20WCRiXuAs9nDE8iulKQMeMy6OSVAFhr6ha&usqp=CAU"));
        contactList.add(new Contact("Raman", "raan@gmail.com", "https://qph.fs.quoracdn.net/main-qimg-5323f2445105c835706969efb1044a6e"));
        contactList.add(new Contact("Will Smith","will@gmail.com", "https://static.toiimg.com/photo/msid-69462387/69462387.jpg?83203"));
        contactList.add(new Contact("Jamai Dornan","jamd@gmail.com", "https://gazettereview.com/wp-content/uploads/2017/05/top-ten-hottest-hollywood-actors-jamie-dornan-236x300.jpg"));
        contactList.add(new Contact("Johny Deep","johny@gmail.com", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSlSmIoPH4ccWRXtLzPT3kxIQ_H5d1V7xYSmxInKjvvhJMwsCqx&usqp=CAU"));

        Adapter adapter = new Adapter(this);
        adapter.setContactList((ArrayList<Contact>) contactList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
