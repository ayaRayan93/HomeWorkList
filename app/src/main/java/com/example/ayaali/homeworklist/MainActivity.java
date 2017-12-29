package com.example.ayaali.homeworklist;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.ayaali.homeworklist.adapter.HomeWorkAdapter;
import com.example.ayaali.homeworklist.app.AppController;
import com.example.ayaali.homeworklist.fragment.ListFragment;
import com.example.ayaali.homeworklist.json.Parser;
import com.example.ayaali.homeworklist.models.HomeWork;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected HomeWorkAdapter itemAdapter;
    protected List<HomeWork> dataSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment listitemsfragment=new ListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.item_container, listitemsfragment).commit();
    }


  public  void initiateRefresh()
    {
        String Url;

            Url="http://demo.zagel-app.com/api/manager/Get_Report_Notfication_visibleExpectSystem/en?PId=9062&appId=3&ChId=6081&IsNotHidden=1";
        /**
         * Execute the background task, which uses {@link AsyncTask} to load the data.
         */
        // We first check for cached request

        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(Url);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                clearDataSet();
                Iterator iterator = Parser.parseStringToJson(data).iterator();
                while (iterator.hasNext()){
                    HomeWork movie = (HomeWork)iterator.next();
                    dataSet.add(movie);
                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }

        /////////////connection//////////
        StringRequest strReq = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Log.d("response", response);
                clearDataSet();
                Iterator iterator = Parser.parseStringToJson(response).iterator();
                while (iterator.hasNext()){
                    HomeWork movie = (HomeWork)iterator.next();
                    dataSet.add(movie);


                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // Stop the refreshing indicator
                Log.d("response", error.toString());
            }
        });

        // Adding request to volley request queue
        AppController.getInstance().addToRequestQueue(strReq);

    }
    private void clearDataSet()
    {
        if (dataSet != null){
            dataSet.clear();
//            itemAdapter.notifyDataSetChanged();
        }
    }
}
