package com.hrv.app_android_mvp_kotlin_ioasys.utilitarios

import android.content.Intent

abstract class Util {

    companion object {

        fun limparActivitiesAnteriores(intent: Intent) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        }
    }
}