package com.example.oterridiscountapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VendorListResponse implements Serializable {

    @SerializedName("userOrderList")
    @Expose
    private List<UserOrder> userOrderList;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("total_orders")
    @Expose
    private String totalOrders;

    public VendorListResponse() {
    }

    public VendorListResponse(List<UserOrder> userOrderList, String message, String status) {
        super();
        this.userOrderList = userOrderList;
        this.message = message;
        this.status = status;
    }

    public String getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(String totalOrders) {
        this.totalOrders = totalOrders;
    }

    public List<UserOrder> getUserOrderList() {
        return userOrderList;
    }

    public void setUserOrderList(List<UserOrder> userOrderList) {
        this.userOrderList = userOrderList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public class UserOrder implements Serializable {

        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("parent_id")
        @Expose
        private String parentId;
        @SerializedName("user_first_name")
        @Expose
        private String userFirstName;
        @SerializedName("user_middle_name")
        @Expose
        private String userMiddleName;
        @SerializedName("user_last_name")
        @Expose
        private String userLastName;
        @SerializedName("user_full_name")
        @Expose
        private String userFullName;
        @SerializedName("country_code")
        @Expose
        private String countryCode;
        @SerializedName("user_mobile")
        @Expose
        private String userMobile;
        @SerializedName("order_address")
        @Expose
        private String orderAddress;
        @SerializedName("order_latitude")
        @Expose
        private String orderLatitude;
        @SerializedName("order_longitude")
        @Expose
        private String orderLongitude;
        @SerializedName("order_taken_date")
        @Expose
        private String orderCreatedDate;
        @SerializedName("order_type")
        @Expose
        private String orderType;
        @SerializedName("order_status")
        @Expose
        private String orderStatus;
        @SerializedName("from_time")
        @Expose
        private String fromTime;
        @SerializedName("to_time")
        @Expose
        private String toTime;
        @SerializedName("user_profile_image")
        @Expose
        private String userProfileImage;
        @SerializedName("tag_count")
        @Expose
        private String tag_count;
        @SerializedName("status_name")
        @Expose
        private String statusName;
        @SerializedName("order_total_amount")
        @Expose
        private String orderTotalAmount;

        @SerializedName("order_product_count")
        @Expose
        private String orderProductCount;
        @SerializedName("delivery_pickup_by_self")
        @Expose
        private String deliveryPickupBySelf;
        @SerializedName("pickup_rider_id")
        @Expose
        private String pickupRiderId;
        @SerializedName("delivery_rider_id")
        @Expose
        private String deliveryRiderId;
        @SerializedName("pickup_rider_name")
        @Expose
        private String pickupRiderName;
        @SerializedName("delivery_rider_name")
        @Expose
        private String deliveryRiderName;
        @SerializedName("ready_product")
        @Expose
        private String readyProduct;
        @SerializedName("pending_product")
        @Expose
        private String pendingProduct;
        @SerializedName("express_product")
        @Expose
        private String expressProduct;

        @SerializedName("payment_mode")
        @Expose
        private String paymentMode;

        @SerializedName("order_payment_status")
        @Expose
        private String orderPaymentStatus;
        @SerializedName("delivery_code")
        @Expose
        private String delivery_code;
        @SerializedName("pickup_code")
        @Expose
        private String pickup_code;
        @SerializedName("drop_pin")
        @Expose
        private String dropPin;
        @SerializedName("collect_pin")
        @Expose
        private String collectPin;
        @SerializedName("request_delivery_date")
        @Expose
        private String requestDeliveryDate;
        @SerializedName("request_delivery_time")
        @Expose
        private String requestDeliveryTime;

        @SerializedName("service_type")
        @Expose
        private String serviceType;

        @SerializedName("order_full_express")
        @Expose
        private String orderFullExpress;


        @SerializedName("request_attempt_slot_id")
        @Expose
        private String requestAttemptSlotId;

        @SerializedName("request_attempt_from_time")
        @Expose
        private String requestAttemptFromTime;

        @SerializedName("request_attempt_to_time")
        @Expose
        private String requestAttemptToTime;

        @SerializedName("request_attempt_date")
        @Expose
        private String requestAttemptDate;


        @SerializedName("attempt_status")
        @Expose
        private String attemptStatus;

        @SerializedName("is_storeorder")
        @Expose
        private String is_storeorder ;

        @SerializedName("discount_amount")
        @Expose
        private String discount_amount ;

        public String getDiscount_percentage() {
            return discount_percentage;
        }

        public void setDiscount_percentage(String discount_percentage) {
            this.discount_percentage = discount_percentage;
        }

        public String getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(String discount_amount) {
            this.discount_amount = discount_amount;
        }

        @SerializedName("discount_percentage")
        @Expose
        private String discount_percentage ;

        public Boolean getIs_discount_applied() {
            return is_discount_applied;
        }

        public void setIs_discount_applied(Boolean is_discount_applied) {
            this.is_discount_applied = is_discount_applied;
        }

        @SerializedName("is_discount_applied")
        @Expose
        private Boolean is_discount_applied ;

        public String getIs_storeorder() {
            return is_storeorder;
        }

        public void setIs_storeorder(String is_storeorder) {
            this.is_storeorder = is_storeorder;
        }


        public UserOrder() {
        }

        public String getDropPin() {
            return dropPin;
        }

        public void setDropPin(String dropPin) {
            this.dropPin = dropPin;
        }

        public String getCollectPin() {
            return collectPin;
        }

        public void setCollectPin(String collectPin) {
            this.collectPin = collectPin;
        }

        public String getRequestAttemptSlotId() {
            return requestAttemptSlotId;
        }

        public void setRequestAttemptSlotId(String requestAttemptSlotId) {
            this.requestAttemptSlotId = requestAttemptSlotId;
        }

        public String getRequestAttemptFromTime() {
            return requestAttemptFromTime;
        }

        public void setRequestAttemptFromTime(String requestAttemptFromTime) {
            this.requestAttemptFromTime = requestAttemptFromTime;
        }

        public String getRequestAttemptToTime() {
            return requestAttemptToTime;
        }

        public void setRequestAttemptToTime(String requestAttemptToTime) {
            this.requestAttemptToTime = requestAttemptToTime;
        }

        public String getRequestAttemptDate() {
            return requestAttemptDate;
        }

        public void setRequestAttemptDate(String requestAttemptDate) {
            this.requestAttemptDate = requestAttemptDate;
        }

        public String getAttemptStatus() {
            return attemptStatus;
        }

        public void setAttemptStatus(String attemptStatus) {
            this.attemptStatus = attemptStatus;
        }

        public String getDeliveryPickupBySelf() {
            return deliveryPickupBySelf;
        }

        public void setDeliveryPickupBySelf(String deliveryPickupBySelf) {
            this.deliveryPickupBySelf = deliveryPickupBySelf;
        }

        public String getPickupRiderId() {
            return pickupRiderId;
        }

        public void setPickupRiderId(String pickupRiderId) {
            this.pickupRiderId = pickupRiderId;
        }

        public String getDeliveryRiderId() {
            return deliveryRiderId;
        }

        public void setDeliveryRiderId(String deliveryRiderId) {
            this.deliveryRiderId = deliveryRiderId;
        }

        public String getPickupRiderName() {
            return pickupRiderName;
        }

        public void setPickupRiderName(String pickupRiderName) {
            this.pickupRiderName = pickupRiderName;
        }

        public String getDeliveryRiderName() {
            return deliveryRiderName;
        }

        public void setDeliveryRiderName(String deliveryRiderName) {
            this.deliveryRiderName = deliveryRiderName;
        }

        public String getReadyProduct() {
            return readyProduct;
        }

        public void setReadyProduct(String readyProduct) {
            this.readyProduct = readyProduct;
        }

        public String getPendingProduct() {
            return pendingProduct;
        }

        public void setPendingProduct(String pendingProduct) {
            this.pendingProduct = pendingProduct;
        }

        public String getExpressProduct() {
            return expressProduct;
        }

        public void setExpressProduct(String expressProduct) {
            this.expressProduct = expressProduct;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getOrderFullExpress() {
            return orderFullExpress;
        }

        public void setOrderFullExpress(String orderFullExpress) {
            this.orderFullExpress = orderFullExpress;
        }

        public String getDelivery_code() {
            return delivery_code;
        }

        public void setDelivery_code(String delivery_code) {
            this.delivery_code = delivery_code;
        }

        public String getPickup_code() {
            return pickup_code;
        }

        public void setPickup_code(String pickup_code) {
            this.pickup_code = pickup_code;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getRequestDeliveryTime() {
            return requestDeliveryTime;
        }

        public void setRequestDeliveryTime(String requestDeliveryTime) {
            this.requestDeliveryTime = requestDeliveryTime;
        }

        public String getRequestDeliveryDate() {
            return requestDeliveryDate;
        }

        public void setRequestDeliveryDate(String requestDeliveryDate) {
            this.requestDeliveryDate = requestDeliveryDate;
        }

        public String getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
        }

        public String getOrderPaymentStatus() {
            return orderPaymentStatus;
        }

        public void setOrderPaymentStatus(String orderPaymentStatus) {
            this.orderPaymentStatus = orderPaymentStatus;
        }

        public String getOrderProductCount() {
            return orderProductCount;
        }

        public void setOrderProductCount(String orderProductCount) {
            this.orderProductCount = orderProductCount;
        }

        public String getTag_count() {
            return tag_count;
        }

        public void setTag_count(String tag_count) {
            this.tag_count = tag_count;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserFirstName() {
            return userFirstName;
        }

        public void setUserFirstName(String userFirstName) {
            this.userFirstName = userFirstName;
        }

        public String getUserMiddleName() {
            return userMiddleName;
        }

        public void setUserMiddleName(String userMiddleName) {
            this.userMiddleName = userMiddleName;
        }

        public String getUserLastName() {
            return userLastName;
        }

        public void setUserLastName(String userLastName) {
            this.userLastName = userLastName;
        }

        public String getUserFullName() {
            return userFullName;
        }

        public void setUserFullName(String userFullName) {
            this.userFullName = userFullName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getUserMobile() {
            return userMobile;
        }

        public void setUserMobile(String userMobile) {
            this.userMobile = userMobile;
        }

        public String getOrderAddress() {
            return orderAddress;
        }

        public void setOrderAddress(String orderAddress) {
            this.orderAddress = orderAddress;
        }

        public String getOrderLatitude() {
            return orderLatitude;
        }

        public void setOrderLatitude(String orderLatitude) {
            this.orderLatitude = orderLatitude;
        }

        public String getOrderLongitude() {
            return orderLongitude;
        }

        public void setOrderLongitude(String orderLongitude) {
            this.orderLongitude = orderLongitude;
        }

        public String getOrderCreatedDate() {
            return orderCreatedDate;
        }

        public void setOrderCreatedDate(String orderCreatedDate) {
            this.orderCreatedDate = orderCreatedDate;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getFromTime() {
            return fromTime;
        }

        public void setFromTime(String fromTime) {
            this.fromTime = fromTime;
        }

        public String getToTime() {
            return toTime;
        }

        public void setToTime(String toTime) {
            this.toTime = toTime;
        }

        public String getUserProfileImage() {
            return userProfileImage;
        }

        public void setUserProfileImage(String userProfileImage) {
            this.userProfileImage = userProfileImage;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public String getOrderTotalAmount() {
            return orderTotalAmount;
        }

        public void setOrderTotalAmount(String orderTotalAmount) {
            this.orderTotalAmount = orderTotalAmount;
        }
    }

}
