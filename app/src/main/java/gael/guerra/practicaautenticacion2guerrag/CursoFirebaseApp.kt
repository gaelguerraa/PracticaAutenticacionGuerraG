package gael.guerra.practicaautenticacion2guerrag

import android.app.Application
import android.content.Context

class CursoFirebaseApp : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}