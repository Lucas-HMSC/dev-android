package com.example.aprendaingls.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix;
    private MediaPlayer mediaPlayer;


    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        btnOne = view.findViewById(R.id.btnOne);
        btnTwo = view.findViewById(R.id.btnTwo);
        btnThree = view.findViewById(R.id.btnThree);
        btnFour = view.findViewById(R.id.btnFour);
        btnFive = view.findViewById(R.id.btnFive);
        btnSix = view.findViewById(R.id.btnSix);

        // Aplica eventos de click
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOne:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                tocarSom();
                break;
            case R.id.btnTwo:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSom();
                break;
            case R.id.btnThree:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSom();
                break;
            case R.id.btnFour:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSom();
                break;
            case R.id.btnFive:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSom();
                break;
            case R.id.btnSix:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                tocarSom();
                break;

        }
    }

    public void tocarSom(){
        if (mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
