package com.google.news.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.news.R;
import com.google.news.adapter.FragmentAdapter;
import com.google.news.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment {
    private ImageView newsImage;
    private TextView newsTitle, newsContent;
    private RecyclerView fragmentRec;
    private List<NewsBean> newsBeans = new ArrayList<>();
    private NewsBean newsBean;
    private FragmentAdapter fragmentAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        newsBean = (NewsBean) bundle.getSerializable("news");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        newsBeans.add(new NewsBean(R.mipmap.news1, "Scientists create tougher coral in race to future-proof reef", "With bleaching events expected to increase to once a year by 2046, researchers in Western Australia hope coral crossbred to survive in higher temperatures will help save the Ningaloo Reef."));
        newsBeans.add(new NewsBean(R.mipmap.news2, "Complete T-rex skeleton named 'Trinity' sells for $8 million at Zurich auction", "The composite skeleton, featuring 293 bones, was the showpiece of an auction that featured some 70 lots, with the skull on display next to the auctioneer's podium throughout."));
        newsBeans.add(new NewsBean(R.mipmap.news3, "How Australia was overtaken in the electric vehicle race as global sales go 'exponential'", "The composite skeleton, featuring 293 bones, was the showpiece of an auction that featured some 70 lots, with the skull on display next to the auctioneer's podium throughout."));
        newsBeans.add(new NewsBean(R.mipmap.news4, "One-in-five 'choice' super funds 'significantly underperformed' with high fees and low returns", "Hundreds of thousands of superannuation customers are losing out, staying in dud funds with high fees, according to the latest data from the industry's regulator."));
        newsBeans.add(new NewsBean(R.mipmap.news5, "Press F to pay respects to Microsoft-Activision merger as UK regulator blocks deal", "The UK's competition authority refuses to allow Microsoft's multi-billion-dollar acquisition of Activision, ruling such market dominance would suppress innovation in new technologies like cloud gaming."));

        newsImage = view.findViewById(R.id.newsImage);
        newsTitle = view.findViewById(R.id.newsTitle);
        newsContent = view.findViewById(R.id.newsContent);
        fragmentRec = view.findViewById(R.id.fragmentRec);
        fragmentRec.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        fragmentAdapter = new FragmentAdapter(getContext(), newsBeans);
        fragmentRec.setAdapter(fragmentAdapter);
        fragmentAdapter.setOnItemClickListener(new FragmentAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, NewsBean newsBean) {
                newsImage.setImageResource(newsBean.getImageId());
                newsTitle.setText(newsBean.getNewsTitle());
                newsContent.setText(newsBean.getNewsContent());
            }
        });

        newsImage.setImageResource(newsBean.getImageId());
        newsTitle.setText(newsBean.getNewsTitle());
        newsContent.setText(newsBean.getNewsContent());
        return view;
    }
}