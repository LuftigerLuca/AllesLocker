package com.alleslocker.backend.application.lock.gateway

import com.alleslocker.backend.application.common.gateway.ReadWriteGateway
import com.alleslocker.backend.domain.lock.Lock
import com.alleslocker.backend.domain.lock.LockId

interface LockGateway : ReadWriteGateway<Lock, LockId> {

}