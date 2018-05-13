package com.navrug.aumarche

import android.app.Application
import io.realm.Realm

class AuMarcheApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
    }
}