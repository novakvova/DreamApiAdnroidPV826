package com.example.dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dream.newsview.NewsCardRecyclerViewAdapter;
import com.example.dream.newsview.NewsGridItemDecoration;
import com.example.dream.newsview.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsCardRecyclerViewAdapter adapter;
    private List<NewsModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = findViewById(R.id.recycler_view);

        setRecyclerView();
    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false));
        list = new ArrayList<>();
        NewsModel model = new NewsModel("https://www.growthengineering.co.uk/wp-content/uploads/2014/07/To-Do-List.png", "Hello");
        list.add(model);
        adapter = new NewsCardRecyclerViewAdapter(list);

        recyclerView.setAdapter(adapter);
    }
}