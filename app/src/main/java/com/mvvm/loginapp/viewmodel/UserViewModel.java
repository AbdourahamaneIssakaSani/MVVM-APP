package com.mvvm.loginapp.viewmodel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.mvvm.loginapp.BR;
import com.mvvm.loginapp.Model.UserModel;

public class UserViewModel extends BaseObservable {
    private UserModel userModel;
    private String successMessage = "Success !";
    private String errorMessage = "Failed !";

    @Bindable
    private String toastMessage=null;

    public UserViewModel() {
        userModel = new UserModel("","");
    }

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable public String getUserEmail(){
        return userModel.getEmail();
    }

    public void setUserEmail(String email){
        userModel.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable public String getUserPassword(){
        return userModel.getPassword();
    }

    public void setUserPassword(String password){
        userModel.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public boolean isValid(){
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches();
    }

    public void  onButtonClick(){
        if (isValid()){
            setToastMessage(successMessage);
        }
        else {
            setToastMessage(errorMessage);
        }
    }
}
