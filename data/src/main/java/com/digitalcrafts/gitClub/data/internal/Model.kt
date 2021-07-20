package com.digitalcrafts.gitClub.data.internal

internal sealed interface Model

internal interface DtoModel : Model
internal interface EntityModel : Model
internal interface DomainModel : Model