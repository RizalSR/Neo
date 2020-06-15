package com.example.neo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataUser {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("country_id")
    @Expose
    private int country_id;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("verification_code")
    @Expose
    private String verification_code;

    @SerializedName("sms_code")
    @Expose
    private String sms_code;

    @SerializedName("phone_verify")
    @Expose
    private int phone_verify;

    @SerializedName("email_verify")
    @Expose
    private int email_verify;

    @SerializedName("email_time")
    @Expose
    private String email_time;

    @SerializedName("phone_time")
    @Expose
    private String phone_time;

    @SerializedName("id_type")
    @Expose
    private int id_type;

    @SerializedName("id_number")
    @Expose
    private String id_number;

    @SerializedName("id_card_image")
    @Expose
    private String id_card_image;

    @SerializedName("place_of_birth")
    @Expose
    private String place_of_birth;

    @SerializedName("birth_date")
    @Expose
    private String birth_date;

    @SerializedName("selfie_image")
    @Expose
    private String selfie_image;

    @SerializedName("verify_id")
    @Expose
    private int verify_id;

    @SerializedName("verify_timestamp")
    @Expose
    private String verify_timestamp;

    @SerializedName("verify_remaks")
    @Expose
    private String verify_remaks;

    @SerializedName("reference")
    @Expose
    private String reference;

    @SerializedName("va_number")
    @Expose
    private String va_number;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("login_time")
    @Expose
    private String login_time;

    @SerializedName("user_timezone")
    @Expose
    private String user_timezone;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("zip_code")
    @Expose
    private String zip_code;

    @SerializedName("authy_id")
    @Expose
    private String authy_id;

    @SerializedName("whatsapp")
    @Expose
    private String whatsapp;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("api_token")
    @Expose
    private String api_token;

    @SerializedName("is_agen")
    @Expose
    private int is_agen;

    @SerializedName("role")
    @Expose
    private int role;

    @SerializedName("admin_level")
    @Expose
    private int admin_level;

    @SerializedName("grace_period_limit")
    @Expose
    private String grace_period_limit;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;

    @SerializedName("deleted_at")
    @Expose
    private String deleted_at;

    public DataUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public String getSms_code() {
        return sms_code;
    }

    public void setSms_code(String sms_code) {
        this.sms_code = sms_code;
    }

    public int getPhone_verify() {
        return phone_verify;
    }

    public void setPhone_verify(int phone_verify) {
        this.phone_verify = phone_verify;
    }

    public int getEmail_verify() {
        return email_verify;
    }

    public void setEmail_verify(int email_verify) {
        this.email_verify = email_verify;
    }

    public String getEmail_time() {
        return email_time;
    }

    public void setEmail_time(String email_time) {
        this.email_time = email_time;
    }

    public String getPhone_time() {
        return phone_time;
    }

    public void setPhone_time(String phone_time) {
        this.phone_time = phone_time;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getId_card_image() {
        return id_card_image;
    }

    public void setId_card_image(String id_card_image) {
        this.id_card_image = id_card_image;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getSelfie_image() {
        return selfie_image;
    }

    public void setSelfie_image(String selfie_image) {
        this.selfie_image = selfie_image;
    }

    public int getVerify_id() {
        return verify_id;
    }

    public void setVerify_id(int verify_id) {
        this.verify_id = verify_id;
    }

    public String getVerify_timestamp() {
        return verify_timestamp;
    }

    public void setVerify_timestamp(String verify_timestamp) {
        this.verify_timestamp = verify_timestamp;
    }

    public String getVerify_remaks() {
        return verify_remaks;
    }

    public void setVerify_remaks(String verify_remaks) {
        this.verify_remaks = verify_remaks;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getVa_number() {
        return va_number;
    }

    public void setVa_number(String va_number) {
        this.va_number = va_number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getUser_timezone() {
        return user_timezone;
    }

    public void setUser_timezone(String user_timezone) {
        this.user_timezone = user_timezone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getAuthy_id() {
        return authy_id;
    }

    public void setAuthy_id(String authy_id) {
        this.authy_id = authy_id;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public int getIs_agen() {
        return is_agen;
    }

    public void setIs_agen(int is_agen) {
        this.is_agen = is_agen;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getAdmin_level() {
        return admin_level;
    }

    public void setAdmin_level(int admin_level) {
        this.admin_level = admin_level;
    }

    public String getGrace_period_limit() {
        return grace_period_limit;
    }

    public void setGrace_period_limit(String grace_period_limit) {
        this.grace_period_limit = grace_period_limit;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
}
