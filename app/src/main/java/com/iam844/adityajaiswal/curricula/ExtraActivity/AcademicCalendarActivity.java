package com.iam844.adityajaiswal.curricula.ExtraActivity;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.iam844.adityajaiswal.curricula.R;

import java.util.Calendar;

public class AcademicCalendarActivity extends AppCompatActivity {

    WebView mWebView;
    String url = "http://iiitsurat.ac.in/academic-calendar.html";
    Calendar mCalendar;
    SwipeRefreshLayout mAcademicCalendarSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_calendar);

        Toolbar toolbar = findViewById(R.id.toolbar_academic_calendar);
        setSupportActionBar(toolbar);

        mCalendar = Calendar.getInstance();

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Academic Calendar " + mCalendar.get(Calendar.YEAR));
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView.setWebContentsDebuggingEnabled(true);
        mWebView = findViewById(R.id.academic_calendar_webview);
        mWebView.setVerticalScrollBarEnabled(true);
        mWebView.requestFocus();
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        mWebView.loadUrl(url);

        /*
         * Sets up a SwipeRefreshLayout.OnRefreshListener that is invoked when the user
         * performs a swipe-to-refresh gesture.
         */
        mAcademicCalendarSwipeRefreshLayout = findViewById(R.id.academic_calendar_swiperefresh);
        mAcademicCalendarSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.i("ACADEMIC CALENDAR", "onRefresh called from SwipeRefreshLayout");

                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.
                        myUpdateOperation();
                    }
                }
        );
    }

    private void myUpdateOperation() {
        mWebView.loadUrl(url);
    }

}
