package kz.iitu.midterm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kz.iitu.midterm.Alarm

@Database(entities = [Alarm::class] , version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getItemDao(): AlarmDao

    companion object{
        private const val DB_NAME = "alarmApp.db"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase?{
            if (instance == null){
                instance = Room.databaseBuilder(context,
                    AppDatabase::class.java, DB_NAME).build()
            }
            return instance
        }

        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }
    }
}