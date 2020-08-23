package com.hrv.app_android_mvp_kotlin_ioasys.utilitarios

import android.content.Context
import android.preference.PreferenceManager

@Suppress("DEPRECATION")
class SharedPreferencesConfig {

    companion object {

        fun salvarEstado(context: Context?, key:String, value: String) {
            val edit = PreferenceManager.getDefaultSharedPreferences(context)
            val editor1 = edit.edit()
            editor1.putString(key, value)
            editor1.apply()
        }

        fun recuperarEstado(context: Context?, key:String): String {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getString(key, "")!!
        }

        fun limparEstado(context: Context?) {
            val edit = PreferenceManager.getDefaultSharedPreferences(context)
            val editor1 = edit.edit()
            editor1.clear()
            editor1.apply()
        }
    }
}