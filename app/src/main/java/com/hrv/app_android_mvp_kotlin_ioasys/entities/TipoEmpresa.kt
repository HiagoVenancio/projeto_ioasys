package com.hrv.app_android_mvp_kotlin_ioasys.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TipoEmpresa(
    @SerializedName("id") var id: Int,
    @SerializedName("enterprise_type_name") var enterprise_type_name: String
    ):Serializable