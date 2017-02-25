package com.examle.yogeshkumar.recyclerview.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yogesh Kumar on 2/14/2017.
 */

public class Derpdata {

    private static final String[] title = {"nothing like anything", "purpose of life is life of purpose", "let's do it",
            "yesterday you say tommarrow", "make them believe","Always believe that something wonderful is about to happen",
            "Money is not everything but everything requires money",
    "war isn't about who's right.Just who's left","Confidence is silent but insecurities are loud","sometime u get happiness when u except it least",
    "It doesn't matter how slowly u go,as long as u do not stop","Hard work and patience can get u anything,but not everything",
    "If u are the smartest person in the room ,then u r in the wrong room","Trust someone blindly and one day they will make u blind ",
            "you can never feel happy in life unless u learn to appreciate and value what u have"};


    private static final String[] subtitle={"django","markus","brutus","bill gates","jobs","zuckerberg","twain",
            "bond","jeffery","tyrion","targarean","jon snow","robot","jesus","charlie"};

    private static final int icon=android.R.drawable.ic_menu_myplaces;
//    private static final int[] icons = {android.R.drawable.ic_media_next,
//            android.R.drawable.ic_lock_power_off, android.R.drawable.ic_menu_agenda, android.R.drawable.ic_menu_rotate};

    public static List<Listitem> getListData() {
        List<Listitem> data = new ArrayList<>();

        for(int i=0;i<4 ;i++){
            for(int j=0;j<title.length;j++){
                Listitem list=new Listitem();
                list.setTitle(title[j]);
                list.setSubTitle(subtitle[j]);
                //list.setImageresid(icons[j]);
                data.add(list);

            }
        }

        return  data;
    }
}
