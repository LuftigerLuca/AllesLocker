package com.alleslocker.backend.persistence.lock.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "locks")
open class LockEntity {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    open lateinit var id: String

    @Column(name = "name", nullable = false, unique = false)
    open lateinit var name: String

    @Column(name = "description", nullable = true, unique = false)
    open var description: String? = null
}