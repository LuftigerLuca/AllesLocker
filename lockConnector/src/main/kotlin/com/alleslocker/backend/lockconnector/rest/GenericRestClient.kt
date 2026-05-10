package com.alleslocker.backend.lockconnector.rest

import com.alleslocker.backend.lockconnector.config.ConnectionConfig
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class GenericRestClient(
    private val config: ConnectionConfig
) {
    private val client: RestClient by lazy {
        RestClient.builder()
            .baseUrl(config.baseUrl)
            .build()
    }
    fun post(endpoint: String, body: Any, headers: Map<String, String> =emptyMap()) {
        client.post()
            .uri(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .headers { header -> headers.forEach {
                (k, v) -> header.set(k,v) }
            }
            .body(body)
            .retrieve()
            .toBodilessEntity()
    }
}