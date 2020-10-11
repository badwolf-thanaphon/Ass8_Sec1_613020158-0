package layout

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.std_item_layout.view.*

class ViewHolder(view:View):RecyclerView.ViewHolder(view) {

        val tvEmail = view.tv_email
    val tvName = view.tv_name
    val  tvSalary = view.tv_salary
    val tvGender = view.tv_gender
}