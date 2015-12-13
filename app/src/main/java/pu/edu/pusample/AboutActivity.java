package pu.edu.pusample;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new MyViewPagerAdapter(generateViewList()));
    }

    private List<View> generateViewList() {
        final LayoutInflater inflater = getLayoutInflater().from(this);
        ArrayList<View> viewList = new ArrayList<>();

        View v1 = inflater.inflate(R.layout.about_view, null);
        View v2 = inflater.inflate(R.layout.about_view, null);
        View v3 = inflater.inflate(R.layout.about_view, null);

        ImageView bg1 = (ImageView) v1.findViewById(R.id.background);
        bg1.setImageResource(R.mipmap.lin);
        ImageView bg2 = (ImageView) v2.findViewById(R.id.background);
        bg2.setImageResource(R.mipmap.wang);
        ImageView bg3 = (ImageView) v3.findViewById(R.id.background);
        bg3.setImageResource(R.mipmap.sung);

        TextView name1 = (TextView) v1.findViewById(R.id.name);
        name1.setText("組員A");
        TextView name2 = (TextView) v2.findViewById(R.id.name);
        name2.setText("組員B");
        TextView name3 = (TextView) v3.findViewById(R.id.name);
        name3.setText("組員C");

        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        return viewList;
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private List<View> mListViews;

        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;
        }

        @Override
        public int getCount() {
            return mListViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mListViews.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }

}
