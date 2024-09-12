package com.example.oterridiscountapp;

import static com.example.oterridiscountapp.utils.PreferenceManager.preferenceManager;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.oterridiscountapp.databinding.ActivityVendorListBinding;
import com.example.oterridiscountapp.network.RestCall;
import com.example.oterridiscountapp.network.RestClient;
import com.example.oterridiscountapp.utils.GzipUtils;
import com.example.oterridiscountapp.utils.PreferenceManager;
import com.example.oterridiscountapp.utils.VariableBag;
import com.google.gson.Gson;

import java.util.Objects;

import rx.Subscriber;
import rx.schedulers.Schedulers;

public class VendorListActivity extends AppCompatActivity {
    ActivityVendorListBinding binding;
    ReasonDialogFragment reasonDialogFragment;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_vendor_list);
        preferenceManager=new PreferenceManager(this);

        CallApi();

        binding.swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                CallApi();
            }
        });


    }


    public void CallApi() {
        showProgressDialog();
        new ExampleAsyncTask().execute();
        RestClient.createServiceForString(RestCall.class, VariableBag.OFFER_URL, preferenceManager.getApiKey()).
                vendorProcessOrderList("vendorProcessOrderList",
                        preferenceManager.getLanguageKey())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                hideProgressDialog();
                                binding.swipe.setRefreshing(false);
                                Toast.makeText(VendorListActivity.this, "No Internet connection", Toast.LENGTH_SHORT).show();
                            }
                        });





                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onNext(String encData) {
                           runOnUiThread(() -> {

                                VendorListResponse approvedActiveListResponse = null;
                                try {

                                    approvedActiveListResponse = new Gson().fromJson(GzipUtils.decrypt(encData), VendorListResponse.class);
                                    try {
                                        if (approvedActiveListResponse.getTotalOrders() != null && !approvedActiveListResponse.getTotalOrders().trim().isEmpty() && Integer.parseInt(approvedActiveListResponse.getTotalOrders()) > 0) {
                                            binding.addOrder.setVisibility(View.GONE);
                                            binding.addOrder.setText("New Requests(" + approvedActiveListResponse.getTotalOrders() + ")");
                                        } else {
                                            binding.addOrder.setVisibility(View.GONE);
                                            binding.addOrder.setText("New Requests");
                                        }
                                    } catch (Exception ignored) {

                                    }


                                    if (Objects.equals(approvedActiveListResponse.getStatus(), VariableBag.SUCCESS_CODE)) {

                                        binding.swipe.setRefreshing(false);
                                        binding.recyclerViewActiveOrder.setVisibility(View.VISIBLE);
                                       LinearLayoutManager layoutManager = new LinearLayoutManager(VendorListActivity.this);
                                       binding.recyclerViewActiveOrder.setLayoutManager(layoutManager);
                                       VendorListAdapter pickupInspectionAdapter = new VendorListAdapter(VendorListActivity.this, approvedActiveListResponse.getUserOrderList());
                                        binding.recyclerViewActiveOrder.setAdapter(pickupInspectionAdapter);
                                        binding.tvNoData.setVisibility(View.GONE);
                                        binding.llSearch.setVisibility(View.VISIBLE);
                                        hideProgressDialog();
                                        pickupInspectionAdapter.setUpInterface(new VendorListAdapter.Changestatus() {
                                            @Override
                                            public void CancelClick(VendorListResponse.UserOrder data) {

                                            }

                                            @Override
                                            public void CloseTag(VendorListResponse.UserOrder data) {

                                            }

                                            @Override
                                            public void mapDirection(VendorListResponse.UserOrder data) {

                                            }

                                            @Override
                                            public void moreDetails(VendorListResponse.UserOrder data) {

                                            }

                                            @Override
                                            public void takeOrder(VendorListResponse.UserOrder data) {

                                            }

                                            @Override
                                            public void TrackClick(VendorListResponse.UserOrder data, String selectedId) {
                                                OpenDialog(data.getOrderId(),data.getUserId());


                                            }
                                        });


                                    } else {
                                        hideProgressDialog();

                                       binding. recyclerViewActiveOrder.setVisibility(View.GONE);
                                        binding.tvNoData.setVisibility(View.VISIBLE);
                                        binding.swipe.setRefreshing(false);
                                        //Tools.toast(requireActivity(), approvedActiveListResponse.getMessage(), 0);
                                    }
                                } catch (Exception e) {

                                }
                            });
                        }

                });

    }


    public  void OpenDialog(String orderId,String userId){
         reasonDialogFragment= new ReasonDialogFragment();
        reasonDialogFragment.show(getSupportFragmentManager(),"dailog");
        reasonDialogFragment.setCancelable(false);
        reasonDialogFragment.setTitleText("Discount");
        reasonDialogFragment.setDialogInfo("Are you sure to apply discount");
        reasonDialogFragment.setDialogCancelText("Cancel");
        reasonDialogFragment.setDialogApproveText("Apply");
        reasonDialogFragment.setUpInterface(new ReasonDialogFragment.ReasonClick() {
            @Override
            public void confirmClick(String data) {
                CallAddOfferApi(orderId,userId,data);
            }

            @Override
            public void cancelClick() {
                reasonDialogFragment.dismiss();

            }
        });
    }




    public void CallAddOfferApi(String orderId,String userId,String percentage) {
        showProgressDialog();
        RestClient.createServiceForString(RestCall.class, VariableBag.OFFER_URL, preferenceManager.getApiKey()).
                add_offer("add_offer",
                        preferenceManager.getLanguageKey(),orderId,userId,percentage)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                binding.swipe.setRefreshing(false);
                                hideProgressDialog();
                                Toast.makeText(VendorListActivity.this, "No Internet connection", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onNext(String encData) {
                        runOnUiThread(() -> {

                            VendorListResponse approvedActiveListResponse = null;
                            try {

                                approvedActiveListResponse = new Gson().fromJson(GzipUtils.decrypt(encData), VendorListResponse.class);
                                if (Objects.equals(approvedActiveListResponse.getStatus(), VariableBag.SUCCESS_CODE)) {
                                    hideProgressDialog();
                                    reasonDialogFragment.dismiss();
                                    CallApi();


                                } else {
                                    hideProgressDialog();
                                    Toast.makeText(VendorListActivity.this, "Discount can't apply", Toast.LENGTH_SHORT).show();

                                }
                            } catch (Exception e) {
                                hideProgressDialog();
                            }
                        });
                    }

                });

    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(VendorListActivity.this);
        progressDialog.setMessage("Loading, please wait...");
        progressDialog.setCancelable(false); // Prevent dialog from being dismissed by user
        progressDialog.show();
    }

    private void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private class ExampleAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            // Perform background task
            try {
                Thread.sleep(3000); // Simulate a long task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // Hide progress dialog
            hideProgressDialog();
        }
    }
}