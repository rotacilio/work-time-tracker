package br.com.rotacilio.worktimetracker.database

import android.content.Context
import br.com.rotacilio.worktimetracker.models.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var boxStore: BoxStore
        private set

    fun init(context: Context) {
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .build()
    }
}