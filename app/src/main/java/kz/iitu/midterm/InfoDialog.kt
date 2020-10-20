package kz.iitu.midterm

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class InfoDialog(  item: Alarm) : DialogFragment() {

    private val timeLeft = 24*60 - item.hour* 60 + item.minute
    val minute = timeLeft % 60
    val hour  = (timeLeft / 60).toInt()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(hour.toString() +" hours " + minute.toString() + " minutes left" )
                .setPositiveButton("ОК") {
                        dialog, id ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}