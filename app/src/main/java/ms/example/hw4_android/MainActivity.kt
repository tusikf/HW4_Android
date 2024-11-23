package ms.example.hw4_android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
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
        var countradio = 0
        val a = Random.nextInt(101)
        binding.progress1.progress = a
        binding.count1.text = countradio.toString()
        binding.switch1.isChecked = false
        binding.chek1.isEnabled = false
        binding.chek2.isEnabled = false
        binding.button1.isEnabled = false


        binding.switch1.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                // when switch button is checked
                binding.chek1.isEnabled = true
                binding.chek2.isEnabled = true
                Toast.makeText(this, "выбрать обязательно какой-то вариант", Toast.LENGTH_SHORT).show()
                binding.chek1.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        count++
                    }
                }
                binding.chek2.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        count++
                    }
                }
            }
            else{
                // if switch button is unchecked
                binding.chek1.isEnabled = false
                binding.chek2.isEnabled = false
                count = -5
            }
            if (checkSave(binding, countradio, count)) binding.button1.isEnabled = true
        }

        binding.name.doOnTextChanged { text, _, _, _ ->
            if (checkSave(binding, countradio, count)) binding.button1.isEnabled = true

        }
        binding.telefone.setOnClickListener {
            if (checkSave(binding, countradio, count)) binding.button1.isEnabled = true
        }  
        binding.radioGroup.setOnCheckedChangeListener { _, _ ->
            countradio++
            Toast.makeText(this, "нажато", Toast.LENGTH_SHORT).show()
            if (checkSave(binding, countradio, count)) binding.button1.isEnabled = true
        }

        binding.button1.setOnClickListener {
            Toast.makeText(this, "Информация сохранена", Toast.LENGTH_SHORT).show()
        }

    }

    private fun checkSave(binding: ActivityMainBinding, radio: Int, check:Int): Boolean {
        var result = 0
        if (binding.name.text != null) {
            if (binding.telefonvvod.text != null) {
                if (radio > 0) {
                    if (check > 0) result = 1
                }
            }
        }
        else {
            result = 0
        }
        if (result>0) return true
        else return false

    }

}