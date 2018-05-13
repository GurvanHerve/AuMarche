package com.navrug.aumarche.model

import io.realm.RealmList
import io.realm.RealmObject

open class Recipe() : RealmObject() {
    var _name: String = ""
    var _meal: String = Meal.LUNCH.toString()
    var _day: String = Day.SUNDAY.toString()
    var _components: RealmList<Component> = RealmList()

    constructor(name: String, meal: Meal, day:Day, components: List<Component>): this() {
        _name = name
        _meal = meal.toString()
        _day = day.toString()
       // _components = components
    }

    fun getMeal(): Meal = Meal.valueOf(_meal)
    fun getDay(): Day = Day.valueOf(_day)
}