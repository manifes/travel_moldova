package com.example.mew;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignupTabFragment extends Fragment {
    EditText email, pass, confPass;
     Button signup;
    float v = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!! SIGN UP CREATE !!!!!!!!!!!!!!!!!!!!!!");

//        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container,false);
        View root = inflater.inflate(R.layout.signup_tab_fragment, container,false);
            signup = root.findViewById(R.id.sign_up);
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), UserActivity.class);
                    startActivity(intent);
                }
            });
        return root;
    }
}
