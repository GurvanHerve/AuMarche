package com.navrug.aumarche.model

import io.realm.RealmList
import io.realm.RealmObject

open class Recipe : RealmObject() {
    var _name: String = ""
    var _meal: String = Meal.LUNCH.toString()
    var _day: String = Day.SUNDAY.toString()
    var _components: RealmList<Component> = RealmList()

    fun getMeal(): Meal = Meal.valueOf(_meal)
    fun getDay(): Day = Day.valueOf(_day)
}