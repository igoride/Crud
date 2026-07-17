package com.example.crud.service;

import com.example.crud.dto.ItemDTO;
import com.example.crud.Entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {

    Page<Item> listar(Pageable pageable);

    Item buscarPorId(Long id);

    Item criar(ItemDTO item);

    Item atualizar(Long id, ItemDTO novoItem);

    void deletarById(Long id);
}
