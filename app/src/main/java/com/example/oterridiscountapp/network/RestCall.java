package com.example.oterridiscountapp.network;


import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Single;

public interface RestCall {

    @FormUrlEncoded
    @POST("orderListController.php")
    Single<String> vendorProcessOrderList(@Field("vendorProcessOrderList") String vendorProcessOrderList,
                                          @Field("language_id") String language_id);

    @FormUrlEncoded
    @POST("offerController.php")
    Single<String> add_offer(@Field("add_offer") String add_offer,
                                          @Field("language_id") String language_id,
                                          @Field("order_id") String order_id,
                                          @Field("user_id") String user_id,
                                          @Field("discount_per") String discount_per);
}
