package com.iam844.adityajaiswal.curricula.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Model.Subject;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class SubjectAdapter extends ArrayAdapter {

    public SubjectAdapter(@NonNull Context context, int textViewResourceId, @NonNull ArrayList objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.subject_item, null);
        }

        Subject currentSub = (Subject) getItem(position);

        TextView subjectTextView = view.findViewById(R.id.subject_textView);
        TextView subjectCodeTextView = view.findViewById(R.id.subjectCode_textView);
        ImageView imageView = view.findViewById(R.id.subject_imageView);

        subjectTextView.setText(currentSub.getSubListName());
        subjectCodeTextView.setText(currentSub.getSubCodeListName());
        imageView.setImageResource(currentSub.getSubListImage());

        return view;
    }
}
