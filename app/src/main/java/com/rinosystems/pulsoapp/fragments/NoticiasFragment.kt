package com.rinosystems.pulsoapp.fragments



import android.content.Intent
import android.nfc.Tag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.firebase.database.*
import com.rinosystems.pulsoapp.DetalleNoticia
import com.rinosystems.pulsoapp.Network.NetworkStatus
import com.rinosystems.pulsoapp.Network.NetworkStatusHelper
import com.rinosystems.pulsoapp.Network.RetofitClient
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.adapters.NoticiasAdapter
import com.rinosystems.pulsoapp.models.NewsData
import com.rinosystems.pulsoapp.models.NewsDataItem
import com.rinosystems.pulsoapp.models.NoticiasData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList



class NoticiasFragment : Fragment(), NoticiasAdapter.MyViewHolder.OnNoticiasClickListener {

    private lateinit var dbRef: DatabaseReference
    private lateinit var noticiasRV: RecyclerView
    private lateinit var noticiasLista: ArrayList<NewsDataItem>
    private lateinit var swipeNoticias: SwipeRefreshLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment




         val view = inflater.inflate(R.layout.fragment_noticias, container, false)

        swipeNoticias = view.findViewById(R.id.swipeNoticias)
        noticiasRV = view.findViewById(R.id.lista_noticias)
        noticiasRV.layoutManager = LinearLayoutManager(requireContext())
        noticiasRV.setHasFixedSize(true)


        noticiasLista = arrayListOf()
        obtenerNoticias()


        swipeNoticias.setOnRefreshListener {
            swipeNoticias.setColorSchemeResources(R.color.colorBlueAdd)
            noticiasRV.layoutManager = LinearLayoutManager(requireContext())
            noticiasRV.setHasFixedSize(true)


            noticiasLista = arrayListOf()
            obtenerNoticias()
            swipeNoticias.isRefreshing = false
        }








        return view
    }






    private fun obtenerNoticias() {
        val retrofitTraer = RetofitClient.consumirApi.getTraer()

        retrofitTraer.enqueue(object : Callback<NewsData>{
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
             //   print(response.body().toString())
             //   Log.d("noticias",response.body().toString())
                noticiasLista = response.body()!!
                noticiasRV.adapter = NoticiasAdapter(noticiasLista,this@NoticiasFragment)
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Toast.makeText(requireContext(), "Error al consultar el servidor de noticias"+t.message.toString(), Toast.LENGTH_LONG).show()

            }

        })


//        dbRef = FirebaseDatabase.getInstance().getReference("noticias")
//
//        dbRef.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if (snapshot.exists()){
//                    for (noticiasSnapshot in snapshot.children){
//
//                        val noticia = noticiasSnapshot.getValue(NoticiasData::class.java)
//
//                        noticiasLista.add(noticia!!)
//                    }
//                    noticiasRV.adapter = NoticiasAdapter(noticiasLista,this@NoticiasFragment)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                println("No se puedo obtener la lista")
//            }
//
//        })

    }

    override fun onItemClick(noticiasData: NewsDataItem) {
        val intent = Intent(requireContext(),DetalleNoticia::class.java)
        intent.putExtra("noticia",noticiasData)
        startActivity(intent)
    }


}