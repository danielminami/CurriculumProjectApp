package com.danielminami.curriculumprojectapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class fragment_work_experience extends Fragment {

    ImageView img_test;
    View myView;
    String url;
    Intent i;

    public static fragment_work_experience newInstance() {
        return new fragment_work_experience();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_working_experience, container, false);

        img_test = (ImageView) myView.findViewById(R.id.img_github);

        img_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = getString(R.string.url_github);
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        return myView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
