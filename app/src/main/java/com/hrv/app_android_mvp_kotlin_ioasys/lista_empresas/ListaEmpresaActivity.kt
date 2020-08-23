package com.hrv.app_android_mvp_kotlin_ioasys.lista_empresas

import Empresa
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.hrv.app_android_mvp_kotlin_ioasys.Constantes
import com.hrv.app_android_mvp_kotlin_ioasys.R
import com.hrv.app_android_mvp_kotlin_ioasys.detalhe_empresa.DetalheListaEmpresas
import kotlinx.android.synthetic.main.activity_lista_empresa.*


class ListaEmpresaActivity : AppCompatActivity(), IListaEmpresas.View {

    lateinit var adapter: ListaEmpresasAdapter
    private lateinit var svEmpresasLocal: SearchView
    private lateinit var ivBarLogoLocal: ImageView
    lateinit var presenter: IListaEmpresas.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_empresa)

        configurarElementosIniciais()
        eventosDeClick()
        pesquisaDoFiltro()

        presenter = ListaEmpresaPresenter(this, this@ListaEmpresaActivity)
    }

    private fun pesquisaDoFiltro() {
        svEmpresasLocal.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.pesquisarEmpresa(query!!)
                return false
            }

            override fun onQueryTextChange(text: String): Boolean {

                return false
            }
        })
    }

    private fun eventosDeClick() {
        svEmpresasLocal.setOnSearchClickListener {
            abrirFiltro()
        }
        svEmpresasLocal.setOnCloseListener {
            fecharFiltro()
            false
        }

        lvEmpresas.setOnItemClickListener { parent, view, position, id ->
            val empresa: Empresa = parent.getItemAtPosition(position) as Empresa
            val intent = Intent(this, DetalheListaEmpresas::class.java)
            intent.putExtra(Constantes.KEY_DETALHE_EMPRESA, empresa)
            startActivity(intent)
        }
    }

    private fun configurarElementosIniciais() {
        supportActionBar!!.hide()
        val toolbar = findViewById<View>(R.id.toolbar)
        svEmpresasLocal = toolbar.findViewById(R.id.svEmpresas)
        ivBarLogoLocal = toolbar.findViewById(R.id.ivBarLogo)
    }

    private fun atualizarAdapter(lista: List<Empresa>) {
        lvEmpresas.adapter = null
        adapter = ListaEmpresasAdapter(this@ListaEmpresaActivity, lista)
        lvEmpresas.adapter = adapter
    }

    override fun abrirFiltro() {
        ivBarLogoLocal.visibility = View.GONE
        svEmpresasLocal.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
    }

    override fun fecharFiltro() {
        svEmpresasLocal.layoutParams.width = 0
        ivBarLogoLocal.visibility = View.VISIBLE
    }

    override fun naoAchouEmpresa() {
        lblMsgInicial.visibility = View.GONE
        pbProcuraEmpresa.visibility = View.GONE
        lblEmpresaNaoEncontrada.visibility = View.VISIBLE
    }

    override fun erroAoTrazerEmpresa() {
        pbProcuraEmpresa.visibility = View.GONE
        lblMsgInicial.visibility = View.GONE
        lblEmpresaNaoEncontrada.visibility = View.VISIBLE
    }

    override fun iniciarPesquisaEmpresa() {
        lvEmpresas.adapter = null
        lblMsgInicial.visibility = View.GONE
        lblEmpresaNaoEncontrada.visibility = View.GONE
        pbProcuraEmpresa.visibility = View.VISIBLE
    }

    override fun trouxeEmpresaNaPesquisa() {
        pbProcuraEmpresa.visibility = View.GONE
        lblEmpresaNaoEncontrada.visibility = View.GONE
        lblMsgInicial.visibility = View.GONE
    }

    override fun atualizarListaEmpresas(listaEmpresa: List<Empresa>) {
        atualizarAdapter(listaEmpresa)
    }
}