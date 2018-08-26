package com.navrug.aumarche

import android.app.Application
import com.navrug.aumarche.model.Ingredient
import io.realm.Realm
import io.realm.RealmConfiguration

class AuMarcheApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initRealm()
        initIngredients()
    }

    private val DATABASE_VERSION = 1L
    private fun initRealm() {
        Realm.init(this)
        val realmConfigurationBuilder = RealmConfiguration.Builder()
                .schemaVersion(DATABASE_VERSION)
        Realm.setDefaultConfiguration(realmConfigurationBuilder.build())
    }

    private fun initIngredients() {
        Realm.getDefaultInstance().executeTransactionAsync{ realm ->
            resources.getStringArray(R.array.ingredients).forEach {
                Ingredient.create(it, realm)
            }
        }
    }
}