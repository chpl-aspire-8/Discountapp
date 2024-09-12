package com.example.oterridiscountapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oterridiscountapp.databinding.RawVendorListBinding;
import com.example.oterridiscountapp.utils.OnSingleClickListener;
import com.example.oterridiscountapp.utils.VariableBag;

import java.util.List;

public class VendorListAdapter extends RecyclerView.Adapter<VendorListAdapter.VendorViewHolder> {
    Context context;
    List<VendorListResponse.UserOrder> userOrderList, searchList;
    Changestatus changestatus;

    public VendorListAdapter(Context context, List<VendorListResponse.UserOrder> userOrderList) {
        this.context = context;
        this.userOrderList = userOrderList;
        this.searchList = userOrderList;
    }

    public void setUpInterface(Changestatus changestatus) {
        this.changestatus = changestatus;
    }

    @NonNull
    @Override
    public VendorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RawVendorListBinding binding = RawVendorListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new VendorViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorViewHolder holder, int position) {
        VendorListResponse.UserOrder model = searchList.get(position);
        holder.binding.tvUserName.setText(model.getUserFullName());
        holder.binding.tvUserAddress.setText(model.getOrderAddress());


        holder.binding.tvBookingDate.setText(model.getOrderCreatedDate());
        holder.binding.tvOrderType.setText(model.getStatusName());

        holder.binding.tvUserMap.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                changestatus.mapDirection(model);
            }
        });

        holder.binding.tvDetails.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                if (changestatus != null) {
                    changestatus.moreDetails(model);
                }
            }
        });

        if (model.getServiceType() != null && model.getServiceType().equalsIgnoreCase("1")) {
            holder.binding.ivServiceImage.setVisibility(View.VISIBLE);
            holder.binding.tvClothOrdCountExp.setVisibility(View.VISIBLE);
            holder.binding.tvExpTitle.setVisibility(View.VISIBLE);

            holder.binding.tvClothOrdCountExp.setText(model.getExpressProduct());

        } else {
            holder.binding.ivServiceImage.setVisibility(View.GONE);
            holder.binding.tvClothOrdCountExp.setVisibility(View.GONE);
            holder.binding.tvExpTitle.setVisibility(View.GONE);
        }

//        if (model.getAttemptStatus() != null && model.getAttemptStatus().equalsIgnoreCase("2")) {
//            holder.binding.tvAddProductOrd.setVisibility(View.VISIBLE);
//            holder.binding.tvAddProductOrd.setText("Approve Reschedule Delivery");
//
//            holder.binding.tvAddProductOrd.setOnClickListener(new OnSingleClickListener() {
//                @Override
//                public void onSingleClick(View v) {
////                    changestatus.approveReschedule(model);
//                }
//            });
//
//        } else if (model.getAttemptStatus() != null && model.getAttemptStatus().equalsIgnoreCase("3")) {
//            holder.binding.tvAddProductOrd.setVisibility(View.GONE);
//
//        } else {
//            holder.binding.tvAddProductOrd.setVisibility(View.GONE);
//        }

        holder.binding.tvShowDate.setText("Pickup Date");

        holder.binding.tvDetails.setVisibility(View.GONE);

        holder.binding.tvprice.setVisibility(View.VISIBLE);
        holder.binding.linOrderStatus.setVisibility(View.VISIBLE);
        holder.binding.linReqStatus.setVisibility(View.GONE);
        holder.binding.tvOrderId.setText("#ORD" + model.getOrderId());
//        holder.binding.tvOrderTypeView.setText("Order");
if (model.getIs_discount_applied()!=null){

    if (model.getIs_discount_applied()) {
        holder.binding.tvApproveStatus.setVisibility(View.VISIBLE);
        holder.binding.tvApproveStatus.setText("Apply Discount");
        holder.binding.tvApproveStatus.setEnabled(true);
        holder.binding.tvApproveStatus.setBackgroundResource(R.drawable.color_primary_bg);
        holder.binding.tvApproveStatus.setTextColor(ContextCompat.getColor(context, android.R.color.white));

    } else {
        if (model.getOrderPaymentStatus().equalsIgnoreCase("2")){
            holder.binding.tvApproveStatus.setBackgroundResource(R.drawable.color_grey_bg);
            holder.binding.tvApproveStatus.setTextColor(ContextCompat.getColor(context, android.R.color.black));
            holder.binding.tvApproveStatus.setEnabled(false);
            holder.binding.tvApproveStatus.setText("Payment already paid");
        }else {
            holder.binding.tvApproveStatus.setBackgroundResource(R.drawable.color_grey_bg);
            holder.binding.tvApproveStatus.setTextColor(ContextCompat.getColor(context, android.R.color.black));
            holder.binding.tvApproveStatus.setEnabled(false);
            holder.binding.tvApproveStatus.setText("Discount Applied"+" "+"discount amount"+"("+model.getDiscount_amount()+" "+VariableBag.Rupee+")"+"\n"+"discount percentage -"+model.getDiscount_percentage()+"%");
        }

    }
}

        holder.binding.tvClothOrdCount.setText(model.getOrderProductCount());


        if (model.getDeliveryPickupBySelf() != null && model.getDeliveryPickupBySelf().equalsIgnoreCase("1")) {

//            holder.binding.tvApproveStatus.setText("Apply Discount");
            holder.binding.tvStatusMsg.setVisibility(View.VISIBLE);
            holder.binding.tvStatusMsg.setText("Store delivery to customer");

        } else {

            holder.binding.tvStatusMsg.setVisibility(View.GONE);

        }

        holder.binding.tvApproveStatus.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                changestatus.TrackClick(model, "");
            }
        });


        holder.binding.tvTotalPrice.setText(VariableBag.Rupee + " " + model.getOrderTotalAmount());

        holder.binding.tvUserTime.setText(model.getFromTime() + " - " + model.getToTime());


        holder.binding.tvRejectOrder.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
//                changestatus.CancelClick(model);
            }
        });

        holder.binding.tvAddProduct.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
//                changestatus.CancelClick(model);
            }
        });


        holder.binding.tvComplete.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
//                changestatus.CloseTag(model);
            }
        });

        if (model.getOrderPaymentStatus().equalsIgnoreCase("2")) {

            if (model.getPaymentMode().equalsIgnoreCase("1")) {
                holder.binding.tvPaymentStatus.setText("Paid (COD)");

            } else {
                holder.binding.tvPaymentStatus.setText("Paid (Online)");

            }

        } else {

            if (model.getPaymentMode().equalsIgnoreCase("1")) {
                holder.binding.tvPaymentStatus.setText("Unpaid (Opt for POD)");

            } else {
                holder.binding.tvPaymentStatus.setText("Unpaid");

            }

        }

    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    public interface Changestatus {
        void CancelClick(VendorListResponse.UserOrder data);

        void CloseTag(VendorListResponse.UserOrder data);

        void mapDirection(VendorListResponse.UserOrder data);

        void moreDetails(VendorListResponse.UserOrder data);

        void takeOrder(VendorListResponse.UserOrder data);
//        void approveReschedule(VendorListResponse.UserOrder data);

        void TrackClick(VendorListResponse.UserOrder data, String selectedId);
    }

    public static class VendorViewHolder extends RecyclerView.ViewHolder {
        RawVendorListBinding binding;

        public VendorViewHolder(RawVendorListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
