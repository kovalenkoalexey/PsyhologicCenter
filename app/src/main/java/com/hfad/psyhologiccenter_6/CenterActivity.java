package com.hfad.psyhologiccenter_6;

/*import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;*/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.psyhologiccenter_6.CategoryAdapter;
import com.hfad.psyhologiccenter_6.CourseAdapter;
import com.hfad.psyhologiccenter_6.Category;
import com.hfad.psyhologiccenter_6.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CenterActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);

        TextView main, about, contacts;

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Отношения"));
        categoryList.add(new Category(2, "Интеллект"));
        categoryList.add(new Category(3, "Развитие"));
        //categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course(1, "vm", "Мужчина и женщина", " 1 января", "углубленный", "#BF3030", "Гармонизация отношений в диаде", 1));
        courseList.add(new Course(2, "brain", "Развитие интеллекта", "10 января", "начальный", "#408DD2", "Развитие когнитивных способносней" +
                " личности. Исследование памяти, внимания, мышления", 2));
        courseList.add(new Course(3, "abstract", "Нейрографика", "10 января", "начальный", "#E339A4", "Создание новых нейронных связей" +
                ", разрушение стереотипного мышления", 2));
        courseList.add(new Course(4, "growth", "Личностный рост", "10 января", "углубленный", "#9FA520", "Самосовершенствование и" +
                " самоопределение в карьере", 3));
        courseList.add(new Course(5, "fantasy", "Психология сна\nи фантазий", "10 января", "начальный", "#34D800", "Работа с бессознетельными" +
                " явлениями и из трансформая в сознательную жизнь", 3));

        fullCoursesList.addAll(courseList);


        setCourseRecycler(courseList);

        main = (TextView) findViewById(R.id.main_scene);
        about = (TextView) findViewById(R.id.about);
        contacts = (TextView) findViewById(R.id.contacts);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(CenterActivity.this, AboutUsActivity.class);
                startActivity(aboutIntent);
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactsIntent = new Intent(CenterActivity.this, ContactsActivity.class);
                startActivity(contactsIntent);
            }
        });
    }

    public void openShoppingCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showCoursesByCategory(int category) {

        courseList.clear();
        courseList.addAll(fullCoursesList);

        List<Course> filterCourses = new ArrayList<>();

        for (Course c: courseList) {
            if (c.getCategory() == category)
                filterCourses.add(c);
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();

    }
}