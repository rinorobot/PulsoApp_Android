package com.rinosystems.pulsoapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.database.*
import com.rinosystems.pulsoapp.databinding.ActivityExamenBinding
import com.rinosystems.pulsoapp.imagenesZoom.*
import com.rinosystems.pulsoapp.models.PreguntasData
import com.squareup.picasso.Picasso


class Examen : AppCompatActivity() {

    lateinit var binding: ActivityExamenBinding
    private lateinit var dbRef: DatabaseReference
    private lateinit var preguntasLista: ArrayList<PreguntasData>
    var index: Int = 0
    var correctas: Int = 0
    lateinit var correctasList: ArrayList<Int>
    var incorrectas: Int = 0
    lateinit var incorrectasList: ArrayList<Int>
    var nombre: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.pulsoappcolor)
        window.navigationBarColor =  ContextCompat.getColor(this,R.color.pulsoappcolor)

        preguntasLista = arrayListOf()
        correctasList = arrayListOf()
        incorrectasList = arrayListOf()

        val examen = intent.getStringExtra("examen")
        nombre = intent.getStringExtra("nombre")!!



        if (examen != null){

            dbRef = FirebaseDatabase.getInstance().getReference("examenes").child(examen).child("preguntas")

            dbRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()){

                        for (exasSnapshot in snapshot.children){

                            val preguntas = exasSnapshot.getValue(PreguntasData::class.java)

                            preguntasLista.add(preguntas!!)
                        }

                        binding.btnRespuestaA.setOnClickListener {
                            if (index<preguntasLista.size-1){
                                if (preguntasLista[index].correcta.equals("1")){
                                    correctas = correctas + 1
                                    correctasList.add(index+1)
                                }else{
                                    incorrectas = incorrectas + 1
                                    incorrectasList.add(index+1)
                                }

                                mostrarDatos()
                            }else{
                                if (preguntasLista[index].correcta.equals("1")){
                                    correctas = correctas + 1
                                    correctasList.add(index+1)
                                }else{
                                    incorrectas = incorrectas + 1
                                    incorrectasList.add(index+1)
                                }

                                val intent = Intent(this@Examen,Resultados::class.java)
                                val buenas = correctas.toFloat()
                                val total = preguntasLista.size.toFloat()
                                val resultado: Float = (buenas/total)*10


                                intent.putExtra("resul",resultado)
                                intent.putExtra("lista_incorrectas",incorrectasList)
                                intent.putExtra("lista_correctas",correctasList)
                                intent.putExtra("nombre",nombre)


                                startActivity(intent)
                                this@Examen.finish()


                            }

                        }
                        binding.btnRespuestaB.setOnClickListener {
                            if (index<preguntasLista.size-1){
                                if (preguntasLista[index].correcta.equals("2")){
                                    correctas = correctas + 1
                                    correctasList.add(index+1)
                                }else{
                                    incorrectas = incorrectas + 1
                                    incorrectasList.add(index+1)
                                }

                                mostrarDatos()
                            }else{
                                if (preguntasLista[index].correcta.equals("2")){
                                    correctas = correctas + 1
                                    correctasList.add(index+1)
                                }else{
                                    incorrectas = incorrectas + 1
                                    incorrectasList.add(index+1)
                                }

                                val intent = Intent(this@Examen,Resultados::class.java)
                                val buenas = correctas.toFloat()
                                val total = preguntasLista.size.toFloat()
                                val resultado: Float = (buenas/total)*10



                                intent.putExtra("resul",resultado)
                                intent.putExtra("lista_incorrectas",incorrectasList)
                                intent.putExtra("lista_correctas",correctasList)
                                intent.putExtra("nombre",nombre)
                                startActivity(intent)
                                this@Examen.finish()

                            }

                        }
                        binding.btnRespuestaC.setOnClickListener {
                            if (index<preguntasLista.size-1){
                                if (preguntasLista[index].correcta.equals("3")){
                                    correctas = correctas + 1
                                    correctasList.add(index+1)
                                }else{
                                    incorrectas = incorrectas + 1
                                    incorrectasList.add(index+1)
                                }

                                mostrarDatos()
                            }else{
                                if (preguntasLista[index].correcta.equals("3")){
                                    correctas = correctas + 1
                                    correctasList.add(index+1)
                                }else{
                                    incorrectas = incorrectas + 1
                                    incorrectasList.add(index+1)
                                }

                                val intent = Intent(this@Examen,Resultados::class.java)
                                val buenas = correctas.toFloat()
                                val total = preguntasLista.size.toFloat()
                                val resultado: Float = (buenas/total)*10


                                intent.putExtra("resul",resultado)
                                intent.putExtra("lista_incorrectas",incorrectasList)
                                intent.putExtra("lista_correctas",correctasList)
                                intent.putExtra("nombre",nombre)
                                startActivity(intent)
                                this@Examen.finish()

                            }

                        }
                        binding.btnRespuestaD.setOnClickListener {
                            if (index<preguntasLista.size-1){
                                if (preguntasLista[index].correcta.equals("4")){
                                    correctas = correctas + 1
                                    correctasList.add(index+1)
                                }else{
                                    incorrectas = incorrectas + 1
                                    incorrectasList.add(index+1)
                                }

                                mostrarDatos()
                            }else{
                                if (preguntasLista[index].correcta.equals("4")){
                                    correctas = correctas + 1
                                    correctasList.add(index+1)
                                }else{
                                    incorrectas = incorrectas + 1
                                    incorrectasList.add(index+1)
                                }

                                val intent = Intent(this@Examen,Resultados::class.java)
                                val buenas = correctas.toFloat()
                                val total = preguntasLista.size.toFloat()
                                val resultado: Float = (buenas/total)*10


                                intent.putExtra("resul",resultado)
                                intent.putExtra("lista_incorrectas",incorrectasList)
                                intent.putExtra("lista_correctas",correctasList)
                                intent.putExtra("nombre",nombre)
                                startActivity(intent)

                                this@Examen.finish()
                            }

                        }

                        binding.progressBarExamen.progress = 10
                        binding.tvNombreAsignatura.text = nombre
                        binding.tvNumeroPregunta.text = "Pregunta 1"
                        binding.tvPreguntaExamen.text = preguntasLista[index].pregunta
                        binding.btnRespuestaA.text = preguntasLista[index].respuestaA
                        binding.btnRespuestaB.text = preguntasLista[index].respuestaB
                        binding.btnRespuestaC.text = preguntasLista[index].respuestaC
                        binding.btnRespuestaD.text = preguntasLista[index].respuestaD

                        if (preguntasLista[0].linkPregunta.equals("")){
                            binding.imagenPregunta.visibility = View.GONE
                        }else{
                            binding.imagenPregunta.visibility = View.VISIBLE
                            Picasso.get().load(preguntasLista[0].linkPregunta).into(binding.imagenPregunta)
                            binding.imagenPregunta.setOnClickListener {
                                intent = Intent(this@Examen,ZoomPregunta::class.java)
                                intent.putExtra("imagen",preguntasLista[0].linkPregunta)
                                startActivity(intent)
                            }
                        }
                        if (preguntasLista[0].linkA.equals("")){
                            binding.imagenRespuestaA.visibility = View.GONE
                        }else{
                            binding.imagenRespuestaA.visibility = View.VISIBLE
                            Picasso.get().load(preguntasLista[0].linkA).into(binding.imagenRespuestaA)
                            binding.imagenRespuestaA.setOnClickListener {
                                intent = Intent(this@Examen,ZoomPregunta::class.java)
                                intent.putExtra("imagen",preguntasLista[0].linkA)
                                startActivity(intent)
                            }
                        }
                        if (preguntasLista[0].linkB.equals("")){
                            binding.imagenRespuestaB.visibility = View.GONE
                        }else{
                            binding.imagenRespuestaB.visibility = View.VISIBLE
                            Picasso.get().load(preguntasLista[0].linkB).into(binding.imagenRespuestaB)
                            binding.imagenRespuestaB.setOnClickListener {
                                intent = Intent(this@Examen,ZoomPregunta::class.java)
                                intent.putExtra("imagen",preguntasLista[0].linkB)
                                startActivity(intent)
                            }
                        }
                        if (preguntasLista[0].linkC.equals("")){
                            binding.imagenRespuestaC.visibility = View.GONE
                        }else{
                            binding.imagenRespuestaC.visibility = View.VISIBLE
                            Picasso.get().load(preguntasLista[0].linkC).into(binding.imagenRespuestaC)
                            binding.imagenRespuestaC.setOnClickListener {
                                intent = Intent(this@Examen,ZoomPregunta::class.java)
                                intent.putExtra("imagen",preguntasLista[0].linkC)
                                startActivity(intent)
                            }
                        }
                        if (preguntasLista[0].linkD.equals("")){
                            binding.imagenRespuestaD.visibility = View.GONE
                        }else{
                            binding.imagenRespuestaD.visibility = View.VISIBLE
                            Picasso.get().load(preguntasLista[0].linkD).into(binding.imagenRespuestaD)
                            binding.imagenRespuestaD.setOnClickListener {
                                intent = Intent(this@Examen,ZoomPregunta::class.java)
                                intent.putExtra("imagen",preguntasLista[0].linkD)
                                startActivity(intent)
                            }
                        }






                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    println("No se pudieron cargar los datos")
                }

            })
            }






    }

    private fun mostrarDatos() {
        index = index + 1

        val indexF: Float = index.toFloat()
        val total: Float = preguntasLista.size.toFloat()
        val porcentaje: Float = indexF/total

        binding.progressBarExamen.progress = (porcentaje*100).toInt()+10
        binding.tvNumeroPregunta.text = "Pregunta ${index+1}"
        binding.tvPreguntaExamen.text = preguntasLista[index].pregunta
        binding.btnRespuestaA.text = preguntasLista[index].respuestaA
        binding.btnRespuestaB.text = preguntasLista[index].respuestaB
        binding.btnRespuestaC.text = preguntasLista[index].respuestaC
        binding.btnRespuestaD.text = preguntasLista[index].respuestaD


        if (preguntasLista[index].linkPregunta.equals("")){
            binding.imagenPregunta.visibility = View.GONE
        }else{
            binding.imagenPregunta.visibility = View.VISIBLE
            Picasso.get().load(preguntasLista[index].linkPregunta).into(binding.imagenPregunta)
            binding.imagenPregunta.setOnClickListener {
                intent = Intent(this@Examen,ZoomPregunta::class.java)
                intent.putExtra("imagen",preguntasLista[index].linkPregunta)
                startActivity(intent)
            }
        }
        if (preguntasLista[index].linkA.equals("")){
            binding.imagenRespuestaA.visibility = View.GONE
        }else{
            binding.imagenRespuestaA.visibility = View.VISIBLE
            Picasso.get().load(preguntasLista[index].linkA).into(binding.imagenRespuestaA)
            binding.imagenRespuestaA.setOnClickListener {
                intent = Intent(this@Examen,ZoomPregunta::class.java)
                intent.putExtra("imagen",preguntasLista[index].linkA)
                startActivity(intent)
            }
        }
        if (preguntasLista[index].linkB.equals("")){
            binding.imagenRespuestaB.visibility = View.GONE
        }else{
            binding.imagenRespuestaB.visibility = View.VISIBLE
            Picasso.get().load(preguntasLista[index].linkB).into(binding.imagenRespuestaB)
            binding.imagenRespuestaB.setOnClickListener {
                intent = Intent(this@Examen,ZoomPregunta::class.java)
                intent.putExtra("imagen",preguntasLista[index].linkB)
                startActivity(intent)
            }
        }
        if (preguntasLista[index].linkC.equals("")){
            binding.imagenRespuestaC.visibility = View.GONE
        }else{
            binding.imagenRespuestaC.visibility = View.VISIBLE
            Picasso.get().load(preguntasLista[index].linkC).into(binding.imagenRespuestaC)
            binding.imagenRespuestaC.setOnClickListener {
                intent = Intent(this@Examen,ZoomPregunta::class.java)
                intent.putExtra("imagen",preguntasLista[index].linkC)
                startActivity(intent)
            }
        }
        if (preguntasLista[index].linkD.equals("")){
            binding.imagenRespuestaD.visibility = View.GONE
        }else{
            binding.imagenRespuestaD.visibility = View.VISIBLE
            Picasso.get().load(preguntasLista[index].linkD).into(binding.imagenRespuestaD)
            binding.imagenRespuestaD.setOnClickListener {
                intent = Intent(this@Examen,ZoomPregunta::class.java)
                intent.putExtra("imagen",preguntasLista[index].linkD)
                startActivity(intent)
            }
        }

    }
}