package com.davi.dev.gnix_kmp_pokedex

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform