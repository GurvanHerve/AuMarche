package com.navrug.aumarche.model

import io.realm.RealmObject

class Recipe() : RealmObject() {
    var _title: String = ""
    var _date: Long = 0
    var _components: List<Component> = ArrayList()

}