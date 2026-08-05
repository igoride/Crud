package com.example.crud.cliente.specification;

import com.example.crud.cliente.dto.ClienteFilterDTO;
import com.example.crud.cliente.entity.Cliente;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ClienteSpecification {

    public static Specification<Cliente> filter(ClienteFilterDTO filtro) {
        List<Specification<Cliente>> specs = new ArrayList<>();

        Specification<Cliente> nome = nome(filtro.nome());
        Specification<Cliente> cpf = cpf(filtro.cpf());
        Specification<Cliente> ativo = ativo(filtro.ativo());
        Specification<Cliente> email = email(filtro.email());

        if (nome != null) specs.add(nome);
        if (cpf != null) specs.add(cpf);
        specs.add(ativo);
        if (email != null) specs.add(email);

        return Specification.allOf(specs);
    }

    public static Specification<Cliente> nome(String nome) {
        if (nome == null || nome.isBlank()) {
            return null;
        }
        return (root, query, cb) ->
                cb.like(
                        cb.lower(root.get("nome")),
                        "%" + nome.toLowerCase() + "%"
                );
    }

    public static Specification<Cliente> email(String email) {
        if (email == null || email.isBlank()) {
            return null;
        }

        return (root, query, cb) ->
                cb.like(
                        cb.lower(root.get("email")),
                        "%" + email.toLowerCase() + "%"
                );
    }

    public static Specification<Cliente> cpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            return null;
        }

        return (root, query, cb) ->
                cb.equal(root.get("cpf"), cpf);
    }

    public static Specification<Cliente> ativo(Boolean ativo) {
        return (root, query, cb) ->
                cb.equal(root.get("ativo"), ativo);
    }

}
