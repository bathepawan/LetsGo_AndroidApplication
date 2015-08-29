package com.letsgo;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by pbathe on 29/8/15.
 */
public class TabsPagerAdapter  extends FragmentPagerAdapter
{
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new SeekersFragment();
            case 1:
                return new OwnersFragment();
            case 2:
                return new AgenciesFragment();
            case 3:
                return new ChatsFragment();
        }

        return null;

    }
    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 4;
    }
}
