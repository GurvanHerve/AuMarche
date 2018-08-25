package com.navrug.aumarche.recipes.list

import com.navrug.aumarche.BasePresenter
import com.navrug.aumarche.misc.DataGenerator
import com.navrug.aumarche.model.Recipe
import io.realm.Realm

class RecipeListPresenter(private val view: RecipeListView) : BasePresenter<RecipeListView>(view), RecipeAdapter.RecipeListener {
    private lateinit var adapter: RecipeAdapter

    override fun initialize() {
        super.initialize()

        generateData()

        val res = Realm.getDefaultInstance().where(Recipe::class.java).findAll()
        adapter = RecipeAdapter(this)
        adapter.addRecipes(res)
        view.setAdapter(adapter)
    }

    override fun onRecipePressed() {
        view.showRecipe()
    }

    private fun generateData() = DataGenerator().generateRecipes()
}