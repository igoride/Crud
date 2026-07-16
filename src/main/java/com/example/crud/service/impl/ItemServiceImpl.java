package com.example.crud.service.impl;

import com.example.crud.dto.ItemDTO;
import com.example.crud.Entity.Item;
import com.example.crud.repository.ItemRepository;
import com.example.crud.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    @Override
    public List<Item> listar(){
        return repository.findAll();
    }

    @Override
    public Item buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

    @Override
    public Item criar(ItemDTO item) {
        Item novo = new Item();
        novo.setNome(item.getNome());
        novo.setDescricao(item.getDescricao());
        return repository.save(novo);
    }

    @Override
    public Item atualizar(Long id, ItemDTO novoItem) {
        Item velhoItem = buscarPorId(id);

        velhoItem.setNome(novoItem.getNome());
        velhoItem.setDescricao(novoItem.getDescricao());

        return repository.save(velhoItem);
    }

    @Override
    public void deletarById(Long id) {
        repository.deleteById(id);
    }
}
