package com.navrug.aumarche

import android.os.Bundle
import com.navrug.aumarche.recipes.list.RecipesListFragment

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(R.id.recipes_list_container, RecipesListFragment())
    }
}
