package com.hazewritescode.friendzover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_main.view.*

class RecipeRecyclerViewAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_main, parent, false)
        return CustomViewHolder(cellForRow)
    }


    override fun getItemCount(): Int {
       return 5
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.recipeTitleTextView.text = "Cereal"
        holder.view.recipeDescTextView.text = "is this the crusty crab?"
    }


    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}