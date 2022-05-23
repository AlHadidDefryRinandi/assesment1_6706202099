package org.d3if2099.hitungpersegipanjang.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if2099.hitungpersegipanjang.model.HasilHitung

class MainViewModel : ViewModel() {
    private val hasilHitung = MutableLiveData<HasilHitung?>()

    fun hitungPersegiPanjang(panjang: Float, lebar: Float) {
        val hasilLuas = panjang * lebar
        val hasilKeliling = (panjang * 2) + (lebar * 2)
        hasilHitung.value = HasilHitung(hasilLuas, hasilKeliling)
    }

    fun getHasilHitung(): LiveData<HasilHitung?> = hasilHitung

}
