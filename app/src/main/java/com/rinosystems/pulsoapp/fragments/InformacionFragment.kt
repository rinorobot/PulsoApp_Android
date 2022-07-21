package com.rinosystems.pulsoapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.rinosystems.pulsoapp.Preguntas.Preguntas
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.Seguridad.Seguridad
import com.rinosystems.pulsoapp.Temas.Temas
import com.rinosystems.pulsoapp.Tramites.Tramites


class InformacionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_informacion, container, false)

        val btn_tramites = view.findViewById<Button>(R.id.btn_procedures)
        val btn_seguridad = view.findViewById<Button>(R.id.btn_security)
        val btn_temas = view.findViewById<Button>(R.id.btn_themes)
        val btn_preguntas = view.findViewById<Button>(R.id.btn_questions)

        btn_tramites.setOnClickListener {
            val intent = Intent(requireContext(),Tramites::class.java)
            startActivity(intent)
        }

        btn_seguridad.setOnClickListener {
            val intent = Intent(requireContext(),Seguridad::class.java)
            startActivity(intent)
        }

        btn_temas.setOnClickListener {
            val intent = Intent(requireContext(),Temas::class.java)
            startActivity(intent)
        }
        btn_preguntas.setOnClickListener {
            val intent = Intent(requireContext(),Preguntas::class.java)
            startActivity(intent)
        }



        return view
    }


}