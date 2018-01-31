package com.example.ankhleu.trackingyourspendingv3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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

import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ankhleu.trackingyourspendingv3.tripdata.tripDAO;
import com.example.ankhleu.trackingyourspendingv3.tripdata.tripDetail;
import com.example.ankhleu.trackingyourspendingv3.tripdata.tripDetailDAO;
import com.example.ankhleu.trackingyourspendingv3.tripdata.trip_constructor;
import com.example.ankhleu.trackingyourspendingv3.tripdata.tripadd;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static tripDAO dao;//建立活動用
    public static tripDetailDAO dao2;  //這是加資料用
    ListView lv;
    ArrayList<String> tripname;
    ArrayAdapter<String> adapter;
    FloatingActionButton fb1,fb2,fb3;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        fb1 = (FloatingActionButton)findViewById(R.id.floatingActionButton3);
        fb2 = (FloatingActionButton)findViewById(R.id.floatingActionButton2);
        fb3 = (FloatingActionButton)findViewById(R.id.floatingActionButton);

 /*       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/

        dao = new tripadd(this);  //一定要有一個new放資料
        dao2 = new tripDetail(this);

        tripname = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,tripname);
        lv= findViewById(R.id.listview);
 //       lv.setAdapter(adapter);  //此處暫時註解，避免app無法運行，app可以運行但仍value傳不回listview


    }
    @Override
    protected void onResume() {
        super.onResume();
//        lv = findViewById(R.id.listview);
//        ArrayList<String> tripname = new ArrayList<>();
//        for (tripadd t :dao.getList())
//        {
//            tripname.add(t.)
//        }

//        refreshData();
    }
    public void refreshData()
    {
        tripname.clear();
        for (trip_constructor t : dao.getList())
        {
            tripname.add(t.title);
        }
        adapter.notifyDataSetChanged();
    }




/*    public void clickgo (View v)
    {
        Intent it = new Intent(MainActivity.this,Newstart.class);
        startActivity(it);
    }
    public void clickgo2 (View v)
    {
        Intent it = new Intent(MainActivity.this,Tripadddetail.class);
        startActivity(it);
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
        Intent it4=new Intent(this,SettingsActivity.class);
        startActivity(it4);

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;

        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            if (position == 0)   //此處用position==0，連接到FragmentBill
            {
                return FragmentBill.newInstance("Bill", "receipt");
            }
            if (position==1)   //此處用position==1，連接到FragmentReceipt
            {
                return FragmentReceipt.newInstance("Receipt","receipt");
            }

            if (position==2)   //此處用position==2，連接到FragmentAnalysis
            {
                return FragmentAnalysis.newInstance("Analysis","receipt");
            }



            return MainActivity.PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}
