package com.example.library;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static final String ALL_COURSES_KEY = "all_courses";
    private static final String COMPLETED_COURSES = "completed_courses";
    private static final String WHISHLIST = "whishlist";
    private static final String ONGOING_COURSES = "ongoing_courses";
    private static final String FAV_COURSES = "fav_courses";

    private static Utils instance;
    private SharedPreferences sharedPreferences;
    

    private Utils(Context context){

        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if (null == getAllcources()){
           initData();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (null == getCompletedcources()){
            editor.putString(COMPLETED_COURSES,gson.toJson(new ArrayList<contentofallcources>()));
            editor.commit();
        }

        if (null == getWhislist()){
            editor.putString(WHISHLIST,gson.toJson(new ArrayList<contentofallcources>()));
            editor.commit();
        }

        if (null == getOngoingcourse()){
            editor.putString(ONGOING_COURSES,gson.toJson(new ArrayList<contentofallcources>()));
            editor.commit();
        }

        if (null == getFavcources()){
            editor.putString(FAV_COURSES,gson.toJson(new ArrayList<contentofallcources>()));
            editor.commit();
        }
    }

    private void initData(){
      //TODO:

        ArrayList<contentofallcources> morecontents = new ArrayList<>();
        morecontents.add(new contentofallcources(1,"30hrs","kunal kushwaha", "Java","https://www.youtube.com/playlist?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ", "https://dev.java/assets/images/java-logo-vert-blk.png"));
        morecontents.add(new contentofallcources(2,"15hrs","freeCodeCamp","Android development","https://www.youtube.com/watch?v=fis26HvvDII&t=3s", "https://1.bp.blogspot.com/-LgTa-xDiknI/X4EflN56boI/AAAAAAAAPuk/24YyKnqiGkwRS9-_9suPKkfsAwO4wHYEgCLcBGAsYHQ/s0/image9.png"));
        morecontents.add(new contentofallcources(3,"15hrs","Microsoft Learn","Cloud computing", "https://docs.microsoft.com/en-us/learn/paths/cmu-cloud-developer-basics/","https://www.nutanix.com/content/dam/nutanix/images/img-cloud-computing.jpg"));
        morecontents.add(new contentofallcources(4,"10hrs", "edureka","AI/ML", "https://www.youtube.com/watch?v=GwIo3gDZCVQ","https://www.carbonite.com/globalassets/images/sections/blog/blog-thumbnails/social/ai-ml.png"));
        morecontents.add(new contentofallcources(5,"2rs 30min","freeCodeCamp","Dev-ops", "https://www.youtube.com/watch?v=j5Zsa_eOXeY&t=1s","https://devopedia.org/images/article/54/7602.1513404277.png"));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_COURSES_KEY, gson.toJson(morecontents));
        editor.commit();
    }

    public static synchronized Utils getInstance(Context context){
        if (null != instance){
            return instance;
        }else {
            instance = new Utils(context);
            return instance;
        }
    }

    public  ArrayList<contentofallcources> getAllcources() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<contentofallcources>>(){}.getType();
        ArrayList<contentofallcources> contentofallcources1 = gson.fromJson(sharedPreferences.getString(ALL_COURSES_KEY, null),type);
        return contentofallcources1;
    }

    public  ArrayList<contentofallcources> getCompletedcources() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<contentofallcources>>(){}.getType();
        ArrayList<contentofallcources> contentofallcources1 = gson.fromJson(sharedPreferences.getString(COMPLETED_COURSES, null),type);
        return contentofallcources1;
    }

    public  ArrayList<contentofallcources> getWhislist() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<contentofallcources>>(){}.getType();
        ArrayList<contentofallcources> contentofallcources1 = gson.fromJson(sharedPreferences.getString(WHISHLIST, null),type);
        return contentofallcources1;
    }

    public ArrayList<contentofallcources> getOngoingcourse() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<contentofallcources>>(){}.getType();
        ArrayList<contentofallcources> contentofallcources1 = gson.fromJson(sharedPreferences.getString(ONGOING_COURSES, null),type);
        return contentofallcources1;
    }

    public ArrayList<contentofallcources> getFavcources() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<contentofallcources>>(){}.getType();
        ArrayList<contentofallcources> contentofallcources1 = gson.fromJson(sharedPreferences.getString(FAV_COURSES, null),type);
        return contentofallcources1;
    }

    public contentofallcources getcourseid(int id){
        ArrayList<contentofallcources> contentofallcources1 = getAllcources();
        if (null != contentofallcources1){
            for (contentofallcources b: contentofallcources1){
                if (b.getId() == id){
                    return b;
                }
            }
        }
        return null;
    }

    public boolean AddtoAlreadyReadCourse(contentofallcources contentofallcources1){
        ArrayList<contentofallcources> morecontent = getCompletedcources();
        if (null != morecontent){
            if (morecontent.add(contentofallcources1)){
                Gson gson =new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(COMPLETED_COURSES);
                editor.putString(COMPLETED_COURSES, gson.toJson(morecontent));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean AddToWhislist(contentofallcources contentofallcources){
        ArrayList<contentofallcources> morecontent = getWhislist();
        if (null != morecontent){
            if (morecontent.add(contentofallcources)){
                Gson gson =new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WHISHLIST);
                editor.putString(WHISHLIST, gson.toJson(morecontent));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean AddToCurrentlyReading(contentofallcources contentofallcources){
        ArrayList<contentofallcources> morecontent = getOngoingcourse();
        if (null != morecontent){
            if (morecontent.add(contentofallcources)){
                Gson gson =new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ONGOING_COURSES);
                editor.putString(ONGOING_COURSES, gson.toJson(morecontent));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean AddToFavcourse(contentofallcources contentofallcources){
        ArrayList<contentofallcources> morecontent = getFavcources();
        if (null != morecontent){
            if (morecontent.add(contentofallcources)){
                Gson gson =new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAV_COURSES);
                editor.putString(FAV_COURSES, gson.toJson(morecontent));
                editor.commit();
                return true;
            }
        }
        return false;
    }
}
