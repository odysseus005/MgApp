package mgapp.com.mgapp.ui.map;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mgapp.com.mgapp.R;
import mgapp.com.mgapp.databinding.ItemContactBinding;
import mgapp.com.mgapp.model.data.DealerContacts;


public class ContactListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MapView mapView;
    private List<DealerContacts> list;
    private static final int VIEW_TYPE_MORE = 1;
    private static final int VIEW_TYPE_DEFAULT = 0;
    private boolean loading;


    public ContactListAdapter(MapView mapView) {
        this.mapView = mapView;
        list = new ArrayList<>();

    }


    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_DEFAULT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         ItemContactBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_contact, parent, false);


        return new ContactListAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ContactListAdapter.ViewHolder viewHolder = (ContactListAdapter.ViewHolder) holder;

        viewHolder.binding.setDealer(list.get(position));
        viewHolder.binding.setView(mapView);

    }

    public void setList(List<DealerContacts> list) {

        this.list = list;
        notifyDataSetChanged();
    }



    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemContactBinding binding;

        public ViewHolder(ItemContactBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
