package com.minminaya.coordinatebehavior;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.minminaya.coordinatebehavior.adapter.FragmentAdapter1;
import com.minminaya.coordinatebehavior.fragment.BlankFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoordinateToolBar4Activity extends AppCompatActivity {

    @BindView(R.id.tabLayout1)
    TabLayout tabLayout1;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.viewpager1)
    ViewPager viewpager1;


    private List<Fragment> fragments = new ArrayList<>();

    private List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_tool_bar3);
        ButterKnife.bind(this);

        for (int i = 0; i < 8; i++) {
            tabLayout1.addTab(tabLayout1.newTab().setText("Title" + i));
            fragments.add(new BlankFragment());
            titles.add("title" + i);
        }

        FragmentAdapter1 fragmentAdapter1 = new FragmentAdapter1(getSupportFragmentManager(), titles, fragments);

        viewpager1.setAdapter(fragmentAdapter1);

        tabLayout1.setupWithViewPager(viewpager1);

    }
}
