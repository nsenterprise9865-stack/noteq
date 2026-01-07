package com.example.noteq

import android.app.Application
import com.example.noteq.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NoteqApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NoteqApplication)
            modules(appModule)
        }
    }
}
