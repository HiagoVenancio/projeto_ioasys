package com.hrv.app_android_mvp_kotlin_ioasys.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Empresas(
    @SerializedName("investor") var investor: Investor,
    @SerializedName("portfolio") var portfolio: Portifolio,
    @SerializedName("enterprise") var enterprise: String,
    @SerializedName("success") var success: String):Serializable {
}
