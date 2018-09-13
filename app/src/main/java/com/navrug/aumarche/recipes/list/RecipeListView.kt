package com.navrug.aumarche.recipes.list

import com.navrug.aumarche.BaseView
import com.navrug.aumarche.model.Recipe

interface RecipeListView : BaseView {
    fun setAdapter(adapter: RecipeAdapter)
    fun showRecipe(recipe: Recipe)
}