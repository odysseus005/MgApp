package mgapp.com.mgapp.ui.inquiries.contactus;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import mgapp.com.mgapp.app.App;
import mgapp.com.mgapp.app.Constants;
import mgapp.com.mgapp.app.Endpoints;
import mgapp.com.mgapp.model.response.ResultResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ContactPresenter extends MvpNullObjectBasePresenter<ContactView> {

    private static final String TAG = ContactPresenter.class.getSimpleName();


    public void sendContactis(String contact_method,
                              String firstName,
                             String lname,
                              String email,
                               String contact,
                               String concern) {


        getView().startLoading();
        App.getInstance().getApiInterface().contactUs(Endpoints.CONTACT, contact_method,  firstName, lname, email, contact, concern)
                .enqueue(new Callback<ResultResponse>() {
                    @Override
                    public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                        getView().stopLoading();
                        if (response.isSuccessful()) {
                            switch (response.body().getResult()) {
                                case Constants.SUCCESS:
                                    getView().showReturn("Message Sent Successfully!");
                                    break;
                                default:
                                    getView().showAlert("Error Sending Inquiries");
                                    break;
                            }
                        } else {
                            getView().showAlert("Error Sending Parts Inquiries");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultResponse> call, Throwable t) {
                        //Log.e(TAG, "onFailure: Error calling register api", t);
                        getView().stopLoading();
                        getView().showAlert("Error Connecting to Server");
                    }
                });
    }


}
