package com.hrv.app_android_mvp_kotlin_ioasys.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Investor(
    @SerializedName("id") var id: Int,
    @SerializedName("investor_name") var investor_name: String,
    @SerializedName("email") var email: String,
    @SerializedName("city") var city: String,
    @SerializedName("balance") var country: Double,
    @SerializedName("photo") var photo: String,
    @SerializedName("portfolio_value") var portfolio_value: Double,
    @SerializedName("first_access") var first_access: Boolean,
    @SerializedName("super_angel") var super_angel: Boolean
) : Serializable