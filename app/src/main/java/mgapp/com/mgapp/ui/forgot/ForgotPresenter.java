package mgapp.com.mgapp.ui.forgot;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import mgapp.com.mgapp.app.App;
import mgapp.com.mgapp.app.Endpoints;
import mgapp.com.mgapp.model.response.ResultResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPresenter extends MvpNullObjectBasePresenter<ForgotView> {
    private String TAG = ForgotPresenter.class.getSimpleName();

    public void submitEmail(String s) {
        getView().startLoading("Checking email...");
        App.getInstance().getApiInterface().checkEmail(Endpoints.FORGOTPASS,s).enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                getView().stopLoading();
                if (response.body().getResult().equals("success")) {
                    getView().onEmailExist();
                } else if(response.body().getResult().equalsIgnoreCase("doesNotExist")) {
                    getView().showAlert("Email does not exists");
                }else
                {
                    getView().showAlert("Failed to Reset Password");
                }
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                getView().stopLoading();
                Log.e(TAG, "onFailure: Error calling register api", t);
                getView().stopLoading();
                getView().showAlert("Error Connecting to Server");
            }
        });
    }



}
