package com.example.crud.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {

    Page<Item> listar(Pageable pageable);

    Item buscarPorId(Long id);

    Item criar(ItemDTO item);

    Item atualizar(Long id, ItemDTO novoItem);

    void deletarById(Long id);
}
