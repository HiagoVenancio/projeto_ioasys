package com.hrv.app_android_mvp_kotlin_ioasys.lista_empresas

import Empresa
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.hrv.app_android_mvp_kotlin_ioasys.Constantes
import com.hrv.app_android_mvp_kotlin_ioasys.R
import com.hrv.app_android_mvp_kotlin_ioasys.detalhe_empresa.DetalheListaEmpresas
import com.hrv.app_android_mvp_kotlin_ioasys.entities.TipoEmpresa
import kotlinx.android.synthetic.main.activity_lista_empresa.*
import java.util.*


class ListaEmpresaActivity : AppCompatActivity(), IListaEmpresas.View {

    lateinit var adapter: ListaEmpresasAdapter
    private lateinit var svEmpresasLocal :SearchView
    private lateinit var ivBarLogoLocal :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_empresa)

        configurarElementosIniciais()
        eventosDeClick()
        pesquisaDoFiltro()
    }

    private fun pesquisaDoFiltro() {
        svEmpresasLocal.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(text: String): Boolean {
                val num: Int = listaTeste().size
                val listAux: MutableList<Empresa> = ArrayList()
                if (!text.isEmpty()) {
                    for (i in 0 until num) {
                        if (listaTeste().get(i).enterprise_name.toUpperCase()
                                .contains(text.toUpperCase())
                        ) {
                            listAux.add(listaTeste().get(i))
                            atualizarAdapter(listAux)
                        } else {
                            atualizarAdapter(listAux)
                        }
                    }
                } else {
                    lvEmpresas.adapter = null
                    atualizarAdapter(listaTeste() as MutableList<Empresa>)
                }
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
        adapter = ListaEmpresasAdapter(this, listaTeste())
        lvEmpresas.adapter = adapter
    }

    private fun atualizarAdapter(listAux: MutableList<Empresa>) {
        adapter = ListaEmpresasAdapter(this@ListaEmpresaActivity, listAux)
        lvEmpresas.adapter = adapter
    }

    fun listaTeste(): List<Empresa> {
        return listOf(
            Empresa(
                enterprise_name = "Teste",
                enterprise_type = TipoEmpresa(21, "Software"),
                country = "Chile",
                description = "TESTANDO DESCRIPSTIONJASJHFKJDH"
            ), Empresa(
                enterprise_name = "Apple",
                enterprise_type = TipoEmpresa(21, "Software2"),
                country = "Brazil",
                description = "TESTANDO DESCRIPSTIONJASJHFKJDH"
            ), Empresa(
                enterprise_name = "Atari",
                enterprise_type = TipoEmpresa(21, "Software3"),
                country = "Qatar",
                description = "TESTANDO DESCRIPSTIONJASJHFKJDH"
            )
        )


    }

    override fun abrirFiltro() {
        ivBarLogoLocal.visibility = View.GONE
        svEmpresasLocal.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
    }

    override fun fecharFiltro() {
        svEmpresasLocal.layoutParams.width = 0
        ivBarLogoLocal.visibility = View.VISIBLE
    }
}