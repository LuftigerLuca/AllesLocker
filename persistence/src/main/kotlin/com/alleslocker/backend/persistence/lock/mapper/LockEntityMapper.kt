package com.alleslocker.backend.persistence.lock.mapper

import com.alleslocker.backend.domain.lock.Lock
import com.alleslocker.backend.domain.lock.LockDescription
import com.alleslocker.backend.domain.lock.LockId
import com.alleslocker.backend.domain.lock.LockName
import com.alleslocker.backend.persistence.lock.entity.LockEntity

fun LockEntity.toDomain(): Lock = Lock(
    id = LockId(this.id),
    name = LockName(this.name),
    description = this.description?.let { LockDescription(it) },
)
fun Lock.toEntity(existing: LockEntity? = null): LockEntity {
    val entity = existing ?: LockEntity()

    entity.id = this.id.value
    entity.name = this.name.value
    entity.description = this.description?.value
    return entity
}