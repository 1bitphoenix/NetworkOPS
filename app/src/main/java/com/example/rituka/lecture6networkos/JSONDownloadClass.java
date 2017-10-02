package com.example.rituka.lecture6networkos;

import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by rituka on 2/10/17.
 */

public class JSONDownloadClass extends AsyncTask <String, Void, ArrayList<Post>> {
    String data=null;
    ArrayList<Post> postlist=new ArrayList<>();
    public static final String TAG="JSON";

    @Override
    protected ArrayList<Post> doInBackground(String... strings) {

        try{
            URL  url=new URL(strings[0]);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            InputStreamReader is=new InputStreamReader(connection.getInputStream());
            BufferedReader bf=new BufferedReader(is);
            StringBuilder builder=new StringBuilder();
            String buffer="" ;
            while(buffer!=null){
                builder.append(buffer);
                buffer=bf.readLine();
            }
            data=builder.toString();

        }catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }

        try{
            JSONArray jsonArray=new JSONArray(data);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                Post post=new Post(
                        jsonObject.getInt("id"),
                        jsonObject.getString("title")
                );
                postlist.add(post);
            }
            return postlist;
        }catch (JSONException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
