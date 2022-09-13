package br.com.fiap.vacinacard.model

class Usuario {

    constructor(email: String?, password: String?, nome: String?) {
        this.email = email
        this.senha = password
        this.nome = nome
    }

    var email: String? = null
    var senha: String? = null
    var nome: String? = null

}
