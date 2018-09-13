package com.navrug.aumarche.model

import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.kotlin.createObject
import io.realm.kotlin.where

@RealmClass
open class Recipe : RealmModel {
    @PrimaryKey
    var _id = 1L
        private set

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
            val last = realm.where<Recipe>().findAll().last(null)

            val recipe = if (last != null) {
                realm.createObject<Recipe>( last._id + 1L)
            } else {
                realm.createObject(1L)
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