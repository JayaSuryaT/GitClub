package com.digitalcrafts.gitClub.data.internal.mappers.definitions

import com.digitalcrafts.gitClub.data.internal.DomainModel
import com.digitalcrafts.gitClub.data.internal.EntityModel

internal interface EntityToDomainMapper<in T : EntityModel, out R : DomainModel> : Mapper<T, R>