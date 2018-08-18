package com.navrug.aumarche.model

import io.realm.RealmObject

open class Component : RealmObject() {
    var _ingredient: Ingredient? = null
    var _quantity: Int = 0
    var _unit: String = Unit.G.toString()

    fun getUnit(): Unit = Unit.valueOf(_unit)
}