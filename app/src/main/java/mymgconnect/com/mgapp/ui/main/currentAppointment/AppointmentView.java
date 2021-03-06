package mymgconnect.com.mgapp.ui.main.currentAppointment;

import com.hannesdorfmann.mosby.mvp.MvpView;

import mymgconnect.com.mgapp.model.data.Appointment;
import mymgconnect.com.mgapp.model.data.Dealer;


public interface AppointmentView extends MvpView {




    void setAppointmentList();

    void setAppointment();

    void setAppointmentDate();

    void loadGarage();

    void loadDealer();

    void loadService();

    void loadKms(boolean check);

    void loadAdvisor();

    void loadHolidays();

    void loadTimeslot();

    void loadTimeslot2();

    void selectDealer(Dealer dealer);

    void showAppointmentDetails(Appointment appoint);

    void stopRefresh();

    void showError(String message);

    void showReturn(String message);

    void startLoading();

    void stopLoading();

    void appointmentExist(String message);


    void closeDialog(String message);

    void closeCancel(String message);


}
