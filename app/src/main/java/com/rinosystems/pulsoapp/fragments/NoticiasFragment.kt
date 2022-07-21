package com.rinosystems.pulsoapp.fragments



import android.content.Intent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.rinosystems.pulsoapp.DetalleNoticia
import com.rinosystems.pulsoapp.Network.NetworkStatus
import com.rinosystems.pulsoapp.Network.NetworkStatusHelper
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.adapters.NoticiasAdapter
import com.rinosystems.pulsoapp.models.NoticiasData
import java.util.ArrayList


class NoticiasFragment : Fragment(), NoticiasAdapter.MyViewHolder.OnNoticiasClickListener {

    private lateinit var dbRef: DatabaseReference
    private lateinit var noticiasRV: RecyclerView
    private lateinit var noticiasLista: ArrayList<NoticiasData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment




         val view = inflater.inflate(R.layout.fragment_noticias, container, false)

        noticiasRV = view.findViewById(R.id.lista_noticias)
        noticiasRV.layoutManager = LinearLayoutManager(requireContext())
        noticiasRV.setHasFixedSize(true)

        noticiasLista = arrayListOf()
        obtenerNoticias()






        return view
    }






    private fun obtenerNoticias() {
        dbRef = FirebaseDatabase.getInstance().getReference("noticias")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (noticiasSnapshot in snapshot.children){

                        val noticia = noticiasSnapshot.getValue(NoticiasData::class.java)

                        noticiasLista.add(noticia!!)
                    }
                    noticiasRV.adapter = NoticiasAdapter(noticiasLista,this@NoticiasFragment)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("No se puedo obtener la lista")
            }

        })

    }

    override fun onItemClick(noticiasData: NoticiasData) {
        val intent = Intent(requireContext(),DetalleNoticia::class.java)
        intent.putExtra("noticia",noticiasData)
        startActivity(intent)
    }


}