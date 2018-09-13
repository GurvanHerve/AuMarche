package com.navrug.aumarche.recipes.list

import com.navrug.aumarche.BaseView

interface RecipeListView : BaseView {
    fun setAdapter(adapter: RecipeAdapter)
    fun showRecipe()
}