package org.d3if2099.hitungpersegipanjang.model

import org.d3if2099.hitungpersegipanjang.db.PersegiPanjangEntity

fun PersegiPanjangEntity.hitungPersegiPanjang(): HasilHitung {
    val hasilLuas = panjang * lebar
    val hasilKeliling = (panjang * 2) + (lebar * 2)
    return HasilHitung(hasilLuas, hasilKeliling )
}
