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
public class BichosFragment extends Fragment implements View.OnClickListener{

    private ImageButton btnDog, btnCat, btnLion, btnMonkey, btnSheep, btnCow;
    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        btnDog = view.findViewById(R.id.btnDog);
        btnCat = view.findViewById(R.id.btnCat);
        btnLion = view.findViewById(R.id.btnLion);
        btnMonkey = view.findViewById(R.id.btnMonkey);
        btnSheep = view.findViewById(R.id.btnSheep);
        btnCow = view.findViewById(R.id.btnCow);

        // Aplica eventos de click
        btnDog.setOnClickListener(this);
        btnCat.setOnClickListener(this);
        btnLion.setOnClickListener(this);
        btnMonkey.setOnClickListener(this);
        btnSheep.setOnClickListener(this);
        btnCow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDog:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
                break;
            case R.id.btnCat:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;
            case R.id.btnLion:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;
            case R.id.btnMonkey:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;
            case R.id.btnSheep:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;
            case R.id.btnCow:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
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
