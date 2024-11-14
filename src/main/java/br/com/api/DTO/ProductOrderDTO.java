package br.com.api.DTO;

import java.util.Set;

public record ProductOrderDTO(Set<ProductDTO> products) {
}
