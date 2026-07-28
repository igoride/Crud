package com.example.crud.controller;

import com.example.crud.dto.ItemDTO;
import com.example.crud.entity.Item;
import com.example.crud.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping("/all")
    public Page<Item> listar(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size,
                             @RequestParam(defaultValue = "id") String sortBy,
                             @RequestParam(defaultValue = "asc") String direction) {
        Sort.Direction sortDir = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDir, sortBy));
        return service.listar(pageable);
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
