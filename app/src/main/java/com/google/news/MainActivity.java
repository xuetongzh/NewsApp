package com.google.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.news.adapter.HorizontalAdapter;
import com.google.news.adapter.VerticalAdapter;
import com.google.news.bean.NewsBean;
import com.google.news.fragment.DetailFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<NewsBean> newsBeans = new ArrayList<>();
    private RecyclerView horizontalRec, verticalRec;
    private LinearLayout group;
    private ImageView left, right;
    private int position = 1;
    private HorizontalAdapter horizontalAdapter;
    private VerticalAdapter verticalAdapter;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = findViewById(R.id.group);
        frameLayout = findViewById(R.id.main);

        newsBeans.add(new NewsBean(R.mipmap.news1, "Scientists create tougher coral in race to future-proof reef", "With bleaching events expected to increase to once a year by 2046, researchers in Western Australia hope coral crossbred to survive in higher temperatures will help save the Ningaloo Reef."));
        newsBeans.add(new NewsBean(R.mipmap.news2, "Complete T-rex skeleton named 'Trinity' sells for $8 million at Zurich auction", "The composite skeleton, featuring 293 bones, was the showpiece of an auction that featured some 70 lots, with the skull on display next to the auctioneer's podium throughout."));
        newsBeans.add(new NewsBean(R.mipmap.news3, "How Australia was overtaken in the electric vehicle race as global sales go 'exponential'", "The composite skeleton, featuring 293 bones, was the showpiece of an auction that featured some 70 lots, with the skull on display next to the auctioneer's podium throughout."));
        newsBeans.add(new NewsBean(R.mipmap.news4, "One-in-five 'choice' super funds 'significantly underperformed' with high fees and low returns", "Hundreds of thousands of superannuation customers are losing out, staying in dud funds with high fees, according to the latest data from the industry's regulator."));
        newsBeans.add(new NewsBean(R.mipmap.news5, "Press F to pay respects to Microsoft-Activision merger as UK regulator blocks deal", "The UK's competition authority refuses to allow Microsoft's multi-billion-dollar acquisition of Activision, ruling such market dominance would suppress innovation in new technologies like cloud gaming."));

        horizontalRec = findViewById(R.id.horizontalRec);
        horizontalRec.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        horizontalAdapter = new HorizontalAdapter(this, newsBeans);
        horizontalRec.setAdapter(horizontalAdapter);
        horizontalAdapter.setOnItemClickListener(new HorizontalAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, NewsBean newsBean) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("news", newsBean);
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.main, detailFragment).commitAllowingStateLoss();
                frameLayout.setVisibility(View.VISIBLE);
                group.setVisibility(View.GONE);
            }
        });

        verticalRec = findViewById(R.id.verticalRec);
        verticalRec.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        verticalAdapter = new VerticalAdapter(this, newsBeans);
        verticalRec.setAdapter(verticalAdapter);
        verticalAdapter.setOnItemClickListener(new VerticalAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, NewsBean newsBean) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("news", newsBean);
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.main, detailFragment).commitAllowingStateLoss();
                frameLayout.setVisibility(View.VISIBLE);
                group.setVisibility(View.GONE);
            }
        });

        left = findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position >= newsBeans.size()) return;
                horizontalRec.scrollToPosition(position++);
            }
        });

        right = findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < 0) return;
                horizontalRec.scrollToPosition(position--);
            }
        });


    }
}