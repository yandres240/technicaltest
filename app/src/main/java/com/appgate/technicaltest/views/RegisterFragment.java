package com.appgate.technicaltest.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.appgate.technicaltest.R;
import com.appgate.technicaltest.data.storage.entity.User;
import com.appgate.technicaltest.presenter.ILoginPresenter;
import com.appgate.technicaltest.presenter.IRegisterPresenter;
import com.appgate.technicaltest.presenter.implement.LoginPresenter;
import com.appgate.technicaltest.presenter.implement.RegisterPresenter;
import com.appgate.technicaltest.services.ApiService;
import com.appgate.technicaltest.utils.AlertMessages;

import java.util.UUID;

public class RegisterFragment extends Fragment {
    IRegisterPresenter iRegisterPresenter;
    AlertMessages alertMessages;
    public RegisterFragment(){
        alertMessages = new AlertMessages();
        iRegisterPresenter = new RegisterPresenter(new ApiService());
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    private boolean isValidModel(User user)
    {
        boolean isValid = false;
        if (!user.User.equals("") &&
        !user.Telephone.equals("") && user.Telephone.length()==10 &&
        !user.LastName.equals("") &&
        !user.FirstName.equals("") &&
        user.Password.length()==8)
            isValid = true;

        return isValid;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText email = (EditText)view.findViewById(R.id.email);
        EditText password = (EditText)view.findViewById(R.id.password);
        EditText firstName = (EditText)view.findViewById(R.id.firstName);
        EditText lastName = (EditText)view.findViewById(R.id.lastName);
        EditText telephone = (EditText)view.findViewById(R.id.telephone);
        view.findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    User user = new User();
                    user.Uid = UUID.randomUUID().toString().replace("-", "");
                    user.User = email.getText().toString();
                    user.Password = password.getText().toString();
                    user.FirstName = firstName.getText().toString();
                    user.LastName = lastName.getText().toString();
                    user.Telephone = telephone.getText().toString();
                    user.Status = true;
                    if(isValidModel(user)) {
                        boolean isSuccess = iRegisterPresenter.registerUser(user);
                        if (isSuccess)
                            NavHostFragment.findNavController(RegisterFragment.this).navigate(R.id.action_RegisterFragment_to_LoginFragment);
                        else
                            alertMessages.alertView(getActivity(),"Información incorrecta");
                    }
                    else
                        alertMessages.alertView(getActivity(),"Datos no validos");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
