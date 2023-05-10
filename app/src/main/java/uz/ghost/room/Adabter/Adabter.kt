package uz.ghost.room.Adabter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import uz.ghost.room.R
import uz.ghost.room.databinding.ItemDialogBinding
import uz.ghost.room.databinding.RvItemBinding
import uz.ghost.room.models.Student

class Adapter(var list: List<Student>):RecyclerView.Adapter<Adapter.Vh>(){

    inner class Vh(var itemBinding: RvItemBinding):RecyclerView.ViewHolder(itemBinding.root){
        fun onBind(student: Student){
            itemBinding.name.text = student.name
            itemBinding.number.text = student.grade.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}