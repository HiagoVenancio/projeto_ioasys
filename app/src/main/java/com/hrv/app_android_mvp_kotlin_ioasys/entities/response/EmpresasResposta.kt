package com.hrv.app_android_mvp_kotlin_ioasys.entities.response

import Empresa
import com.google.gson.annotations.SerializedName

class EmpresasResposta( @SerializedName("enterprises") var enterprise: List<Empresa>)