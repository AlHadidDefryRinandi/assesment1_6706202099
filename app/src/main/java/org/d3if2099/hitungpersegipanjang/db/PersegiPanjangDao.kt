package org.d3if2099.hitungpersegipanjang.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersegiPanjangDao {
    @Insert
    fun insert(hasil: PersegiPanjangEntity)
    @Query("SELECT * FROM hasil ORDER BY id DESC LIMIT 1")
    fun getLastPersegiPanjang(): LiveData<PersegiPanjangEntity?>
}
