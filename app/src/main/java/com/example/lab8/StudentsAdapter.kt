package layout

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab8.R

class StudentsAdapter(val item: List<Student>,
                      val context: Context): RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(
            R.layout.std_item_layout
            ,parent,false)
        return ViewHolder(view_item)
    }

    override fun getItemCount(): Int {
return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvGender.text = "Gender: "+ item[position].Gender
        holder.tvEmail.text = "Email: "+ item[position].Email
        holder.tvName.text = "Name: "+ item[position].std_name
        holder.tvSalary.text = "Salary: "+ item[position].Salary.toString()

    }


}