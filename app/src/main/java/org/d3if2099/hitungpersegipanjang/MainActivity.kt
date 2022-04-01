package org.d3if2099.hitungpersegipanjang

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if2099.hitungpersegipanjang.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { hitungPersegiPanjang() }
    }


    @SuppressLint("StringFormatMatches")
    private fun hitungPersegiPanjang() {
        val panjang = binding.panjangInp.text.toString()
        if (TextUtils.isEmpty(panjang)) {
            Toast.makeText(this, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val lebar = binding.lebarInp.text.toString()
        if (TextUtils.isEmpty(lebar)) {
            Toast.makeText(this, R.string.lebar_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val selectedId = binding.radioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, R.string.jenis_invalid, Toast.LENGTH_LONG).show()
            return
        }

        if (selectedId == R.id.luasRadioButton){
            val hasil = panjang.toFloat() * lebar.toFloat()
            binding.hasilTextView.text = getString(R.string.hasil_x, hasil)
        } else {
            val hasil2 = (panjang.toFloat() * 2) + (lebar.toFloat()* 2)
            binding.hasilTextView.text = getString(R.string.hasil_x, hasil2)
        }
    }

}