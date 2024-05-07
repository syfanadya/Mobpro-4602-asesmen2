package org.d3if3128.asesmenmobpro2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="peminjaman")
data class Peminjaman(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val nim: String,
    val nohp: String,
    val judulbuku: String,
    val status: String,
    val tanggalpinjam: String,
    val tanggalkembali: String
)
