package com.recurringfuture.repertoire

import android.app.Application

class RepertoireApp : Application() {
    val db by lazy {
        RepertoireDatabase.getInstance(this)
    }
}