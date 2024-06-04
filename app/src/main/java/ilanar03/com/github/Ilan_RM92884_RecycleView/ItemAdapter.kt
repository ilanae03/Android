package ilanar03.com.github.Ilan_RM92884_RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PraiaAdapter : RecyclerView.Adapter<PraiaAdapter.ItemViewHolder>() {

    private val items = mutableListOf<PraiaModel>()

    fun addItem(newItem: PraiaModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    fun removeItem(item: PraiaModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itens_praia, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val button = view.findViewById<ImageButton>(R.id.imageViewExcluir)

        fun bind(item: PraiaModel) {
            textView.text = "${item.nomePraia} - ${item.cidade}, ${item.estado}"

            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }
}