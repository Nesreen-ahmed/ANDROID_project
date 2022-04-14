package com.example.project;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class StartNotification extends BroadcastReceiver {

    SharedPreferences notifications;
    String channelName="كلية العلوم";
    String channel_id="ScienceNotification";
    NotificationChannel notificationChannel;
    NotificationManager Mng;
    NotificationCompat.Builder builder;
    NotificationManagerCompat NMC;
    SharedPreferences.Editor editor;
    int Notification_id=0;
    Context cxt;
    // NotificationChannel show;
    @Override
    public void onReceive(Context context, Intent intent) {
        cxt=context;
        notifications =context.getSharedPreferences("NOTIFICATIONS", Activity.MODE_PRIVATE);
        editor=notifications.edit();

        builder = new NotificationCompat.Builder(context,channel_id);
        NMC=NotificationManagerCompat.from(context);

        CheckWebPage check=new CheckWebPage();
        check.execute();
    }
    public void createdChannel()
    {
        notificationChannel =
                new NotificationChannel (channel_id, channelName, NotificationManager.IMPORTANCE_DEFAULT);

        notificationChannel.setDescription("مرحباً بك");

        Mng = (NotificationManager)cxt.getSystemService(cxt.NOTIFICATION_SERVICE);
        Mng.createNotificationChannel( notificationChannel );
    }
    public void createNotification(String title,String text)
    {
        createdChannel();
        Intent intent=new Intent(cxt,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(cxt,0,intent,0);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        builder.setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.science)
                .setContentIntent(pendingIntent).setAutoCancel(true)
                .setAutoCancel(true);
        ++Notification_id;
        NMC.notify(Notification_id,builder.build());
    }
    private class CheckWebPage extends AsyncTask<Void,Void,Void>
    {
        String news,events,adver;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... voids) {

            Document newsdoc = null,eventsdoc=null,adverdoc=null,bannerdoc=null;
            try{

                //=====================>news<======================
                newsdoc=Jsoup.connect("https://science.asu.edu.eg/ar/news").get();
                news=newsdoc.getElementsByClass("w-full lg:w-48% shadow-md mb-3 lg:mr-3 px-3").first().select("a[href]").first().attr("href").toString();
                if(!notifications.getString("firstnews","   ").equals(news))
                {
                    createNotification("الأخبار" ,newsdoc.getElementsByClass("w-full lg:w-48% shadow-md mb-3 lg:mr-3 px-3").first().getElementsByClass("col-lg-6 col-md-12").first().select("a[href]").first().text().toString());
                    editor.putString("firstnews",news);
                    editor.commit();
                }

                //====================>events<=====================
                eventsdoc=Jsoup.connect("https://science.asu.edu.eg/ar/events").get();
                events=eventsdoc.getElementsByClass("col-lg-6 col-md-12").first().select("a[href]").first().attr("href");
                if(! notifications.getString("firstevents","    ").equals(events))
                {
                    createNotification("الأحداث" ,eventsdoc.getElementsByClass("col-lg-6 col-md-12").first().getElementsByClass("max-h-12 overflow-ellipsis overflow-hidden").first().text().toString());
                    //createNotification("الأحداث" ,newsdoc.getElementsByClass("event-title").first().select("a[href]").first().text().toString());
                    editor.putString("firstevents",events);
                    editor.commit();
                }

                //====================>Adver<======================
                adverdoc=Jsoup.connect("https://science.asu.edu.eg/ar/announcements").get();
                adver=adverdoc.getElementsByClass("col-lg-4 col-md-6 mb-3").first().select("a[href]").first().attr("href");
                if(! notifications.getString("firstadver","    ").equals(adver))
                {
                    createNotification("الاعلانات" ,adverdoc.getElementsByClass("col-lg-4 col-md-6 mb-3").first().select("a[href]").first().text().toString());
                    editor.putString("firstadver",adver);
                    editor.commit();
                }


            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}