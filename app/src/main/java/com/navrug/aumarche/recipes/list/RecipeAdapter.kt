package com.navrug.aumarche.recipes.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.navrug.aumarche.R
import com.navrug.aumarche.model.Recipe
import com.navrug.aumarche.views.AUTextView

class RecipeAdapter : RecyclerView.Adapter<RecipeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder = RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recipe_row, parent, false))

    override fun getItemCount(): Int = _recipes.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = _recipes[position]

        holder.name.text = recipe._name
        holder.day.text = String.format("%s %s", holder.itemView.context.getString(recipe.getDay()._value), holder.itemView.context.getString(recipe.getMeal()._value))
    }

    private val _recipes = ArrayList<Recipe>()
    fun addRecipes(recipes: List<Recipe>) {
        _recipes.clear()
        _recipes.addAll(recipes)
        notifyDataSetChanged()
    }
}

class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<AUTextView>(R.id.recipe_name)!!
    val day = itemView.findViewById<AUTextView>(R.id.recipe_day)!!

}
