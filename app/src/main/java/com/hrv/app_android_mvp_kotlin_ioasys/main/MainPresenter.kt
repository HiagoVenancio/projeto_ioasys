package com.hrv.app_android_mvp_kotlin_ioasys.main


class MainPresenter(private val view: IMain.View) : IMain.Presenter {

    override fun logout() {
        view.sairDaAplicacao()
    }

}