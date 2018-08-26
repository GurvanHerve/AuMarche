package com.navrug.aumarche.model

import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Recipe : RealmObject() {
    @PrimaryKey
    private var _id = 0L

    var _name = ""
        private set
    private var _meal = ""
    private var _day = ""
    var _components: RealmList<Component> = RealmList()
        private set

    fun getMeal(): Meal = Meal.valueOf(_meal)
    fun getDay(): Day = Day.valueOf(_day)

    companion object {
        fun create(recipeName: String, day: Day, meal: Meal, components: List<Component>, realm: Realm) {
            val last = realm.where(Recipe::class.java).findAll().last()

            val recipe = if (last != null) {
                realm.createObject(Recipe::class.java, last._id + 1L)
            } else {
                realm.createObject(Recipe::class.java)
            }

            recipe._name = recipeName
            recipe._day = day.toString()
            recipe._meal = meal.toString()

            for (component in components) recipe._components.add(Component.create(component, realm))
        }

        fun delete() {

        }
    }
}