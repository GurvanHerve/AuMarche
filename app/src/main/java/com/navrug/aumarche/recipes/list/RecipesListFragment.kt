package com.navrug.aumarche.recipes.list

import android.support.v7.widget.LinearLayoutManager
import com.navrug.aumarche.BaseFragment
import com.navrug.aumarche.R
import kotlinx.android.synthetic.main.fragment_recipe_list.*

class RecipesListFragment : BaseFragment<RecipeListPresenter>(), RecipeListView {
    interface Callback {
        fun showRecipe()
    }

    override fun layoutId(): Int {
        return R.layout.fragment_recipe_list
    }

    override fun presenter(): RecipeListPresenter {
        return RecipeListPresenter(this)
    }

    override fun initialize() {
        super.initialize()
        recipes_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun setAdapter(adapter: RecipeAdapter) {
        recipes_list.adapter = adapter
    }

    override fun showRecipe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

