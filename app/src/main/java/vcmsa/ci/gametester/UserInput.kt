package vcmsa.ci.gametester

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserInput : AppCompatActivity() {

    private var intDate = mutableListOf<Int>()
    private var intMinutes = mutableListOf<Int>()

    private lateinit var btnBack:Button
    private lateinit var etDate:EditText
    private lateinit var etMinutes:EditText
    private lateinit var radioGroup:RadioGroup
    private lateinit var radioAction:RadioButton
    private lateinit var radioSimulation:RadioButton
    private lateinit var radioSport:RadioButton
    private lateinit var radioAdventure:RadioButton
    private lateinit var radioGroup2:RadioGroup
    private lateinit var radioRatingOne:RadioButton
    private lateinit var radioRatingTwo:RadioButton
    private lateinit var radioRatingThree:RadioButton
    private lateinit var btnAddEntry:Button
    private lateinit var btnClear:Button
    private lateinit var btnDetailViews:Button



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_input)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnBack=findViewById(R.id.btnBack)
        etDate=findViewById(R.id.etDate)
        etMinutes=findViewById(R.id.etMinutes)
        radioGroup=findViewById(R.id.radioGroup)
        radioAction=findViewById(R.id.radioAction)
        radioSimulation=findViewById(R.id.radioSimulation)
        radioSport=findViewById(R.id.radioSport)
        radioAdventure=findViewById(R.id.radioAdventure)
        radioGroup2=findViewById(R.id.radioGroup2)
        radioRatingOne=findViewById(R.id.radioRatingOne)
        radioRatingTwo=findViewById(R.id.radioRatingTwo)
        radioRatingThree=findViewById(R.id.radioRatingThree)
        btnAddEntry=findViewById(R.id.btnAddEntry)
        btnClear=findViewById(R.id.btnClear)
        btnDetailViews=findViewById(R.id.btnDetailViews)

        btnBack.setOnClickListener {
            intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        btnAddEntry.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Please select a Genre", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var selectedTask=when(selectedRadioButtonId){
                R.id.radioAction->"Action"
                R.id.radioSimulation->"Simulation"
                R.id.radioSport->"Sport"
                R.id.radioAdventure->"Adventure"
                else->"Unknown"
            }

            val selectedRadioButtonId=radioGroup2.checkedRadioButtonId
            if (selectedRadioButtonId==-1){
                Toast.makeText(this, "please select a Rating", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var selectedTask=when(selectedRadioButtonId){
                R.id.radioRatingTwo->"1-2"
                R.id.radioRatingTwo->"3-4"
                R.id.radioRatingThree->"5"
                else->"Unknown"
            }




            }
        btnClear.setOnClickListener {
            //clear all user input.
            etDate.text.clear()
            etMinutes.text.clear()
            radioGroup.clearCheck()
            radioGroup2.clearCheck()
        }

        btnDetailViews.setOnClickListener {
            val intent=Intent(this,DetailViews::class.java)
            startActivity(intent)
        }
         fun dataEntry(){
            val intDate=etDate.text.toString().toIntOrNull()
            val intMinutes=etMinutes.text.toString().toIntOrNull()
            if (intDate !=null && intMinutes!=null){

            }
        }


        }


        }


