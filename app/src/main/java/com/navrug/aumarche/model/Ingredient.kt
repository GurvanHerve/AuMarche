package com.navrug.aumarche.model

import io.realm.Realm
import io.realm.RealmObject
import io.realm.kotlin.createObject
import io.realm.kotlin.where

open class Ingredient : RealmObject() {
    var _name = ""
        private set

    companion object {
        fun create(ingredientName: String, realm: Realm) {
                var ingredient = realm.where<Ingredient>()
                        .equalTo("_name", ingredientName.toLowerCase())
                        .findFirst()

            if (ingredient == null) {
                ingredient = Realm.getDefaultInstance().createObject()
                ingredient._name = ingredientName
            }
        }
    }
}