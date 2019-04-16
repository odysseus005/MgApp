package mymgconnect.com.mgapp.ui.main.pastAppointment;

import com.hannesdorfmann.mosby.mvp.MvpView;

import mymgconnect.com.mgapp.model.data.PastAppointment;


public interface PastAppointmentView extends MvpView {




    void setAppointmentList();


    void showAppointmentDetails2(PastAppointment appoint);

    void stopRefresh();

    void showError(String message);

    void showReturn(String message);

    void startLoading();

    void stopLoading();



}
