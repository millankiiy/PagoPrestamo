package com.prestamigos.pago.infraestructure.driver_adapters.external_repository;

import com.prestamigos.pago.domain.model.gateway.ClienteGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@RequiredArgsConstructor
public class ClienteGatewayImpl implements ClienteGateway {

    private final RestTemplate restTemplate;

    private final String URL_CLIENTE = "https://usuario-production-3568.up.railway.app/api/prestamigos/cliente";

    @Override
    public boolean existeCliente(Long clienteId) {
        try {
            String url = URL_CLIENTE + "/" + clienteId;

            restTemplate.getForObject(url, Object.class);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}