package mgapp.com.mgapp.ui.garage;

import com.hannesdorfmann.mosby.mvp.MvpView;

import mgapp.com.mgapp.model.data.Garage;


public interface GarageListView extends MvpView {




    void startLoading();

    void stopLoading();

    void startupLoading();

    void stopupLoading();

    void setDeleteGarageList(Garage garage);

    void onBirthdayClicked();



    void setEditGarageList(Garage garage);

    void setGarageList();

    void showGarageListDetails(Garage garage);

    void stopRefresh();

    void showError(String message);

    void closeDialog(String message);

    void onRefresh();




}
