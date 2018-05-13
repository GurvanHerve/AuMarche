package com.navrug.aumarche

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.navrug.aumarche.misc.DataGenerator
import com.navrug.aumarche.model.Recipe
import com.navrug.aumarche.recipes.list.RecipeAdapter
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateData()

        val adapter = RecipeAdapter()
        recipes_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recipes_list.adapter = adapter

        val res = Realm.getDefaultInstance().where(Recipe::class.java).findAll()
        adapter.addRecipes(res)
    }

    private fun generateData() = DataGenerator().generateRecipes()
}
