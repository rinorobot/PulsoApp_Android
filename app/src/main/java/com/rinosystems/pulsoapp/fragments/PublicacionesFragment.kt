package com.rinosystems.pulsoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.adapters.NoticiasAdapter
import com.rinosystems.pulsoapp.adapters.PublicacionItemAdapter
import com.rinosystems.pulsoapp.adapters.TitulosPublicacionesAdapter
import com.rinosystems.pulsoapp.models.NoticiasData
import com.rinosystems.pulsoapp.models.TitulosPublicaciones
import java.util.ArrayList


class PublicacionesFragment : Fragment(){

    lateinit var rv_titulos: RecyclerView
   // lateinit var adapter_titulos: TitulosPublicacionesAdapter
    private lateinit var dbRef: DatabaseReference
    private lateinit var titulosLista: ArrayList<TitulosPublicaciones>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_publicaciones, container, false)
        rv_titulos = view.findViewById(R.id.publicaciones_rv)
        rv_titulos.layoutManager = LinearLayoutManager(requireContext())
        rv_titulos.setHasFixedSize(true)

        titulosLista = arrayListOf()

        obtenerTitulos()

        return view
    }

    private fun obtenerTitulos() {
        dbRef = FirebaseDatabase.getInstance().getReference("revistas")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (noticiasSnapshot in snapshot.children){
                        val titulo = noticiasSnapshot.getValue(TitulosPublicaciones::class.java)
                        titulosLista.add(titulo!!)


                    }
                   rv_titulos.adapter = TitulosPublicacionesAdapter(requireContext(),titulosLista)


                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("No se puedo obtener la lista")
            }

        })
    }



}