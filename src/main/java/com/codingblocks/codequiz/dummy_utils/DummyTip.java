package com.codingblocks.codequiz.dummy_utils;

import com.codingblocks.codequiz.models.Tip;

import java.util.ArrayList;

/**
 * Created by piyush0 on 28/12/16.
 */
public class DummyTip {
    public static ArrayList<Tip> getTips() {
        ArrayList<Tip> tips = new ArrayList<>();
        tips.add(new Tip("Tip A"));
        tips.add(new Tip("Tip B"));
        tips.add(new Tip("Tip C"));
        tips.add(new Tip("Tip D"));
        tips.add(new Tip("Tip E"));
        tips.add(new Tip("Tip F"));
        tips.add(new Tip("Tip G"));
        tips.add(new Tip("Tip H"));
        tips.add(new Tip("Tip I"));

        return tips;
     }

}
