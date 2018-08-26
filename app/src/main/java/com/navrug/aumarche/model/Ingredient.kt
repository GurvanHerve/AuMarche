package com.navrug.aumarche.model

import io.realm.Realm
import io.realm.RealmObject

open class Ingredient : RealmObject() {
    var _name = ""
        private set

    companion object {
        fun create(ingredientName: String, realm: Realm) {
                var ingredient = realm.where(Ingredient::class.java)
                        .equalTo("_name", ingredientName.toLowerCase())
                        .findFirst()

            if (ingredient == null) {
                ingredient = Realm.getDefaultInstance().createObject(Ingredient::class.java)
                ingredient._name = ingredientName
            }
        }
    }
}