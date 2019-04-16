package mymgconnect.com.mgapp.ui.main.currentAppointment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mymgconnect.com.mgapp.R;
import mymgconnect.com.mgapp.databinding.ItemAppointmentGarageBinding;
import mymgconnect.com.mgapp.model.data.Garage;


public class GarageAdapter extends RecyclerView.Adapter<GarageAdapter.ViewHolder> {
    private List<Garage> garage;
    private final Context context;
    private final AppointmentView view;
    private static final int VIEW_TYPE_DEFAULT = 0;
    private Boolean reloadImage;
    private int chooseGarage;



    public GarageAdapter(Context context, AppointmentView view) {
        this.context = context;
        this.view = view;
        garage = new ArrayList<>();
        chooseGarage = -1;
        reloadImage = true;

    }


    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_DEFAULT;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       final ItemAppointmentGarageBinding itemGarageBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_appointment_garage,
                parent,
                false);





        return new ViewHolder(itemGarageBinding);
    }

    @Override
    public void onBindViewHolder(final GarageAdapter.ViewHolder holder, final int position) {




        holder.itemGarageBinding.appointmentGarage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                reloadImage = false;
               if(chooseGarage == position)
                {
                    chooseGarage =  -1;
                    holder.itemGarageBinding.appointmentGarage.setCardBackgroundColor(Color.WHITE);
                }else
                {
                    chooseGarage = position;
                    holder.itemGarageBinding.appointmentGarage.setCardBackgroundColor(Color.parseColor("#26cb333b"));
                    notifyDataSetChanged();
                }

            }
        });


        checkClickStatus(position,holder);

            holder.itemGarageBinding.setGarage(garage.get(position));
            holder.itemGarageBinding.setView(view);

    }

    public void checkClickStatus(int position,GarageAdapter.ViewHolder holder)
    {

        if(chooseGarage != position)
        {
            holder.itemGarageBinding.appointmentGarage.setCardBackgroundColor(Color.WHITE);
        }else
        {
            holder.itemGarageBinding.appointmentGarage.setCardBackgroundColor(Color.parseColor("#26cb333b"));
        }



    }

    public void reset()
    {
        chooseGarage = -1;
    }


    public void clear() {
        garage.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return garage.size();
    }




    public String getSelectedGarage()
    {
        if(chooseGarage==-1)
            return "";
        return String.valueOf(garage.get(chooseGarage).getGarageId());
    }



    public void setGarageResult(List<Garage> event) {
        this.garage = event;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemAppointmentGarageBinding itemGarageBinding;

        public ViewHolder(ItemAppointmentGarageBinding itemGarageBinding) {
            super(itemGarageBinding.getRoot());
            this.itemGarageBinding = itemGarageBinding;
        }



    }
}
