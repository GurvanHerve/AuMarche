package com.navrug.aumarche.model

import io.realm.RealmObject

open class Component() : RealmObject() {
    var _ingredient: Ingredient? = null
    var _quantity: Int = 0
    var _unit: String = Unit.G.toString()

    constructor(ingredient: Ingredient, quantity: Int, unit: Unit?): this() {
        _ingredient = ingredient
        _quantity = quantity
        _unit = unit.toString()
    }
    constructor(ingredient: Ingredient, quantity: Int): this(ingredient, quantity, null)

    fun getUnit(): Unit = Unit.valueOf(_unit)
}