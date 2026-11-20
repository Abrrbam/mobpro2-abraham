package com.abraham0058.mobpro2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform