package com.hfad.psyhologiccenter_6;

/*import androidx.*;*/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orger_page);

        TextView main, about, contacts;

        Button clearBtn;

        clearBtn = (Button) findViewById(R.id.clear_btn);

        main = (TextView) findViewById(R.id.main_scene);
        about = (TextView) findViewById(R.id.about);
        contacts = (TextView) findViewById(R.id.contacts);

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> coursesTitle = new ArrayList<>();
        for (Course c: CenterActivity.fullCoursesList) {
            if (Order.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(OrderPage.this, CenterActivity.class);
                startActivity(mainIntent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(OrderPage.this, AboutUsActivity.class);
                startActivity(aboutIntent);
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactsIntent = new Intent(OrderPage.this, ContactsActivity.class);
                startActivity(contactsIntent);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orders_list.setAdapter(null);
            }
        });
    }
}