package com.petshop.api.model;


public interface ProdutoContrato {
    interface View {
        void mostrarMensagem(String mensagem);
        void limparCampos();
    }

    interface Presenter {
        void salvarProduto(String nome, Double preco);
    }
}