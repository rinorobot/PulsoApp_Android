package com.rinosystems.pulsoapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

import com.rinosystems.pulsoapp.Examen
import com.rinosystems.pulsoapp.Notificaciones.NotificationManager
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.adapters.ExamenesAdapter

import com.rinosystems.pulsoapp.models.ExamenesData
import java.text.Normalizer

import java.util.ArrayList


class ExamenesFragment : Fragment(), ExamenesAdapter.ExamenesViewHolder.OnNoticiasClickListener {
    private lateinit var dbRef: DatabaseReference
    private lateinit var recyclerViewExamenes: RecyclerView
    private lateinit var exaemnesLista: ArrayList<ExamenesData>
    private lateinit var search: EditText
    private lateinit var adapter: ExamenesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NotificationManager.notificationLiveData.observe(viewLifecycleOwner, { message ->
            message?.let {
                AlertDialog.Builder(requireContext())
                    .setTitle("Notificación")
                    .setMessage(it)
                    .setPositiveButton("OK") { dialog, which ->
                        // Manejar el clic del botón aquí si es necesario
                    }
                    .show()
            }
        })
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_examenes, container, false)
        search = view.findViewById(R.id.searchEditText)
        recyclerViewExamenes = view.findViewById(R.id.recyclerView_examenes)
        recyclerViewExamenes.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewExamenes.setHasFixedSize(true)
        exaemnesLista = arrayListOf()
        obtenerExamenes()



        return view
    }

    private fun obtenerExamenes() {
       dbRef = FirebaseDatabase.getInstance().getReference("examenes")
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    for (exasSnapshot in snapshot.children){

                       val examen = exasSnapshot.getValue(ExamenesData::class.java)
                        examen!!.key = exasSnapshot.key
                        exaemnesLista.add(examen!!)

                    }

                    recyclerViewExamenes.adapter = ExamenesAdapter(exaemnesLista,this@ExamenesFragment)
                    search.addTextChangedListener {textFilter ->
                        val examenFilter = exaemnesLista.filter { examenesData ->
                            examenesData.nombre_examen!!.sinAcentos().contains(textFilter.toString().sinAcentos())
                        }

                        recyclerViewExamenes.adapter = ExamenesAdapter(examenFilter,this@ExamenesFragment)

                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("No se pudieron cargar los datos")
            }

        })
    }

    override fun onItemClick(examen: String, nombre: String) {
        val intent = Intent(requireContext(), Examen::class.java)
        intent.putExtra("examen",examen)
        intent.putExtra("nombre",nombre)
        startActivity(intent)
    }

    fun String.sinAcentos(): String {
        val textoNormalizado = Normalizer.normalize(this, Normalizer.Form.NFD)
        val regex = "\\p{InCombiningDiacriticalMarks}+".toRegex()
        return regex.replace(textoNormalizado, "").toLowerCase()
    }



}