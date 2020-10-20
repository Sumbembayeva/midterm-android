package kz.iitu.midterm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.alarm_item.view.*

class Adapter(
    val items: ArrayList<Alarm>,
    private val onClickItem: (Alarm) -> Unit,
    private val onLongClickItem: (Alarm) -> Unit

) : RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.alarm_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindUser(items[position], onClickItem, onLongClickItem)
    }

}
class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

    fun bindUser( item: Alarm, onClickItem: (Alarm) -> Unit, onLongClickItem: (Alarm) -> Unit) {
        view.name.text = item.name
        view.time.text = item.hour.toString() + " : " + item.minute.toString()
        view.switcher.isChecked = item.isActive
        view.setOnClickListener {
            onClickItem(item)
        }
        view.setOnLongClickListener{
            onLongClickItem(item)
            return@setOnLongClickListener true
        }
    }
}