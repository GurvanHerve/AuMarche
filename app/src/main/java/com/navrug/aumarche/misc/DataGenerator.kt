package com.navrug.aumarche.misc

import android.util.Log
import com.navrug.aumarche.model.*
import com.navrug.aumarche.model.Unit
import io.realm.Realm
import java.util.*
import kotlin.collections.ArrayList

class DataGenerator {

    companion object {
        const val LOREM = "Lorem ipsum dolor sit amet, metus nunc quam libero, arcu gravida vel sit pellentesque"
    }

    private val rand: Random = Random()

    fun generateRecipes() {
        for (i in 0..10) {
            generateRecipe()
        }
    }

    private fun generateRecipe() {
        Realm.getDefaultInstance().executeTransactionAsync({
            val recipe = it.createObject(Recipe::class.java)

            for (i in 0..rand.nextInt(10)) recipe._components.add(generateComponent(it))

            recipe._name = LOREM
            recipe._day = dayPicker().toString()
            recipe._meal = mealPicker().toString()
        })
    }

    private fun generateComponent(realm: Realm): Component {
        val component = realm.createObject(Component::class.java)
        component._ingredient = generateIngredient(realm)
        component._quantity = rand.nextInt(200)
        if (rand.nextBoolean()) {
            val unit = Unit.values()
            component._unit = unit[rand.nextInt(unit.size)].toString()
        }
        return component
    }

    private fun generateIngredient(realm: Realm): Ingredient{
        val ingredient = realm.createObject(Ingredient::class.java)
        ingredient._name = LOREM
        return ingredient
    }

    private fun mealPicker(): Meal {
        val meals = Meal.values()
        return meals[rand.nextInt(meals.size)]
    }

    private fun dayPicker(): Day {
        val days = Day.values()
        return days[rand.nextInt(days.size)]
    }
}