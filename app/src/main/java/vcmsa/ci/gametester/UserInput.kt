package vcmsa.ci.gametester

import GameSessionProcessor
import android.adservices.adselection.RemoveAdSelectionOverrideRequest
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

    private lateinit var btnBack: Button
    private lateinit var etGameName: EditText
    private lateinit var etDate: EditText
    private lateinit var etMinutes: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioAction: RadioButton
    private lateinit var radioSimulation: RadioButton
    private lateinit var radioSport: RadioButton
    private lateinit var radioAdventure: RadioButton
    private lateinit var radioGroup2: RadioGroup
    private lateinit var radioRatingOne: RadioButton
    private lateinit var radioRatingTwo: RadioButton
    private lateinit var radioRatingThree: RadioButton
    private lateinit var btnAddEntry: Button
    private lateinit var btnClear: Button
    private lateinit var btnDetailViews: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_input)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnBack = findViewById(R.id.btnBack)
        etGameName = findViewById(R.id.etGameName)
        etDate = findViewById(R.id.etDate)
        etMinutes = findViewById(R.id.etMinutes)
        radioGroup = findViewById(R.id.radioGroup)
        radioAction = findViewById(R.id.radioAction)
        radioSimulation = findViewById(R.id.radioSimulation)
        radioSport = findViewById(R.id.radioSport)
        radioAdventure = findViewById(R.id.radioAdventure)
        radioGroup2 = findViewById(R.id.radioGroup2)
        radioRatingOne = findViewById(R.id.radioRatingOne)
        radioRatingTwo = findViewById(R.id.radioRatingTwo)
        radioRatingThree = findViewById(R.id.radioRatingThree)
        btnAddEntry = findViewById(R.id.btnAddEntry)
        btnClear = findViewById(R.id.btnClear)
        btnDetailViews = findViewById(R.id.btnDetailViews)

        btnBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnAddEntry.setOnClickListener {
            val gameName = etGameName.text.toString().trim()
            val date = etDate.text.toString().trim()
            val minutesStr = etMinutes.text.toString().trim()
            val genreId = radioGroup.checkedRadioButtonId
            val ratingId = radioGroup2.checkedRadioButtonId

            val minutes = minutesStr.toIntOrNull()

            // Validate inputs
            if (gameName.isEmpty() || date.isEmpty() || minutes == null || minutes <= 0 || genreId == -1 || ratingId == -1) {
                Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val genre = findViewById<RadioButton>(genreId).text.toString()
            val ratingText = findViewById<RadioButton>(ratingId).text.toString()
            val rating = ratingText.toIntOrNull() ?: 0

            val success = GameSessionProcessor.addEntry(gameName, date, minutes, rating, genre)
            if (!success) {
                Toast.makeText(this, "Max 7 Entries Reached", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Entry Entered", Toast.LENGTH_SHORT).show()
            }
        }
        btnClear.setOnClickListener {
            //clear all user input.
            etGameName.text.clear()
            etDate.text.clear()
            etMinutes.text.clear()
            radioGroup.clearCheck()
            radioGroup2.clearCheck()
        }

        btnDetailViews.setOnClickListener {
            val intent = Intent(this, DetailViews::class.java)
            intent.putExtra("totalEntries", GameSessionProcessor.getTotalEntries())
            intent.putExtra("averageMins", GameSessionProcessor.getAverageMinutes())

            val highest = GameSessionProcessor.highestScore()
            intent.putExtra("highestRated", highest?.first ?: "N/A")

            val entriesText = GameSessionProcessor.getFormattedEntries().joinToString("\n")
            intent.putExtra("entriesText", entriesText)

            startActivity(intent)
        }


    }


    }




        


