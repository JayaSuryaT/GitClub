package com.digitalcrafts.gitClub.data.internal.mappers.definitions

import com.digitalcrafts.gitClub.data.internal.DtoModel
import com.digitalcrafts.gitClub.data.internal.EntityModel

internal interface DtoToEntityMapper<in T : DtoModel, out R : EntityModel> : Mapper<T, R>