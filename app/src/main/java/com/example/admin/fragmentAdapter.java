package com.example.admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class fragmentAdapter extends FragmentPagerAdapter {


    public fragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public fragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new orders();
            case 1:
                return new addItem();
            case 2:
                return new stock();
            default: return new orders();

        }


    }

    @Override
    public int getCount() {
        return 0;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title=null;
        if (position==0)
        {
            title="ORDERS";
        }
       else if (position==1)
        {
            title="ADD ITEM";
        }
        else if (position==2)
        {
            title="STOCK";
        }
        return title;
    }
}
