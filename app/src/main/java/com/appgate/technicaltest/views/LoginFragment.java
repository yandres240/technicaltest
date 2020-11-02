package com.appgate.technicaltest.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import android.support.annotation.NonNull;
//import android.support.v4.app.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.appgate.technicaltest.R;
import com.appgate.technicaltest.presenter.ILoginPresenter;
import com.appgate.technicaltest.presenter.LoginPresenter;
import com.appgate.technicaltest.services.ApiService;

public class LoginFragment extends Fragment {
    ILoginPresenter iLoginPresenter;

    public LoginFragment(){
        iLoginPresenter = new LoginPresenter(new ApiService());
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btnInit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iLoginPresenter.GetDate("5.517","-72.883");
                NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}
