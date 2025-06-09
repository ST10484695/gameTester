package vcmsa.ci.gametester

import GameSessionProcessor
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class DetailViews : AppCompatActivity() {
    private var tvAllEntries:TextView?=null
    private  var tvTotalEntries:TextView?= null
    private  var tvAverageMins:TextView?=null
    private  var tvHighestRated:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_views)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvTotalEntries=findViewById(R.id.tvTotalEntries)
        tvHighestRated=findViewById(R.id.tvHighestRated)
        tvAverageMins=findViewById(R.id.tvAverageMins)
        tvAllEntries=findViewById(R.id.tvAllEntries)

        val btnBack2 = findViewById<Button>(R.id.btnBack2)

        val tvEntries = findViewById<TextView>(R.id.tvTotalEntries) // Or a separate TextView if you like
        val tvAverageMins = findViewById<TextView>(R.id.tvAverageMins)
        val tvHighestRated = findViewById<TextView>(R.id.tvHighestRated)

        val entries = intent.getStringExtra("entriesText") ?: ""
        val average = intent.getDoubleExtra("averageMins", 0.0)
        val top = intent.getStringExtra("highestRated") ?: "N/A"
        val total = intent.getIntExtra("totalEntries", 0)

        tvEntries.text = entries
        tvAverageMins.text = "Average Minutes: %.2f".format(average)
        tvHighestRated.text = "Highest Rated: $top"






        //set click listeners on buttons
        btnBack2.setOnClickListener {
            intent=Intent(this,UserInput::class.java)
            startActivity(intent)
        }

    }

}