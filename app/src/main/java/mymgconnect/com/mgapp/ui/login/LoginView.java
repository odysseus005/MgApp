package mymgconnect.com.mgapp.ui.login;


import com.hannesdorfmann.mosby.mvp.MvpView;

import mymgconnect.com.mgapp.model.data.User;


public interface LoginView extends MvpView {

    void onLoginButtonClicked();


    void onRegisterButtonClicked();

    void showAlert(String message);

    void setEditTextValue(String username, String password);

    void startLoading();

    void stopLoading();

    void onLoginSuccess(User user);

    void onForgotPasswordButtonClicked();


}
