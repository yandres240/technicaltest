package com.appgate.technicaltest.views;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

//import android.support.annotation.NonNull;
//import android.support.v4.app.Fragment;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.appgate.technicaltest.R;
import com.appgate.technicaltest.presenter.ILoginPresenter;
import com.appgate.technicaltest.presenter.implement.LoginPresenter;
import com.appgate.technicaltest.services.ApiService;

import static androidx.core.content.ContextCompat.checkSelfPermission;

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
        EditText email = (EditText)view.findViewById(R.id.email);
        EditText password = (EditText)view.findViewById(R.id.password);
        verifyPermission();
        view.findViewById(R.id.btnInit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    boolean isSuccess = iLoginPresenter.loginUser(email.getText().toString(),password.getText().toString());
                    if (isSuccess)
                        NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        view.findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_LoginFragment_to_RegisterFragment);
            }
        });
    }

    private void verifyPermission() {
        int permsRequestCode = 100;
        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        int accessFinePermission = checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        int accessCoarsePermission = checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION);

        if (accessFinePermission == PackageManager.PERMISSION_GRANTED && accessCoarsePermission == PackageManager.PERMISSION_GRANTED) {
            //se realiza metodo si es necesario...
        } else {
            requestPermissions(perms, permsRequestCode);
        }
    }
}
