package com.codingblocks.codingblocks.models;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rishabhkhanna on 30/06/17.
 */

public class generateList {
    public static void generateList(ArrayList<String> groupList, HashMap<String, ArrayList<String>> childList){
        groupList.add("Blocks of JS");
        groupList.add("Crux");
        groupList.add("Pandora");

        ArrayList<String> child1 = new ArrayList<>();
        ArrayList<String> child2 = new ArrayList<>();
        ArrayList<String> child3 = new ArrayList<>();

        child1.add("Js");
        child1.add("Javascript");
        child1.add("weirdly stuff");
        child1.add("but go and learn JS");

        child2.add("YO");
        child2.add("all java here");
        child2.add("can be used to make android app");

        child3.add("God of Android ");
        child3.add("Here ");
        child3.add("and his warrior ");

        childList.put(groupList.get(0),child1);
        childList.put(groupList.get(1),child2);
        childList.put(groupList.get(2),child3);

    }
}
