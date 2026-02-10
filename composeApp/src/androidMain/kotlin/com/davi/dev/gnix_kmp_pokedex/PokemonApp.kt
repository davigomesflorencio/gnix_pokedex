package com.davi.dev.gnix_kmp_pokedex

import android.app.Application
import com.davi.dev.gnix_kmp_pokedex.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class PokemonApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@PokemonApp)
            androidLogger()
        }
    }
}