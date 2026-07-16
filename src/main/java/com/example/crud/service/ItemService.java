package com.example.crud.service;

import com.example.crud.dto.ItemDTO;
import com.example.crud.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> listar();

    Item buscarPorId(Long id);

    Item criar(ItemDTO item);

    Item atualizar(Long id, ItemDTO novoItem);

    void deletarById(Long id);
}
