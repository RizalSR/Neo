package com.example.neo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.neo.Fragment.FragmentHome;
import com.example.neo.Fragment.FragmentLike;
import com.example.neo.Fragment.FragmentProfile;
import com.example.neo.Fragment.FragmentHistory;
import com.example.neo.Fragment.FragmentKurs;
import com.example.neo.R;
import com.example.neo.bottom.BottomItem;
import com.example.neo.design.InstagramBottomBar;
import com.example.neo.design.adapter.BottomAdapter;

public class MainActivity extends AppCompatActivity implements BottomAdapter.BottomItemClickInterface {
    private InstagramBottomBar instagramBottomBar;

    private final int HOME = 0;
    private final int HISTORY = 1;
    private final int KURS = 2;
    private final int LIKES = 3;
    private final int PROFILE = 4;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instagramBottomBar = new InstagramBottomBar(findViewById(R.id.neoBottomBar), MainActivity.this, MainActivity.this);
        initBottomItems();
        start();
    }

    // Start
    private void start(){
        load_fragment(new FragmentHome());
    }

    // Inisialisasi BottomNav
    private void initBottomItems() {
        BottomItem home = new BottomItem(HOME, R.drawable.home, R.drawable.homefill, false);
        BottomItem history = new BottomItem(HISTORY, R.drawable.history, R.drawable.history_fill, false);
        BottomItem kurs = new BottomItem(KURS, R.drawable.money, R.drawable.money_fill, false);
        BottomItem likes = new BottomItem(LIKES, R.drawable.likes, R.drawable.likesfill, false);
        BottomItem profile = new BottomItem(PROFILE, R.drawable.profile, R.drawable.profilefill, false);

        instagramBottomBar.addBottomItem(home);
        instagramBottomBar.addBottomItem(history);
        instagramBottomBar.addBottomItem(kurs);
        instagramBottomBar.addBottomItem(likes);
        instagramBottomBar.addBottomItem(profile);
        instagramBottomBar.addBottomItem(profile);

        instagramBottomBar.apply(HOME);
    }

    //Function BootomNav
    @Override
    public void itemSelect(int itemId) {
        switch (itemId) {
            case HOME:
                load_fragment(new FragmentHome());
                break;
            case HISTORY:
                load_fragment(new FragmentHistory());
                break;
            case KURS:
                load_fragment(new FragmentKurs());
                break;
            case LIKES:
                load_fragment(new FragmentLike());
                break;
            case PROFILE:
                load_fragment(new FragmentProfile());
                break;
        }
    }

    //Load Fragment
    Boolean load_fragment(Fragment fragment){
        if (fragment!=null)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_main, fragment).commit();
            return true;
        }
        return false;
    }

}
