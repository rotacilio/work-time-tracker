package br.com.rotacilio.worktimetracker

import android.app.Application
import br.com.rotacilio.worktimetracker.database.ObjectBox

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }
}