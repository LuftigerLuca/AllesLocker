package com.alleslocker.backend.persistence.lock.adapter

import com.alleslocker.backend.application.lock.gateway.LockGateway
import com.alleslocker.backend.domain.lock.Lock
import com.alleslocker.backend.domain.lock.LockId
import com.alleslocker.backend.persistence.lock.mapper.toDomain
import com.alleslocker.backend.persistence.lock.mapper.toEntity
import com.alleslocker.backend.persistence.lock.repository.LockRepository
import org.springframework.stereotype.Component

@Component
class LockGatewayAdapter (
    private val repository: LockRepository
): LockGateway {
    override fun save(entity: Lock): Lock {
        val existing = repository.findById(entity.id.value).orElse(null)
        return repository.save(entity.toEntity(existing)).toDomain()
    }

    override fun deleteById(id: LockId) {
        repository.deleteById(id.value)
    }

    override fun findById(id: LockId): Lock? =
        repository.findById(id.value).orElse(null)?.toDomain()


    override fun exists(id: LockId): Boolean =
        repository.existsById(id.value)
}