package com.davi.dev.gnix_kmp_pokedex.di

import core.network.di.networkModule
import data.di.repositoryModule
import database.di.databaseModule
import domain.di.useCaseModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import com.davi.dev.gnix_kmp_pokedex.di.modules.viewModelModule

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(databaseModule)
        modules(networkModule)
        modules(repositoryModule)
        modules(useCaseModule)
        modules(viewModelModule)
    }
}