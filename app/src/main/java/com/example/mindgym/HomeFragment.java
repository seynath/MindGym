package com.example.mindgym;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private CardView sadCard, stressedCard, angryCard, restlessCard;

    private ImageView sadCardImg, stressedCardImg, angryCardImg, restlessCardImg;
    private TextView sadCardText, stressedCardText, angryCardText, restlessCardText;
    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sadCard = (CardView) view.findViewById(R.id.sadCard);
        sadCardImg = (ImageView) view.findViewById(R.id.sadCardImg);
        sadCardText = (TextView) view.findViewById(R.id.sadCardText);

        stressedCard = (CardView) view.findViewById(R.id.stressedCard);
        stressedCardImg = (ImageView) view.findViewById(R.id.stressedCardImg);
        stressedCardText = (TextView) view.findViewById(R.id.stressedCardText);

        angryCard = (CardView) view.findViewById(R.id.angryCard);
        angryCardImg = (ImageView) view.findViewById(R.id.angryCardImg);
        angryCardText = (TextView) view.findViewById(R.id.angryCardText);

        restlessCard = (CardView) view.findViewById(R.id.restlessCard);
        restlessCardImg = (ImageView) view.findViewById(R.id.restlessCardImg);
        restlessCardText = (TextView) view.findViewById(R.id.restlessCardText);

        sadCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SadFragment()); // Replace with the fragment you want to navigate to
            }
        });

        sadCardImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SadFragment()); // Replace with the fragment you want to navigate to
            }
        });

        sadCardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SadFragment()); // Replace with the fragment you want to navigate to
            }
        });

        stressedCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new StressFragment()); // Replace with the fragment you want to navigate to
            }
        });

        stressedCardImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new StressFragment()); // Replace with the fragment you want to navigate to
            }
        });

        stressedCardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new StressFragment()); // Replace with the fragment you want to navigate to
            }
        });

        angryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AngryFragment()); // Replace with the fragment you want to navigate to
            }
        });

        angryCardImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AngryFragment()); // Replace with the fragment you want to navigate to
            }
        });

        angryCardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AngryFragment()); // Replace with the fragment you want to navigate to
            }
        });

        restlessCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new RestlessFragment()); // Replace with the fragment you want to navigate to
            }
        });

        restlessCardImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new RestlessFragment()); // Replace with the fragment you want to navigate to
            }
        });

        restlessCardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new RestlessFragment()); // Replace with the fragment you want to navigate to
            }
        });

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .addToBackStack(null) // You can add this if you want to add the transaction to the back stack
                    .commit();
        }
    }

}
