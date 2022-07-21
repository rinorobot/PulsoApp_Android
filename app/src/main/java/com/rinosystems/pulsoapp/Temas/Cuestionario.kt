package com.rinosystems.pulsoapp.Temas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.databinding.ActivityCuestionarioBinding

class Cuestionario : AppCompatActivity() {

    lateinit var bindind: ActivityCuestionarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityCuestionarioBinding.inflate(layoutInflater)
        setContentView(bindind.root)

        bindind.apply {


            btnResult.setOnClickListener {
                val builder = AlertDialog.Builder(this@Cuestionario)
                var record = 0


                // Get the checked radio button id from radio group
                val id : Int = question1.checkedRadioButtonId
                val radio: RadioButton? = findViewById(id)
                val id2: Int = question2.checkedRadioButtonId
                val radio2: RadioButton? = findViewById(id2)
                val id3: Int = question3.checkedRadioButtonId
                val radio3: RadioButton? = findViewById(id3)
                val id4: Int = question4.checkedRadioButtonId
                val radio4: RadioButton? = findViewById(id4)
                val id5: Int = question5.checkedRadioButtonId
                val radio5: RadioButton? = findViewById(id5)
                val id6: Int = question6.checkedRadioButtonId
                val radio6: RadioButton? = findViewById(id6)
                val id7: Int = question7.checkedRadioButtonId
                val radio7: RadioButton? = findViewById(id7)
                val id8: Int = question8.checkedRadioButtonId
                val radio8: RadioButton? = findViewById(id8)
                val id9: Int = question9.checkedRadioButtonId
                val radio9: RadioButton? = findViewById(id9)
                val id10: Int = question10.checkedRadioButtonId
                val radio10: RadioButton? = findViewById(id10)
                val id11: Int = question11.checkedRadioButtonId
                val radio11: RadioButton? = findViewById(id11)
                val id12: Int = question12.checkedRadioButtonId
                val radio12: RadioButton? = findViewById(id12)

                if(radio!=null&&radio2!=null&&radio3!=null&&radio4!=null&&radio5!=null&&radio6!=null&&radio7!=null&&radio8!=null&&radio9!=null&&radio10!=null&&radio11!=null&&radio12!=null) {
                    if (radio.id == rbQ1Answer1.id) {
                        record += 3
                    } else if (radio.id == rbQ1Answer2.id) {
                        record += 2
                    } else if (radio.id == rbQ1Answer3.id) {
                        record += 1
                    } else if (radio.id == rbQ1Answer4.id) {
                        record += 0
                    }


                    if (radio2.id == rbQ2Answer1.id) {
                        record += 3
                    } else if (radio2.id == rbQ2Answer2.id) {
                        record += 2
                    } else if (radio2.id == rbQ2Answer3.id) {
                        record += 1
                    } else if (radio2.id == rbQ2Answer4.id) {
                        record += 0
                    }

                    if (radio3.id == rbQ3Answer1.id) {
                        record += 3
                    } else if (radio3.id == rbQ3Answer2.id) {
                        record += 2
                    } else if (radio3.id == rbQ3Answer3.id) {
                        record += 1
                    } else if (radio3.id == rbQ3Answer4.id) {
                        record += 0
                    }

                    if (radio4.id == rbQ4Answer1.id) {
                        record += 3
                    } else if (radio4.id == rbQ4Answer2.id) {
                        record += 2
                    } else if (radio4.id == rbQ4Answer3.id) {
                        record += 1
                    } else if (radio4.id == rbQ4Answer4.id) {
                        record += 0
                    }

                    if (radio5.id == rbQ5Answer1.id) {
                        record += 3
                    } else if (radio5.id == rbQ5Answer2.id) {
                        record += 2
                    } else if (radio5.id == rbQ5Answer3.id) {
                        record += 1
                    } else if (radio5.id == rbQ5Answer4.id) {
                        record += 0
                    }

                    if (radio6.id == rbQ6Answer1.id) {
                        record += 3
                    } else if (radio6.id == rbQ6Answer2.id) {
                        record += 2
                    } else if (radio6.id == rbQ6Answer3.id) {
                        record += 1
                    } else if (radio6.id == rbQ6Answer4.id) {
                        record += 0
                    }

                    if (radio7.id == rbQ7Answer1.id) {
                        record += 3
                    } else if (radio7.id == rbQ7Answer2.id) {
                        record += 2
                    } else if (radio7.id == rbQ7Answer3.id) {
                        record += 1
                    } else if (radio7.id == rbQ7Answer4.id) {
                        record += 0
                    }

                    if (radio8.id == rbQ8Answer1.id) {
                        record += 3
                    } else if (radio8.id == rbQ8Answer2.id) {
                        record += 2
                    } else if (radio8.id == rbQ8Answer3.id) {
                        record += 1
                    } else if (radio8.id == rbQ8Answer4.id) {
                        record += 0
                    }

                    if (radio9.id == rbQ9Answer1.id) {
                        record += 3
                    } else if (radio9.id == rbQ9Answer2.id) {
                        record += 2
                    } else if (radio9.id == rbQ9Answer3.id) {
                        record += 1
                    } else if (radio9.id == rbQ9Answer4.id) {
                        record += 0
                    }

                    if (radio10.id == rbQ10Answer1.id) {
                        record += 3
                    } else if (radio10.id == rbQ10Answer2.id) {
                        record += 2
                    } else if (radio10.id == rbQ10Answer3.id) {
                        record += 1
                    } else if (radio10.id == rbQ10Answer4.id) {
                        record += 0
                    }

                    if (radio11.id == rbQ11Answer1.id) {
                        record += 3
                    } else if (radio11.id == rbQ11Answer2.id) {
                        record += 2
                    } else if (radio11.id == rbQ11Answer3.id) {
                        record += 1
                    } else if (radio11.id == rbQ11Answer4.id) {
                        record += 0
                    }

                    if (radio12.id == rbQ12Answer1.id) {
                        record += 3
                    } else if (radio12.id == rbQ12Answer2.id) {
                        record += 2
                    } else if (radio12.id == rbQ12Answer3.id) {
                        record += 1
                    } else if (radio12.id == rbQ12Answer4.id) {
                        record += 0
                    }
                    if (record >= 26 && record <= 36) {
                        builder.setMessage("¡CUIDADO! Pide asesoría y apoyo, tu seguridad puede estar en riesgo.")
                        builder.show()
                    } else if (record >= 16 && record <= 25) {
                        builder.setMessage("ESTÁ VIVIENDO VIOLENCIA Tu relación tiene señales de abuso de poder.")
                        builder.show()
                    } else if (record >= 6 && record <= 15) {
                        builder.setMessage("PLATICA CON TU PAREJA, revisa las reglas de tu relación.")
                        builder.show()

                    } else if (record >= 0 && record <= 5) {
                        builder.setMessage("RELACIÓN NO ABUSIVA, tal vez existan algunos problemas que de manera común presentan entre las parejas, pero se resuelven sin violencia.")
                        builder.show()
                    }

                }else{
                    Toast.makeText(this@Cuestionario,"Falta alguna pregunta por responder", Toast.LENGTH_LONG).show()
                }




            }



        }



    }
}