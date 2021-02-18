package com.shakil.simpleimagegallery.util

interface Mapper<T, U> {
    fun map(input: T): U
}

fun failMissingField(name: String): Nothing {
    throw IllegalArgumentException("${name ?: ""} is missing form server response" )
}