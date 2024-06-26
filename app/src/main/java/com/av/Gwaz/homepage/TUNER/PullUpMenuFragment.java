package com.av.Gwaz.homepage.TUNER;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.av.Gwaz.R;

public class PullUpMenuFragment extends DialogFragment {

    public PullUpMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_pull_up_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnOverlay1 = view.findViewById(R.id.btn_overlay1);
        Button btnOverlay2 = view.findViewById(R.id.btn_overlay2);
        Button btnOverlay3 = view.findViewById(R.id.btn_overlay3);
        Button btnOverlay4 = view.findViewById(R.id.btn_overlay4);


        btnOverlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display overlay view 1
                displayOverlay(new OverlayView1Fragment());
            }
        });

        btnOverlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display overlay view 2
                displayOverlay(new OverlayView2Fragment());
            }
        });

        btnOverlay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display overlay view 3
                displayOverlay(new OverlayView3Fragment());
            }
        });

        btnOverlay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayOverlay(new OverlayView4Fragment());

            }
        });


    }

    private void displayOverlay(Fragment fragment) {
        if (getActivity() != null) {
            // Get the fragment manager
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            // Pop the back stack to remove the previous fragment
            fragmentManager.popBackStack("overlay_fragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);

            // Replace the fragment with the new one
            fragmentManager.beginTransaction()
                    .replace(R.id.overlay_container, fragment)
                    .addToBackStack(null)
                    .commit();
        }
        dismiss(); // Dismiss the menu fragment
    }
}