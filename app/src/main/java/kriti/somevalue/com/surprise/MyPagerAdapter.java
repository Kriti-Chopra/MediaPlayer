package kriti.somevalue.com.surprise;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0: return new Fragment1();
            case 1: return new Fragment2();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
