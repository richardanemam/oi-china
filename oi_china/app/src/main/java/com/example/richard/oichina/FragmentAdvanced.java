package com.example.richard.oichina;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Richard on 9/23/2018.
 */

public class FragmentAdvanced extends Fragment {
    View view;

    public FragmentAdvanced() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.advanced_fragment, container, false);
        return view;
    }
}
