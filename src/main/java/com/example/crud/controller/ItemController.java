package com.example.crud.controller;

import com.example.crud.dto.ItemDTO;
import com.example.crud.Entity.Item;
import com.example.crud.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping("/all")
    public List<Item> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Item buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Item criar(@RequestBody @Valid ItemDTO item) {
        return service.criar(item);
    }

    @PutMapping("/{id}")
    public Item atualizar(@PathVariable Long id, @Valid @RequestBody ItemDTO novoItem) {
        return service.atualizar(id, novoItem);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarById(id);
    }
}
