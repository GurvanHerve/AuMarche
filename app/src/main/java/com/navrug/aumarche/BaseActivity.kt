package com.navrug.aumarche

import android.annotation.SuppressLint
import android.support.annotation.AnimRes
import android.support.annotation.AnimatorRes
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    fun showFragment(@IdRes containerId: Int, fragment: BaseFragment<*>,
                     @AnimatorRes @AnimRes enter: Int, @AnimatorRes @AnimRes popExit: Int) {
        showFragment(containerId, fragment, true, enter, popExit)
    }

    fun showFragment(@IdRes containerId: Int, fragment: BaseFragment<*>) {
        showFragment(containerId, fragment, false, 0, 0)
    }

    private fun showFragment(@IdRes containerId: Int, fragment: BaseFragment<*>, animate: Boolean,
                             @AnimatorRes @AnimRes enter: Int, @AnimatorRes @AnimRes popExit: Int) {
        val transaction = supportFragmentManager.beginTransaction()!!
        transaction.replace(containerId, fragment)
        if (animate) {
            transaction.setCustomAnimations(enter, 0, 0, popExit)
        }
        transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.commit()
    }
}