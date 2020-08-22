package com.hrv.app_android_mvp_kotlin_ioasys.entities

import com.google.gson.annotations.SerializedName

class Portifolio(
    @SerializedName("enterprises_number") var enterprises_number: Int,
    @SerializedName("enterprises") var enterprises: List<String>
) {
}
