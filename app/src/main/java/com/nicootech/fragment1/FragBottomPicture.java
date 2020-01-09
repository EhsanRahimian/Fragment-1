package com.nicootech.fragment1;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragBottomPicture extends Fragment {

    private  EditText topText;
    private  EditText bottomText;
    private  Button button;

    private BottomSectionListener activityCommander;
    public interface BottomSectionListener{
        public void createMemeB(CharSequence topInput, CharSequence bottomInput);
    }



    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_bottom_picture, container,false);
        topText = view.findViewById(R.id.topText);
        bottomText = view.findViewById(R.id.bottomText);
        button = view.findViewById(R.id.button_click);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CharSequence tInput = topText.getText();
                        CharSequence bInput = bottomText.getText();
                        activityCommander.createMemeB(tInput,bInput);
                    }
                }
        );


        return view;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof BottomSectionListener){
            activityCommander=(BottomSectionListener)context;
        }else {
            throw new RuntimeException(context.toString()
                    +" must implement BottomSectionListener");

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activityCommander = null;
    }

    public void updateText(CharSequence newTopText, CharSequence newBottomText){
        topText.setText(newTopText);
        bottomText.setText(newBottomText);
    }
}
