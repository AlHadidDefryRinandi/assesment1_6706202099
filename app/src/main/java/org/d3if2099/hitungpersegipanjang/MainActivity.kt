package org.d3if2099.hitungpersegipanjang

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import org.d3if2099.hitungpersegipanjang.databinding.ActivityMainBinding
import org.d3if2099.hitungpersegipanjang.model.HasilHitung


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { hitungPersegiPanjang() }
        viewModel.getHasilHitung().observe(this, { showResult(it) })
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

        viewModel.hitungPersegiPanjang(
            panjang.toFloat(),
            lebar.toFloat(),
        )
    }

    @SuppressLint("StringFormatMatches")
    private fun showResult(result: HasilHitung?) {
        if (result == null) return
        binding.hasil1TextView.text = getString(R.string.hasil_luas, result.hasilLuas)
        binding.hasil2TextView.text = getString(R.string.hasil_keliling, result.hasilKeliling)
    }
}