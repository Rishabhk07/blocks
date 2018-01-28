package com.codingblocks.codingblocks.view.activities;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.WindowManager;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    MainActivity mainActivity;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup () {
        mainActivity = mainActivityRule.getActivity();

        Runnable wakeUpDevice = new Runnable() {
            public void run() {
                mainActivity.getWindow().addFlags(
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        mainActivity.runOnUiThread(wakeUpDevice);
    }

    @Test
    public void testMainActivityRuns () throws Exception {
        assertEquals(false,mainActivity.themeId);
    }
}
