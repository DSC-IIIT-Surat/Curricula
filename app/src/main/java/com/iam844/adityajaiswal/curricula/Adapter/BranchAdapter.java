package com.iam844.adityajaiswal.curricula.Adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.iam844.adityajaiswal.curricula.Fragment.CSEFragment;
import com.iam844.adityajaiswal.curricula.Fragment.ECEFragment;
import com.iam844.adityajaiswal.curricula.R;

public class BranchAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String semesterCode;

    public BranchAdapter(Context context, FragmentManager fm, String semCode) {
        super(fm);

        mContext = context;
        semesterCode = semCode;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new CSEFragment(semesterCode);
        } else {
            return new ECEFragment(semesterCode);
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
