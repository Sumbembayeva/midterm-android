package kz.iitu.midterm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kz.iitu.midterm.Alarm
@Dao
interface AlarmDao{
    @Insert
    fun insertItem(item: Alarm)

    @Query("Delete FROM alarms WHERE id =:id")
    fun deleteAlarm(id: Int): Unit

    @Query("SELECT * FROM alarms")
    fun getAllItems() : List<Alarm>
}