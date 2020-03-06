package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragmentOne extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
    return inflater.inflate(R.layout.fragment_one,container,false);

    }
}