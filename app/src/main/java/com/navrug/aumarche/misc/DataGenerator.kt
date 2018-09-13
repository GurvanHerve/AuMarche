package com.navrug.aumarche.misc

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
        Realm.getDefaultInstance().executeTransaction{
            val componentSize = rand.nextInt(10)
            val components = ArrayList<Component>(componentSize)

            for (i in 0..componentSize) components.add(generateComponent(it))

            Recipe.create(LOREM, dayPicker(), mealPicker(), components, it)
        }
    }

    private fun generateComponent(realm: Realm): Component {
        val component = Component()
        component._ingredient = ingredientPicker(realm)
        component._quantity = rand.nextInt(200)
        if (rand.nextBoolean()) {
            val unit = Unit.values()
            component._unit = unit[rand.nextInt(unit.size)].toString()
        }
        return component
    }

    private fun ingredientPicker(realm: Realm): Ingredient {
        val ingredients = realm.where(Ingredient::class.java).findAll()
        return ingredients[rand.nextInt(ingredients.size)]!!
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