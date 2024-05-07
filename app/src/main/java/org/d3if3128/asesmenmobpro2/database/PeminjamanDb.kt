package org.d3if3128.asesmenmobpro2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3128.asesmenmobpro2.model.Peminjaman

class PeminjamanDb {
    @Database(entities = [Peminjaman::class], version = 1, exportSchema = false)
    abstract class PeminjamanDb : RoomDatabase(){
        abstract val dao: PeminjamanDao

        companion object{
            @Volatile
            private var INSTANCE: PeminjamanDb? =null

            fun getInstance(context: Context): PeminjamanDb {
                synchronized(this){
                    var instance = INSTANCE

                    if (instance == null){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            PeminjamanDb::class.java,
                            "peminjaman.db"
                        ).build()
                        INSTANCE = instance
                    }
                    return instance
                }
            }

        }
    }
}