package com.example.crud;

import com.example.crud.produto.Item;
import com.example.crud.exception.NotFoundException;
import com.example.crud.produto.ItemRepository;
import com.example.crud.produto.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CrudApplicationTests {

	@Mock
	private ItemRepository repository;

	@InjectMocks
	private ItemServiceImpl service;

	@Test
	void retornaQuandoExistir() {
		Long idExiste = 1L;
		Item mockedItem = new Item();
		mockedItem.setId(idExiste);
		mockedItem.setNome("Mouse");
		mockedItem.setDescricao("Mouse 10000DPI");

		when(repository.findById(idExiste)).thenReturn(Optional.of(mockedItem));

		Item resultado = service.buscarPorId(idExiste);

		assertNotNull(resultado);
		assertEquals(idExiste, resultado.getId());
		assertEquals("Mouse", resultado.getNome());

		verify(repository, times(1)).findById(idExiste);
	}

	@Test
	void exceptionQuandoIdNaoExistir() {
		Long idInexistente = 99L;

		when(repository.findById(idInexistente)).thenReturn(Optional.empty());

		NotFoundException ex = assertThrows(NotFoundException.class, () -> {
			service.buscarPorId(idInexistente);
		});

		assertTrue(ex.getMessage().contains("não foi encontrado") || ex.getMessage().contains(idInexistente.toString()));

		verify(repository, times(1)).findById(idInexistente);
	}

}
