package com.hrv.app_android_mvp_kotlin_ioasys.lista_empresas

import Empresa

interface IListaEmpresas {

    interface View {
        fun abrirFiltro()
        fun fecharFiltro()
        fun naoAchouEmpresa()
        fun erroAoTrazerEmpresa()
        fun iniciarPesquisaEmpresa()
        fun trouxeEmpresaNaPesquisa()
        fun atualizarListaEmpresas(listaEmpresa: List<Empresa>)
    }

    interface Presenter {
        fun pesquisarEmpresa(nomeEmpresa: String)
    }
}