package com.hazewritescode.friendzover.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hazewritescode.friendzover.HomeFeed
import com.hazewritescode.friendzover.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_main.view.*

class RecipeRecyclerViewAdapter(private val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_main, parent, false)
        return CustomViewHolder(cellForRow)
    }


    override fun getItemCount(): Int {
       return homeFeed.meals.count()
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val recipe = homeFeed.meals[position]
        holder.view.recipeTitleTextView.text = recipe.strMeal
        val articleImageView = holder.view.recipeImageView
        Picasso.get().load(recipe.strMealThumb).into(articleImageView)

    }


    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}