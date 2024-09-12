package com.example.oterridiscountapp.utils;

import android.app.NotificationManager;


import com.example.oterridiscountapp.BuildConfig;

import org.json.JSONObject;

import okhttp3.MultipartBody;

public class VariableBag {

    public static final String MAIN_KEY = "Bms";
    public static final String USER_LOCATION = "USER_LOCATION";
    public static final String USER_AREA = "USER_AREA";
    public static final String BusinessId = "BusinessId";
    public static final String NOTIFICATION_ALERT = "NOTIFICATION_ALERT";
    public static final String newOrderRequestFcm = "newOrderRequestFcm";
    public static final String CHAT_ALERT = "CHAT_ALERT";
    public static final String USER_LATITUDE = "USER_LATITUDE";
    public static final String USER_LONGITUDE = "USER_LONGITUDE";
    public static final int MAX_FILE_UPLOAD_SIZE = 5;
    public static MultipartBody.Part partsFilePick;
    public static String filenameWorkReport;
    public static String PREF_NAME = "Laundry";
    public static String PHONE_NUMBER = "PHONE_NUMBER";
    public static String IS_LOGIN = "IS_LOGIN";
    public static String CURRENCY = "$";
    public static String PREF_NAME_ADD_MORE = "ADD_MORE";
    public static String USER_ID = "user_id";
    public static String fb_access_token = "fb_access_token";
    public static String verification_done = "verification_done";
    public static String verification_request = "verification_request";
    public static String USER_FULL_NAME = "USER_FULL_NAME";
    public static String ADDRESS = "ADDRESS";
    public static String USER_EMAIL = "USER_EMAIL";
    public static String USER_GENDER = "USER_GENDER";
    public static String USER_PHOTO = "USER_PHOTO";
    public static String FULL_NAME = "user_full_name";
    public static String FIRST_NAME = "user_first_name";
    public static String LAST_NAME = "user_last_name";
    public static String MOBILE = "user_mobile";
    public static String EMAIL = "user_email";
    public static String ID_PROOF = "user_id_proof";
    public static String USER_TYPE = "user_type";
    public static String USER_STATUS = "user_status";
    public static String SUCCESS_CODE = "200";
    public static String FAIL_CODE = "201";
    public static String LOGIN = "LOGIN";
    public static String Express = "Express";
    public static String COUNTRY_CODE = "COUNTRY_CODE";
    public static String LANGUAGE_KEY = "LANGUAGE_KEY";
    public static String USER_DEVICE = "USER_DEVICE";
    public static String APP_VERSION = "APP_VERSION";
    public static String Rupee = "₹ ";

    public static String VERSION_CODE = "version_code";
    public static int ERROR = 1;

    public static String SUB_URL = "adminApi/";
    public static String APADMIN = "apAdmin/";

    public static String BACKIMG = "";

    public static NotificationManager visitorNotificationNM;
    public static int NOTIFICATION_SOS_ID = 888;
    public static JSONObject mainObjectJSON;
    public static boolean isBackground = false;

    public static String LAST_NOTIFICATION_ID = "last_noti";

    public static boolean IsWhiteLabelApp = false;


    public static String STATE_ID = "state_id";
    public static String CITY_ID = "city_id";
    public static String CHAT_MEMBER_COUNT = "chatMCount";


    public static String[] mColors = {
            "EF5350", "FF1744",
            "EC407A",
            "AB47BC", "E040FB",
            "7E57C2",
            "5C6BC0", "00B0FF",
            "42A5F5", "1DE9B6",
            "29B6F6", "00E676",
            "26C6DA", "00C853",
            "26A69A", "64DD17",
            "66BB6A", "FFC400",
            "9CCC65", "795548",
            "D4E157", "757575"
            , "546E7A",
            "FFCA28",
            "FFA726",
            "FF7043",
            "8D6E63",
            "78909C",
    };


    public static String DISPLAYSIZE = "display_size";

    public static String MSG_TYPE_TEXT = "0";
    public static String MSG_TYPE_IMAGE = "1";
    public static String MSG_TYPE_FILE = "2";
    public static String MSG_TYPE_AUDIO = "3";
    public static String MSG_TYPE_LOCATION = "4";
    public static String MSG_TYPE_CONTACT = "5";
    public static String MSG_TYPE_VIDEO = "6";
    public static String LANGUAGE = "language_data";
    public static String partsFilePickName;
    //  public static String BASE_URL = "https://dev.oterri.com/";

//        public static String BASE_URL = BuildConfig.DEBUG ? "https://dev.oterri.com/" : "https://live.oterri.com/ ";
    public static String BASE_URL = BuildConfig.DEBUG ? "https://qa.oterri.com/" : "https://admin.oterri.com/";
//    public static String BASE_URL = BuildConfig.DEBUG ?  "https://admin.oterri.com/" : "https://live.oterri.com/";
//    public static String BASE_URL = BuildConfig.DEBUG ?  "https://amd.oterri.com/" : "https://live.oterri.com/";


    public static String OFFER_URL = BASE_URL + "offerApi/";

    // public static String VENDOR_URL = BASE_URL + "vendorApi/";
    public static String STAFF_URL = BASE_URL + "staffApi/";
    public static String TC_URL = BASE_URL + "policy.php?page=vendorTermsOfService";
    public static String CL_URL = BASE_URL + "policy.php?page=vendorCancellationPolicy";
    public static String PRV_URL = BASE_URL + "policy.php?page=vendorPrivacyPolicy";
    public static String APP_PLAY_STORE_LINK = "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;

}
