package mymgconnect.com.mgapp.ui.map;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mymgconnect.com.mgapp.R;
import mymgconnect.com.mgapp.databinding.ItemNearestBinding;
import mymgconnect.com.mgapp.model.data.NearDealer;


public class MapListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MapView mapView;
    private List<NearDealer> list;
    private static final int VIEW_TYPE_MORE = 1;
    private static final int VIEW_TYPE_DEFAULT = 0;
    private boolean loading;
    Typeface typefaceTitle;
    Typeface face;

    public MapListAdapter(MapView mapView) {
        this.mapView = mapView;
        list = new ArrayList<>();

    }


    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_DEFAULT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         ItemNearestBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_nearest, parent, false);


        return new MapListAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MapListAdapter.ViewHolder viewHolder = (MapListAdapter.ViewHolder) holder;

        viewHolder.binding.setCompany(list.get(position));
        viewHolder.binding.setView(mapView);

        if(list.get(position).getDistance() == -1 || list.get(position).getDistance() == -1.0 ) {
            viewHolder.binding.distance.setText("LOCATION");
            viewHolder.binding.KM.setText("ERROR");
        }

    }

    public void setList(List<NearDealer> list) {

        this.list = list;
        notifyDataSetChanged();
    }



    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemNearestBinding binding;

        public ViewHolder(ItemNearestBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
