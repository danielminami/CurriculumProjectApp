package com.danielminami.curriculumprojectapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class fragment_personal_data extends android.support.v4.app.Fragment{

    View myView;
    ImageView imgGitHub, imgLinkedIn;
    TextView txtEmail, txtPhone, txtLocation;
    String url;
    Intent i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_personal_data, container, false);


        imgGitHub = (ImageView) myView.findViewById(R.id.img_github);
        imgLinkedIn = (ImageView) myView.findViewById(R.id.img_linkedin);
        txtEmail = (TextView) myView.findViewById(R.id.txt_email);
        txtPhone = (TextView) myView.findViewById(R.id.txt_phone);
        txtLocation = (TextView) myView.findViewById(R.id.txt_location);

        imgGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = getString(R.string.url_github);
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        imgLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = getString(R.string.url_linkedin);
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        txtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = getString(R.string.url_linkedin);
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        txtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = getString(R.string.phone_number);
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
                startActivity(i);
            }
        });

        txtLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = getString(R.string.url_location);
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        return myView;
    }
}
