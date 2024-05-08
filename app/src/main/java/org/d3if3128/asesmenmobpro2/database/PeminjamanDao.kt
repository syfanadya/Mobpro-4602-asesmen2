package org.d3if3128.asesmenmobpro2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3128.asesmenmobpro2.model.Peminjaman

@Dao
interface PeminjamanDao {
    @Insert
    suspend fun insert(peminjaman: Peminjaman)

    @Update
    suspend fun update(peminjaman: Peminjaman)

    @Query("SELECT * FROM  peminjaman ORDER BY tanggalpinjam DESC")
    fun getPeminjaman(): Flow<List<Peminjaman>>

    @Query("SELECT * FROM peminjaman WHERE id = :id")
    suspend fun getPeminjamanById(id: Long): Peminjaman?

    @Query("DELETE FROM peminjaman WHERE id = :id")
    suspend fun deleteById(id:Long)
}