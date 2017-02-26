
package com.example.monika.youtubetry1;

        import android.provider.MediaStore;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import java.net.URL;
        import java.util.ArrayList;
        import java.util.List;

        import org.json.JSONArray;
        import org.json.JSONObject;
        import com.example.monika.youtubetry1.R;
        import com.google.android.youtube.player.internal.v;

        import android.os.AsyncTask;
        import android.accounts.AccountManager;
        import android.accounts.AccountManagerCallback;
        import android.accounts.AccountManagerFuture;
        import android.app.Activity;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.v7.widget.CardView;
        import android.util.Log;
        import android.view.KeyEvent;
        import android.view.Menu;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

public class Playlist_view extends AppCompatActivity  implements AdapterView.OnItemClickListener{


    private ArrayList<Video> videoArrayList;
    //    private ArrayList<Video> videoArrayList1;
    private ListView listVideo;
    private VideoAdapter videoAdapter;
    // private String auth_token;
    private Video vObject;
    private Video vObject1;
    private JsonParser parserVideo;
    ImageView  img_java,img_oops;
    TextView java_java,oops;
    //    private JsonParser parserVideo1;
    private ProgressDialog progress;
    String abc  = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_view);

        listVideo = (ListView) findViewById(R.id.videolist);
        parserVideo = new JsonParser();

        videoArrayList = new ArrayList<Video>();
        listVideo.setOnItemClickListener(this);
        listVideo.setAdapter(videoAdapter);


        abc = getIntent().getExtras().get("abc").toString();


        new Async().execute();

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();

        }

        return super.onKeyDown(keyCode, event);
    }

    public void onBackPressed() {
        Intent myIntent = new Intent(Playlist_view.this, MainActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// clear back stack
        startActivity(myIntent);
        finish();
        return;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override

    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        // TODO Auto-generated method stub
        // here we are getting the index of listview and through this we are getting the youtube video id
//        vObject1=videoArrayList1.get(position);
//        String video1=vObject1.getVideoId();
        vObject=videoArrayList.get(position);
        String video=vObject.getVideoId();
        Intent inFullScreenDemo=new Intent(Playlist_view.this,FullScreenDemoActivity.class);
        inFullScreenDemo.putExtra("video",video);
        inFullScreenDemo.putExtra("abc",abc);
        inFullScreenDemo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inFullScreenDemo);
//        List<URL> playistUrl=new ArrayList<>();
//        playistUrl.add(0,https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7oZ-fxDYkOToURHhMuWD1BK&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE);

    }

    public ArrayList<Video>parsingJson(String videoUrl){
        try {
            JSONObject json=parserVideo.getJsonFromYoutube(videoUrl);
//            JSONObject json1=parserVideo.getJsonFromYoutube2(videoUrl);
            JSONArray jArray=new JSONArray(json.getString("items"));
            for(int i=0;i<jArray.length();i++){
                JSONObject thumbnail=jArray.getJSONObject(i);
                JSONObject snippets=thumbnail.getJSONObject("snippet");
                JSONObject defaulturl=snippets.getJSONObject("thumbnails");
                JSONObject url=defaulturl.getJSONObject("high");
                JSONObject resourceId=snippets.getJSONObject("resourceId");
                String videoId=resourceId.getString("videoId");
                String imageurl=url.getString("url");
                String title=snippets.getString("title");
                vObject=new Video(title, imageurl, videoId);
                videoArrayList.add(i,vObject);
                //Log.e("videoArrayList",""+videoArrayList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videoArrayList;
    }


    ///This class is used to do some background task.
    //Here in this blog, we are using it for parsing the JSON data
    //that we are getting from youtube.
    public class Async extends AsyncTask<String,String,String> {
        ArrayList<Video> videolist;
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            progress=new ProgressDialog(Playlist_view.this);
            progress.setMessage("Loading data...");
            progress.show();
        }
        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            try {
                if (abc.equals("Java"))
                {
                    videolist = parsingJson(parserVideo.java4);
                    videolist = parsingJson(parserVideo.java3);
                    videolist = parsingJson(parserVideo.java2);
                    videolist = parsingJson(parserVideo.java1);
                }
                 else if (abc.equals("Android"))
                  {
                      videolist = parsingJson(parserVideo.android1);
                  }

                else if(abc.equals("Servlet"))
                {
                    videolist = parsingJson(parserVideo.servlet);
                }
                else if(abc.equals("Msql"))
                {
                    videolist = parsingJson(parserVideo.msqltutorial);
                }
                else if(abc.equals("JDBC"))
                {
                    videolist = parsingJson(parserVideo.jdbc);
                }
                else if(abc.equals("Sql"))
                {
                    videolist = parsingJson(parserVideo.sql);
                }
                else if(abc.equals("Clang"))
                {
                    videolist = parsingJson(parserVideo.clang);
                }
                else if(abc.equals("Collections"))
                {
                    videolist = parsingJson(parserVideo.collections);
                }
                else if(abc.equals("Multi"))
                {
                    videolist = parsingJson(parserVideo.multi);
                }
                else if(abc.equals("Spring"))
                {
                    videolist = parsingJson(parserVideo.spring);
                }
                else if(abc.equals("Exception"))
                {
                    videolist = parsingJson(parserVideo.exception);
                }
                else if(abc.equals("MVC"))
                {
                    videolist = parsingJson(parserVideo.mvc);
                }
                else if(abc.equals("XML"))
                {
                    videolist = parsingJson(parserVideo.xmllang);
                }
                else if(abc.equals("Inner"))
                {
                    videolist = parsingJson(parserVideo.inner);
                }
                else if(abc.equals("Enum"))
                {
                    videolist = parsingJson(parserVideo.enume);
                }
                else if(abc.equals("Java8"))
                {
                    videolist = parsingJson(parserVideo.java8);
                }
                else if(abc.equals("RMI"))
                {
                    videolist = parsingJson(parserVideo.rmi);
                }
                else if(abc.equals("I18"))
                {
                    videolist = parsingJson(parserVideo.I18);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_LONG).show();
                }
                //through this method we are parsing the data
            }catch (Exception e) {
                // TODO: handle exception
                finish(); //If some exception occur we are killing the application

            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            try{
                //videoAdapter class is used to customized the ListView
                videoAdapter=new VideoAdapter(Playlist_view.this,videolist,Playlist_view.this.getContentResolver(),Playlist_view.this.getResources());
                listVideo.setAdapter(videoAdapter);
                listVideo.setFastScrollEnabled(true);
                progress.dismiss();  // Here we are closing the progress dialog after completing the background task.
            }catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
