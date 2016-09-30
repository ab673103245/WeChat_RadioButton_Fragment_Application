package qianfeng.radiobuttonfragmentviewpager_application;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        rg = (RadioGroup) findViewById(R.id.rg);


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ChatFragment());
        fragments.add(new FriendFragment());
        fragments.add(new MomentsFragment());
        fragments.add(new MineFragment());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(myFragmentPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 自由滑动结束的时候，会调用这个方法，即第三个方法的状态变成 1--> 2-->0(非首尾两页) 时 或 1--->0(第一页和最后一页)，会调用这个方法
                RadioButton childAt = (RadioButton) rg.getChildAt(position);
                childAt.setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.chat:
                        // 有一个方法，是可以指定ViewPager当前显示的Item的
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.friend:
                        // 有一个方法，是可以指定ViewPager当前显示的Item的
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.moments:
                        // 有一个方法，是可以指定ViewPager当前显示的Item的
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.mine:
                        // 有一个方法，是可以指定ViewPager当前显示的Item的
                        viewPager.setCurrentItem(3);
                        break;

                }
            }
        });
    }
}
