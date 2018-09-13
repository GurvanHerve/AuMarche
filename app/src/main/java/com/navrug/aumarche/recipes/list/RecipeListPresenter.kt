package com.navrug.aumarche.recipes.list

import com.navrug.aumarche.BasePresenter
import com.navrug.aumarche.misc.DataGenerator
import com.navrug.aumarche.model.Recipe
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmResults
import io.realm.kotlin.where

class RecipeListPresenter(private val view: RecipeListView) : BasePresenter<RecipeListView>(view),
        RecipeListener, RealmChangeListener<RealmResults<Recipe>> {
    private lateinit var adapter: RecipeAdapter
    private lateinit var recipes: RealmResults<Recipe>

    fun initialize() {

        generateData()

        recipes = Realm.getDefaultInstance().where<Recipe>().findAll()
        adapter = RecipeAdapter(this)
        adapter.setRecipes(recipes)
        view.setAdapter(adapter)
    }

    override fun resume() {
        super.resume()
        recipes.addChangeListener(this)
    }

    override fun pause() {
        super.pause()
        recipes.removeChangeListener(this)
    }

    override fun onRecipePressed(position: Int) {
        view.showRecipe(recipes[position]!!)
    }

    private fun generateData() = DataGenerator().generateRecipes()

    override fun onChange(t: RealmResults<Recipe>) {
        adapter.notifyDataSetChanged()
    }
}
