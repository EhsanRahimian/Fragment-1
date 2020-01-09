package com.nicootech.fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragTop.TopSectionListener, FragBottomPicture.BottomSectionListener{

    private FragTop fragT;
    private FragBottomPicture fragB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragT = new FragTop();
        fragB = new FragBottomPicture();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_t, fragT)
                .replace(R.id.fragment_b, fragB)
                .commit();



    }


    @Override
    public void createMemeB(CharSequence topInput, CharSequence bottomInput) {
        fragT.updateText(topInput, bottomInput);
    }

    @Override
    public void createMemeTop(CharSequence topInput, CharSequence bottomInput) {
        fragB.updateText(topInput,bottomInput);

    }
}
