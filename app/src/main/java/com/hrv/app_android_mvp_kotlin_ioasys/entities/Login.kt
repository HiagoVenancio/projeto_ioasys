package com.hrv.app_android_mvp_kotlin_ioasys.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Login(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
):Serializable