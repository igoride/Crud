package com.example.crud.produto;

import com.example.crud.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    @Override
    public Page<Item> listar(Pageable pageable){
        return repository.findAll(pageable);
    }

    @Override
    public Item buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Item não encontrado com id:" + id));
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
