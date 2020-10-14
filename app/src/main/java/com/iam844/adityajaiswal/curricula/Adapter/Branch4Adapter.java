package com.iam844.adityajaiswal.curricula.Adapter;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.iam844.adityajaiswal.curricula.Fragment.CSE4Fragment;
import com.iam844.adityajaiswal.curricula.Fragment.ECE4Fragment;
import com.iam844.adityajaiswal.curricula.R;

public class Branch4Adapter extends FragmentPagerAdapter {

    private Context mContext;

    public Branch4Adapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new CSE4Fragment();
        } else {
            return new ECE4Fragment();
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
            return mContext.getString(R.string.CSE);
        } else {
            return mContext.getString(R.string.ECE);
        }
    }
}
