package com.example.oterridiscountapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class PreferenceManager {

    public static PreferenceManager preferenceManager;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public PreferenceManager(Context context) {
        preferenceManager = this;
        mSharedPreferences = context.getSharedPreferences(VariableBag.PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static PreferenceManager getInstance() {
        return preferenceManager;
    }

    public void clearPreferences() {
        mEditor.clear();
        mEditor.commit();
    }

    public void removePref(Context context, String keyToRemove) {
        mSharedPreferences = context.getSharedPreferences(VariableBag.PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mEditor.remove(keyToRemove);
        mEditor.commit();
    }

    public int getVersionCode() {
        return mSharedPreferences.getInt(VariableBag.VERSION_CODE, 0);
    }

    public void setVersionCode(int value) {
        mEditor.putInt(VariableBag.VERSION_CODE, value).commit();
    }

    public String getFbAccessToken() {
        return mSharedPreferences.getString(VariableBag.fb_access_token, "0");
    }

    public void setFbAccessToken(String fbAccessToken) {
        mEditor.putString(VariableBag.fb_access_token, fbAccessToken).commit();
    }

    public String getUserFirstName() {
        return mSharedPreferences.getString(VariableBag.FIRST_NAME, "");
    }

    public void setUserFirstName(String userFirstName) {
        mEditor.putString(VariableBag.FIRST_NAME, userFirstName).commit();
    }

    public String getUserLastName() {
        return mSharedPreferences.getString(VariableBag.LAST_NAME, "");
    }

    public void setUserLastName(String userLastName) {
        mEditor.putString(VariableBag.LAST_NAME, userLastName).commit();
    }

    public String getUserName() {
        return mSharedPreferences.getString(VariableBag.USER_FULL_NAME, "");
    }

    public int getChatMemberCurrentCount() {
        return mSharedPreferences.getInt(VariableBag.CHAT_MEMBER_COUNT, 0);
    }

    public void setChatMemberCurrentCount(int counter) {
        mEditor.putInt(VariableBag.CHAT_MEMBER_COUNT, counter).commit();
    }

    public int getDisplaySize() {
        return mSharedPreferences.getInt(VariableBag.DISPLAYSIZE, 0);
    }

    public void setDisplaySize(int value) {
        mEditor.putInt(VariableBag.DISPLAYSIZE, value).commit();
    }

    public boolean getChatCountView() {
        return mSharedPreferences.getBoolean("ChatCountView", false);
    }

    public void setChatCountView(boolean v) {
        mEditor.putBoolean("ChatCountView", v);
        mEditor.commit();
    }

    public String getRegisteredUserId() {
        return mSharedPreferences.getString(VariableBag.USER_ID, "0");
    }

    public void setRegisteredUserId(String strUserId) {
        mEditor.putString(VariableBag.USER_ID, strUserId).commit();
    }

    public String getRegisterUserArea() {
        return mSharedPreferences.getString(VariableBag.USER_AREA, "0");
    }

    public void setRegisterUserArea(String userArea) {
        mEditor.putString(VariableBag.USER_AREA, userArea).commit();
    }

    public String getRegisterUserLocation() {
        return mSharedPreferences.getString(VariableBag.USER_LOCATION, "0.0");
    }

    public void setRegisterUserLocation(String userLocation) {
        mEditor.putString(VariableBag.USER_LOCATION, userLocation).commit();
    }

    public String getBusinessId() {
        return mSharedPreferences.getString(VariableBag.BusinessId, "");
    }

    public void setBusinessId(String businessId) {
        mEditor.putString(VariableBag.BusinessId, businessId).commit();
    }

    public double getRegisterUserLatitude() {
        return Double.parseDouble(mSharedPreferences.getString(VariableBag.USER_LATITUDE, "0.0"));
    }

    public void setRegisterUserLatitude(String userLatitude) {
        mEditor.putString(VariableBag.USER_LATITUDE, userLatitude).commit();
    }

    public double getRegisterUserLongitude() {
        return Double.parseDouble(mSharedPreferences.getString(VariableBag.USER_LONGITUDE, "0.0"));
    }

    public void setRegisterUserLongitude(String userLongitude) {
        mEditor.putString(VariableBag.USER_LONGITUDE, userLongitude).commit();
    }

    public String getRegisterUserPhoto() {
        return mSharedPreferences.getString(VariableBag.USER_PHOTO, "0");
    }

    public void setRegisterUserPhoto(String userPhoto) {
        mEditor.putString(VariableBag.USER_PHOTO, userPhoto).commit();
    }

    public boolean isNotificationAlert() {
        return mSharedPreferences.getBoolean(VariableBag.NOTIFICATION_ALERT, false);
    }

    public void setNotificationAlert(boolean locationPermission) {
        mEditor.putBoolean(VariableBag.NOTIFICATION_ALERT, locationPermission).commit();
    }

    public boolean isNewOrderRequestFcm() {
        return mSharedPreferences.getBoolean(VariableBag.newOrderRequestFcm, false);
    }

    public void newOrderRequestFcm(boolean locationPermission) {
        mEditor.putBoolean(VariableBag.newOrderRequestFcm, locationPermission).commit();
    }

    public boolean isChatAlert() {
        return mSharedPreferences.getBoolean(VariableBag.CHAT_ALERT, false);
    }

    public void setChatAlert(boolean locationPermission) {
        mEditor.putBoolean(VariableBag.CHAT_ALERT, locationPermission).commit();
    }

    public String getRegisterUserFullName() {
        return mSharedPreferences.getString(VariableBag.USER_FULL_NAME, "0");
    }

    public void setRegisterUserFullName(String userFullName) {
        mEditor.putString(VariableBag.USER_FULL_NAME, userFullName).commit();
    }

    public String getAddress() {
        return mSharedPreferences.getString(VariableBag.ADDRESS, "0");
    }

    public void setAddress(String userFullName) {
        mEditor.putString(VariableBag.ADDRESS, userFullName).commit();
    }

    public String getRegisterUserEmail() {
        return mSharedPreferences.getString(VariableBag.USER_EMAIL, "0");
    }

    public void setRegisterUserEmail(String userEmail) {
        mEditor.putString(VariableBag.USER_EMAIL, userEmail).commit();
    }

    public String getRegisterUserGender() {
        return mSharedPreferences.getString(VariableBag.USER_GENDER, "select");
    }

    public void setRegisterUserGender(String userGender) {
        mEditor.putString(VariableBag.USER_GENDER, userGender).commit();
    }

    public String getRegisterPhoneNumber() {
        return mSharedPreferences.getString(VariableBag.PHONE_NUMBER, "0");
    }

    public void setRegisterPhoneNumber(String phoneNumber) {
        mEditor.putString(VariableBag.PHONE_NUMBER, phoneNumber).commit();
    }

    public Boolean isLogin() {
        return mSharedPreferences.getBoolean(VariableBag.IS_LOGIN, false);
    }

    public void setLogin(boolean isLogin) {
        mEditor.putBoolean(VariableBag.IS_LOGIN, isLogin).commit();
    }

    public void setLoginSession() {
        mEditor.putBoolean(VariableBag.LOGIN, true);
        mEditor.commit();
    }

    public boolean getLoginSession() {
        return mSharedPreferences.getBoolean(VariableBag.LOGIN, false);
    }

    public String getUserCountryCode() {
        return mSharedPreferences.getString(VariableBag.COUNTRY_CODE, "0");
    }

    public void setUserCountryCode(String code) {
        mEditor.putString(VariableBag.COUNTRY_CODE, code).commit();
    }

    public String getLanguageKey() {
        return mSharedPreferences.getString(VariableBag.LANGUAGE_KEY, "0");
    }

    public void setLanguageKey(String key) {
        mEditor.putString(VariableBag.LANGUAGE_KEY, key).commit();
    }

    public String getUserDevice() {
        return mSharedPreferences.getString(VariableBag.USER_DEVICE, "Android");
    }

    public void setUserDevice(String userDevice) {
        mEditor.putString(VariableBag.USER_DEVICE, userDevice).commit();
    }

    public String getAppVersion() {
        return mSharedPreferences.getString(VariableBag.APP_VERSION, "0.0");
    }

    public void setAppVersion(String version) {
        mEditor.putString(VariableBag.APP_VERSION, version).commit();
    }

    public void deleteLoginsession() {
        mEditor.putBoolean(VariableBag.LOGIN, false);
        mEditor.commit();
    }

    public boolean getWiFiSession() {
        boolean login = mSharedPreferences.getBoolean("wifi", false);
        return login;
    }

    public void setWiFiSession(boolean wiFiSession) {
        mEditor.putBoolean("wifi", wiFiSession).commit();
    }

    public void setKeyValueString(String key, String value) {
        mEditor.putString(key, value).commit();
    }

    public void setKeyValueInt(String key, int value) {
        mEditor.putInt(key, value).commit();
    }

    public void setKeyValueBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value).commit();
    }

    public boolean getFirstTime() {

        boolean val = mSharedPreferences.getBoolean("firstTime", true);
        return val;
    }

    public void setFirstTime(boolean key) {

        mEditor.putBoolean("firstTime", key).commit();

    }

    public boolean getVerificationStatus() {
        boolean val = mSharedPreferences.getBoolean(VariableBag.verification_done, false);
        return val;
    }

    public void setVerificationStatus(boolean verificationStatus) {
        mEditor.putBoolean(VariableBag.verification_done, verificationStatus).commit();


    }

    public boolean getVerificationRequest() {
        boolean val = mSharedPreferences.getBoolean(VariableBag.verification_request, false);
        return val;
    }

    public void setVerificationRequest(boolean verificationRequest) {
        mEditor.putBoolean(VariableBag.verification_request, verificationRequest).commit();
    }

    public boolean isBackButtonShow() {

        boolean val = mSharedPreferences.getBoolean("isBackButtonShow", true);
        return val;
    }

    public void setBackButtonShow(boolean key) {

        mEditor.putBoolean("isBackButtonShow", key).commit();

    }

    public String getKeyValueString(String key) {
        String getValue = mSharedPreferences.getString(key, " ");
        return getValue;
    }

    public String getKeyValueStringWithZero(String key) {
        String getValue = mSharedPreferences.getString(key, "0");
        return getValue;
    }

    public int getKeyValueInt(String key) {
        int getValue = mSharedPreferences.getInt(key, 0);
        return getValue;
    }

    public boolean getKeyValueBoolean(String key) {
        boolean getValue = mSharedPreferences.getBoolean(key, false);
        return getValue;
    }


    public void setApikey(String wiFiSession) {
        mEditor.putString("key", wiFiSession).commit();
    }

    public String getApiKey() {

//        return mSharedPreferences.getString("key", "laundryapikey");
        return "laundryapikey";
    }

    public String getBaseUrl() {
//        return mSharedPreferences.getString("baseurl", "");
        return VariableBag.STAFF_URL;
    }

    public void setBaseUrl(String wiFiSession) {
        mEditor.putString("baseurl", wiFiSession).commit();
    }

    public String getBaseUrlApAdmin() {
        return mSharedPreferences.getString("baseurl", "") + VariableBag.APADMIN;
    }

    public String getBackBanner() {
        String val = mSharedPreferences.getString("bannerBack", VariableBag.BACKIMG);
        return val;
    }

    public void setBackBanner(String key) {
        mEditor.putString("bannerBack", key).commit();
    }

    public void setObject(String key, Object object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        mEditor.putString(key, json).commit();
    }

    public <GenericClass> GenericClass getObject(String key, Class<GenericClass> object) {
        try {
            Gson gson = new Gson();
            String json = mSharedPreferences.getString(key, "");
            return gson.fromJson(json, object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getStateId() {
        return mSharedPreferences.getString(VariableBag.STATE_ID, "1");
    }

    public void setStateId(String strStateId) {
        mEditor.putString(VariableBag.STATE_ID, strStateId).commit();
    }

    public String getCityId() {
        return mSharedPreferences.getString(VariableBag.CITY_ID, "");
    }

    public void setCityId(String strCityId) {
        mEditor.putString(VariableBag.CITY_ID, strCityId).commit();
    }

    public JSONArray getJSONKeyArrayObject(String stringKey) {
        JSONObject obj = getJSONObject(VariableBag.LANGUAGE);
        if (stringKey != null && obj != null) {
            try {
                return obj.getJSONArray(stringKey);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public JSONObject getJSONObject(String key) {
        try {
            return new JSONObject(mSharedPreferences.getString(key, ""));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean isVendorExpService() {
        return mSharedPreferences.getBoolean("isVendorExpService", false);
    }

    public void setVendorExpService(boolean express) {
        mEditor.putBoolean("isVendorExpService", express).commit();
    }

    public Boolean isNFCPhone() {
        return mSharedPreferences.getBoolean("nfc_phone", false);
    }

    public void setNFCPhone(boolean express) {
        mEditor.putBoolean("nfc_phone", express).commit();
    }
}


