package com.iam844.adityajaiswal.curricula.Adapter;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.iam844.adityajaiswal.curricula.Fragment.IIYearDivAFragment;
import com.iam844.adityajaiswal.curricula.Fragment.IIYearDivBFragment;
import com.iam844.adityajaiswal.curricula.R;

public class SecondYearDivisionTimeTableAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SecondYearDivisionTimeTableAdapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new IIYearDivAFragment();
        } else {
            return new IIYearDivBFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return mContext.getString(R.string.DivisionA);
        } else {
            return mContext.getString(R.string.DivisionB);
        }
    }
}
