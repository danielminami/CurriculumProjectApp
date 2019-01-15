package com.danielminami.curriculumprojectapp.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.danielminami.curriculumprojectapp.Resources.CustomAdapter;
import com.danielminami.curriculumprojectapp.Model.Model_Language;
import com.danielminami.curriculumprojectapp.R;
import com.danielminami.curriculumprojectapp.Repository.Repository_Language;
import com.danielminami.curriculumprojectapp.Resources.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDoalog;
    public CustomAdapter adapter;
    public RecyclerView recyclerView;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }

    private void generateDataList(ArrayList<Model_Language> list) {

    }

/*
    private void generateDataList(List<Model_Language> list) {
        String name = list.
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_github) {
            String url = getString(R.string.url_github_curriculum);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            int page = getArguments().getInt(ARG_SECTION_NUMBER);

            if (page == 1){
                View rootView = inflater.inflate(R.layout.fragment_personal_data, container, false);

                ImageView imgGitHub, imgLinkedIn;
                TextView txtEmail, txtPhone, txtLocation;

                imgGitHub = (ImageView) rootView.findViewById(R.id.img_github);
                imgLinkedIn = (ImageView) rootView.findViewById(R.id.img_linkedin);
                txtEmail = (TextView) rootView.findViewById(R.id.txt_email);
                txtPhone = (TextView) rootView.findViewById(R.id.txt_phone);
                txtLocation = (TextView) rootView.findViewById(R.id.txt_location);

                imgGitHub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = getString(R.string.url_github);
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });

                imgLinkedIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = getString(R.string.url_linkedin);
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });

/*                txtEmail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_SENDTO);
                        i.setType("mailto");
                        i.putExtra(Intent.EXTRA_EMAIL, getString(R.string.email));
                        i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
                        i.putExtra(Intent.EXTRA_TEXT,"Test");
                        //i.putExtra(Intent.EXTRA_STREAM, attachment);
                        startActivity(i);
                    }
                });*/

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
                        String url = getString(R.string.url_location);
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });

                return rootView;

            } else if (page == 2) {

                View rootView = inflater.inflate(R.layout.fragment_work_experience, container, false);

                return rootView;

            } else if (page == 3) {

                View rootView = inflater.inflate(R.layout.fragment_education, container, false);

                return rootView;

            } else if (page == 4) {

                View rootView = inflater.inflate(R.layout.fragment_award, container, false);

                TextView txtGitHub = (TextView)  rootView.findViewById(R.id.txt_asf_github);

                txtGitHub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = getString(R.string.url_github_asf);
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });

                return rootView;

            } else if (page == 5) {

                View rootView = inflater.inflate(R.layout.fragment_skill, container, false);
                ((MainActivity)getActivity()).recyclerView = rootView.findViewById(R.id.customRecyclerView);
                ((MainActivity)getActivity()).adapter = new CustomAdapter(getActivity(),new ArrayList<Model_Language>());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                ((MainActivity)getActivity()).recyclerView.setLayoutManager(layoutManager);
                ((MainActivity)getActivity()).recyclerView.setAdapter(((MainActivity)getActivity()).adapter);


                Repository_Language service = RetrofitClientInstance.getRetrofitInstance().create(Repository_Language.class);
                Call<List<Model_Language>> call = service.getAllModel_Language();
                call.enqueue(new Callback<List<Model_Language>>() {
                    @Override
                    public void onResponse(Call<List<Model_Language>> call, Response<List<Model_Language>> response) {
                        //generateDataList(new ArrayList<Model_Language>(response.body()));
                        ((MainActivity)getActivity()).adapter.setList(new ArrayList<Model_Language>(response.body()));
                        ((MainActivity)getActivity()).adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<Model_Language>> call, Throwable t) {
                        Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });

                return rootView;
            }

            return null;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Return the total pages.
            return 5;
        }
    }
}
