package com.navrug.aumarche.model

import io.realm.RealmObject

class Component : RealmObject() {
    enum class Unit {
        mL,
        cL,
        dL,
        g
    }
    var _ingredient: Ingredient = Ingredient()
    var _quantity: Int = 0
    var _unity: Unit = Unit.mL
}