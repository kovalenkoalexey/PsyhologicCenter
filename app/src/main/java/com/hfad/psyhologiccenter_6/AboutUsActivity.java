package com.hfad.psyhologiccenter_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        TextView main, about, contacts;

        main = (TextView) findViewById(R.id.main_scene);
        about = (TextView) findViewById(R.id.about);
        contacts = (TextView) findViewById(R.id.contacts);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AboutUsActivity.this, CenterActivity.class);
                startActivity(mainIntent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactsIntent = new Intent(AboutUsActivity.this, ContactsActivity.class);
                startActivity(contactsIntent);
            }
        });
    }
}