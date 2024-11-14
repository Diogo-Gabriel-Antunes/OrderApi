package br.com.api.DTO;

import java.util.Set;

public record CreateOrderDTO(Set<ProductOrderDTO> productOrderDTO) {
}
