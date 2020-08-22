package com.hrv.app_android_mvp_kotlin_ioasys.entities.response

import com.google.gson.annotations.SerializedName
import com.hrv.app_android_mvp_kotlin_ioasys.entities.Investor
import com.hrv.app_android_mvp_kotlin_ioasys.entities.Portifolio
import java.io.Serializable

class LoginResposta(
    @SerializedName("investor") var investor: Investor,
    @SerializedName("portfolio") var portfolio: Portifolio,
    @SerializedName("enterprise") var enterprise: String,
    @SerializedName("success") var success: String):Serializable {
}
