package br.com.fiap.vacinacard.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import br.com.fiap.vacinacard.model.Usuario
import br.com.fiap.vacinacard.model.Vacina

class DataBaseManager(context: Context, name: String) : SQLiteOpenHelper(context, name, null, 2) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable = "CREATE TABLE tbl_usuario (" +
                "email VARCHAR(50) NOT NULL, " +
                "senha VARCHAR(16) NOT NULL, " +
                "nome VARCHAR(50), " +
                "PRIMARY KEY (email));"

        p0!!.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS tbl_usuario")
        onCreate(p0)
    }

    fun insertUser (email: String, senha: String, nome: String) {
        val p0 = this.writableDatabase

        var cv = ContentValues()
        cv.put("email", email)
        cv.put("senha", senha)
        cv.put("nome", nome)

        p0.insert("tbl_usuario", "email", cv)
    }

    fun deleteUser (email: String) {
        val p0 = this.writableDatabase
        p0.delete("tbl_usuario", "email = $email", null)
    }

    @SuppressLint("Range")
    fun findUserById (email: String) : Usuario? {
        val p0 = this.writableDatabase
        p0.rawQuery("SELECT * FROM tbl_usuario WHERE email = ?", arrayOf(email)).use {
            if (it.moveToFirst()){
                var result = Usuario(it.getString(it.getColumnIndex("email")),
                    it.getString(it.getColumnIndex("senha")), it.getString(it.getColumnIndex("nome")))
                return result
            }
        }
        return null
    }

}