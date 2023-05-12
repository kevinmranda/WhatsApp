package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class ChatsActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bot_nav);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.chats);

        ListView listView = findViewById(R.id.list_view);

        // Sample data
        ArrayList<String> users = new ArrayList<>();
        users.add("Kevin Mranda");
        users.add("Edwin Sanga");
        users.add("Joram Mkwavi");
        users.add("Abdulrazack Juma");
        users.add("Saraphina Adriano");

        ArrayList<String> messages = new ArrayList<>();
        messages.add("Uko wapi?");
        messages.add("Venue ni TT3-2");
        messages.add("I'm on my way");
        messages.add("Oyaa ndo naamka mwanangu");
        messages.add("Have you watched, how I met your mother?");

        CustomAdapter adapter = new CustomAdapter(this, users, messages);
        listView.setAdapter(adapter);

    }

    public static class CustomAdapter extends ArrayAdapter<String> {
        private final Context mContext;
        private final ArrayList<String> mUsers;
        private final ArrayList<String> mMessages;

        public CustomAdapter(Context context, ArrayList<String> users, ArrayList<String> messages) {
            super(context, R.layout.list_item, users);
            mContext = context;
            mUsers = users;
            mMessages = messages;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItem = convertView;
            if (listItem == null) {
                listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            }

            ImageView profileImage = listItem.findViewById(R.id.profile_image);
            TextView username = listItem.findViewById(R.id.username);
            TextView message = listItem.findViewById(R.id.message);

            // Set the data for the views
            profileImage.setImageResource(R.drawable.kevin);
            username.setText(mUsers.get(position));
            message.setText(mMessages.get(position));

            return listItem;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.status:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(0, 0);
                return true;
            case R.id.chats:
                return true;
            case R.id.communities:
                startActivity(new Intent(getApplicationContext(), CommunityActivity.class));
                overridePendingTransition(0, 0);
                return true;
        }
        return false;
    }
}