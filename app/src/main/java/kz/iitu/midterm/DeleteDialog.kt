package kz.iitu.midterm

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import kz.iitu.midterm.db.AppDatabase

class DeleteDialog(context: Context, item: Alarm) : DialogFragment() {
    private val appContext = context
    private val item = item
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Do you want to delete? " )
                .setNegativeButton("NO"){
                        dialog, id ->  dialog.cancel()
                }
                .setPositiveButton("YES") {
                        dialog, id ->  dialog.cancel()
                    AsyncTask.execute{
                        AppDatabase.getInstance(this.appContext)?.getItemDao()?.deleteAlarm(item.id!!)
                    }
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}
