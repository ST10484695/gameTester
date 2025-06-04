package vcmsa.ci.gametester

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart:Button
    private lateinit var btnExit:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnStart=findViewById(R.id.btnStart)
        btnExit=findViewById(R.id.btnExit)

        btnStart.setOnClickListener {
             val intent=Intent(this,UserInput::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            finish()
            System.exit(0)
        }
    }
}