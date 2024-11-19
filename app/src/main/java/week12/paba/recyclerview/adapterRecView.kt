package week12.paba.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class adapterRecView (private val listWayang: ArrayList<wayang>) : RecyclerView.Adapter<adapterRecView.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _foto = itemView.findViewById<ImageView>(R.id.gambarWayang)
        var _nama = itemView.findViewById<TextView>(R.id.namaWayang)
        var _karakter = itemView.findViewById<TextView>(R.id.karakterWayang)
        var _deskripsi = itemView.findViewById<TextView>(R.id.deskripsiWayang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWayang.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var wayang = listWayang[position]

        holder._nama.setText(wayang.nama)
        holder._karakter.setText(wayang.karakter)
        holder._deskripsi.setText(wayang.deskripsi)
        Log.d("TEST", wayang.foto)
        Picasso.get()
            .load(wayang.foto)
            .into(holder._foto)

        holder._foto.setOnClickListener {
            Toast.makeText(holder.itemView.context, wayang.nama, Toast.LENGTH_LONG).show()
        }
    }
}