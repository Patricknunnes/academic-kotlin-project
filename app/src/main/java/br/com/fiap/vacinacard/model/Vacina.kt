package br.com.fiap.vacinacard.model

class Vacina{
    constructor(nome: String?, anoDose: String?, anoVencimento: String?) {
        this.nome = nome
        this.anoDose = anoDose
        this.anoVencimento = anoVencimento
    }

    var nome: String? = null
    var anoDose: String? = null
    var anoVencimento: String? = null

}