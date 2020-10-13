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
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1,
                GridLayoutManager.VERTICAL, false));
        list = new ArrayList<>();
        NewsModel model = new NewsModel("https://www.growthengineering.co.uk/wp-content/uploads/2014/07/To-Do-List.png", "Hello");
        list.add(model);
        NewsModel model1 = new NewsModel("https://i.guim.co.uk/img/media/20098ae982d6b3ba4d70ede3ef9b8f79ab1205ce/0_0_969_581/master/969.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=a368f449b1cc1f37412c07a1bd901fb5", "Навала короновіруса");
        list.add(model1);
        adapter = new NewsCardRecyclerViewAdapter(list);

        recyclerView.setAdapter(adapter);

        int largePadding = 16;
        int smallPadding = 4;
        recyclerView.addItemDecoration(new NewsGridItemDecoration(largePadding, smallPadding));
    }
}