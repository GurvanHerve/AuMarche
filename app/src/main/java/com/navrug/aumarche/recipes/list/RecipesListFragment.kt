package com.navrug.aumarche.recipes.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.navrug.aumarche.BaseFragment
import com.navrug.aumarche.R
import com.navrug.aumarche.model.Recipe

class RecipesListFragment : BaseFragment<RecipeListPresenter>(), RecipeListView {
    interface Callback {
        fun showRecipeDetail(recipe: Recipe)
    }

    override fun layoutId(): Int {
        return R.layout.fragment_recipe_list
    }

    override fun presenter(): RecipeListPresenter {
        return RecipeListPresenter(this)
    }

    private lateinit var recipesListView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipesListView = view.findViewById(R.id.recipes_list)
        recipesListView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        presenter.initialize()
    }

    override fun setAdapter(adapter: RecipeAdapter) {
        recipesListView.adapter = adapter
    }

    override fun showRecipe(recipe: Recipe) {
        callBack()?.showRecipeDetail(recipe)
    }

    private fun callBack(): Callback? = if (activity is Callback) activity as Callback else null
}

