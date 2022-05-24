package org.d3if2099.hitungpersegipanjang.ui.histori

import androidx.lifecycle.ViewModel
import org.d3if2099.hitungpersegipanjang.db.PersegiPanjangDao

class HistoriViewModel(db: PersegiPanjangDao) : ViewModel() {
    val data = db.getLastPersegiPanjang()
}
