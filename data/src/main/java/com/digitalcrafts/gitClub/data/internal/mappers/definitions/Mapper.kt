package com.digitalcrafts.gitClub.data.internal.mappers.definitions

internal fun interface Mapper<in T, out R> {
    fun map(model: T): R
}