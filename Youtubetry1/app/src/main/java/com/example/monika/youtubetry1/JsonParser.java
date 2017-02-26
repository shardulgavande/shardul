package com.example.monika.youtubetry1;

/**
 * Created by monika on 27/1/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.util.Log;

public class JsonParser {

    public String java1="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7oZ-fxDYkOToURHhMuWD1BK&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String java2="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&pageToken=CDIQAA&playlistId=PLsyeobzWxl7oZ-fxDYkOToURHhMuWD1BK&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String java3="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&pageToken=CGQQAA&playlistId=PLsyeobzWxl7oZ-fxDYkOToURHhMuWD1BK&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String java4="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&pageToken=CJYBEAA&playlistId=PLsyeobzWxl7oZ-fxDYkOToURHhMuWD1BK&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String android1="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7p-lZvWabkVJdM_UVURhUh4&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String servlet="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7oGCz4k9VyxhfmQpSU1dV9b&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String msqltutorial="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7oJca2fwLyKbDwlKUDPl3RE&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String jdbc="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7rU7Jz3zDRpqB-EODzBbHOI&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String sql="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7r4_oAwBFzPdMlgc0If72WK&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String clang="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7oBxHp43xQTFrw9f1CDPR6C&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String collections="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7oJj5BXYF088REBm-K4c_SR&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String multi="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7rmuFYRpkqLanwoG4pQQ7oW&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String spring="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7rFkYFysfTwBu1JBPaNNDrk&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String exception="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7rS9B2K1l--VDpCn41gijnV&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String mvc="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7rjSO6xX00UWmVhL90i-cOk&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String xmllang="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7oanwaonj3iV3rxfTdEA2gC&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String inner="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7pL4Qy1ftJR0CB0NtjAotyD&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String enume="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7pqDkHDPUoy75HLb_JLnZIy&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String java8="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7qbvNnJKjYbkTLn2w3eRy1Q&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String rmi="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7p3NL3PupJMfUkoX6aabCg1&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";
    public String I18="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsyeobzWxl7quECrWxYywsFQlRjBX_O-m&key=AIzaSyBrcAIUf_OQRHo9B6W2UdQZwv324NGXmpE";


//You can change the playlistId
//You can change the maxResults from 30 to 50 only videos can be fetched at a time
//For more detail go to this link https://developers.google.com/youtube/v3/docs/playlistItems/list#try-it

    private static StringBuilder sb;
    private JSONObject jObj;
    public JsonParser() {
        // TODO Auto-generated constructor stub
    }

    public JSONObject getJsonFromYoutube(String url){
        DefaultHttpClient httpclient = new DefaultHttpClient();
        Log.e("java02",java1);
        Log.e("java2",java2);
        Log.e("java3",java3);
        Log.e("java4",java4);
        Log.e("android1",android1);
        Log.e("servlet",servlet);
        Log.e("msqltutorial",msqltutorial);
        Log.e("jdbc",jdbc);
        Log.e("sql",sql);
        Log.e("clang",clang);
        Log.e("collections",collections);
        Log.e("multi",multi);
        Log.e("spring",spring);
        Log.e("exception",exception);
        Log.e("mvc",mvc);
        Log.e("xmllang",xmllang);
        Log.e("inner",inner);
        Log.e("enume",enume);
        Log.e("java8",java8);
        Log.e("rmi",rmi);
        Log.e("I18",I18);



//        Log.e("url1",url1);
        HttpGet getRequest = new HttpGet(url);
        getRequest.setHeader("Accept", "application/json");
        // Use GZIP encoding
        getRequest.setHeader("Accept-Encoding", "gzip"); //
        try {
            HttpResponse response = (HttpResponse) httpclient
                    .execute(getRequest);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                Header contentEncoding = response.getFirstHeader("Content-Encoding");
                if (contentEncoding != null
                        && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
                    instream = new GZIPInputStream(instream);
                }
                // convert content stream to a String
                String result = readStream(instream);
                Log.i("JSON", result);
                instream.close();
                jObj = new JSONObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jObj;
    }

    private static String readStream(InputStream is) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);

            sb = new StringBuilder();

            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return sb.toString();
    }
}

