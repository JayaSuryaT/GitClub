package com.digitalcrafts.gitClub.data.internal.utils

import com.digitalcrafts.gitClub.data.models.KResult

internal inline fun <T> wrapAsResult(logic: () -> T): KResult<T> {

    val result = runCatching { logic() }

    return result
        .exceptionOrNull()
        ?.let { ex -> KResult.error(throwable = ex) }
        ?: run { KResult.success(result.getOrThrow()) }
}