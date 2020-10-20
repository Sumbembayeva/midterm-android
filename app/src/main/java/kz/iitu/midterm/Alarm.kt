package kz.iitu.midterm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarms")
data class Alarm(
    @ColumnInfo(name = "id") @PrimaryKey val id: Int? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "hour") val hour: Int,
    @ColumnInfo(name = "minute") val minute: Int,
    @ColumnInfo(name = "isActive") val isActive: Boolean
)