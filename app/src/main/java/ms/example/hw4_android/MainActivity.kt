package ms.example.hw4_android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.switchmaterial.SwitchMaterial
import ms.example.hw4_android.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var count = 0
        val a = Random.nextInt(101)
        binding.progress1.progress = a
        binding.count1.text = a.toString()
        binding.switch1.isChecked = true

        binding.switch1.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                // when switch button is checked
                binding.chek1.isEnabled = true
                binding.chek2.isEnabled = true
                Toast.makeText(this, "что-то работает", Toast.LENGTH_SHORT).show()
                binding.chek1.setOnClickListener {
                    if (binding.chek1.isChecked) count++
                }
                binding.chek2.setOnClickListener {
                    if (binding.chek2.isChecked) count++
                }
            }
            else{
                // if switch button is unchecked
                binding.chek1.isEnabled = false
                binding.chek2.isEnabled = false
                count = -5
            }
        }
        binding.button1.isEnabled = false
        
        binding.nameVvod.setOnClickListener {
            if (binding.nameVvod.isActivated) {
                count++
                Toast.makeText(this, "имя сработало2", Toast.LENGTH_SHORT).show()
            }
            val bb = binding.name.text
            if (bb != null) {
                count++
                Toast.makeText(this, "имя сработало", Toast.LENGTH_SHORT).show()
            }
        }
        binding.telefone.setOnClickListener {
            if (binding.telefone.isEnabled) count++
        }  
        binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                0 -> count++
                1 -> count++
            }
        }


        binding.button1.setOnClickListener {
            if (count > 1) {
                binding.button1.isEnabled = true
            }
            Toast.makeText(this, "Информация сохранена", Toast.LENGTH_SHORT).show()
        }

    }


}