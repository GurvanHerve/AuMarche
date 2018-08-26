package com.navrug.aumarche.model

import io.realm.Realm
import io.realm.RealmObject

open class Component : RealmObject() {
    var _ingredient: Ingredient = Ingredient()
    var _quantity = 0
    var _unit: String? = null

    fun getUnit(): Unit? = _unit?.let { Unit.valueOf(it) }

    companion object {
        fun create(component: Component, realm: Realm): Component {
            if (!component.isManaged && !component.isValid) {
                return create(component._ingredient, component._quantity, component.getUnit(), realm)
            }
            return component
        }

        fun create(ingredient: Ingredient, quantity: Int, unit: Unit?, realm: Realm): Component {
            val component = realm.createObject(Component::class.java)
            component._ingredient = ingredient
            component._quantity = quantity
            component._unit = unit?.toString()
            return component
        }
    }
}