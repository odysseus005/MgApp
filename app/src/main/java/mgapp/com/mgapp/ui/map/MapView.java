package mgapp.com.mgapp.ui.map;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

import mgapp.com.mgapp.model.data.DealerContacts;
import mgapp.com.mgapp.model.data.NearDealer;


public interface MapView extends MvpView {
    void showNearest();

    void setNearestCompany(List<NearDealer> companyList);

    void OnItemClicked(NearDealer companyList);

    void OnItemCalled(DealerContacts contacts);

    void loadContacts();

    void startLoading();

    void stopLoading();

    void filterDealers(String filters);

    void showAlert(String s);

    void updateMap();
}
