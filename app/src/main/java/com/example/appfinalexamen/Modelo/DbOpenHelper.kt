package com.example.appfinalexamen.Modelo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val nombreDB = "pedidospastes.db"
val versionDB = 1

class DbOpenHelper(context: Context):
    SQLiteOpenHelper(context, nombreDB,null,versionDB){
    override fun onCreate(db: SQLiteDatabase?){
        db!!.execSQL("""
                create table tblUsuarios(
                    NombreUsuario text not null,
                    CorreoElectronico text not null,
                    Password text not null,
                    Edificio text not null,
                    Image text
                );
                create table tblPastes(
                    idPaste integer primary key autoincrement,
                    NombrePaste text not null,
                    DescripcionPaste text not null,
                    PrecioPaste double not null,
                    img BLOB not null
                );
                create table tblPedidos(
                    idPedidos integer primary key autoincrement,
                    idPastePedido integer not null,
                    cantidadPastes integer not null,
                    idUsuarioCliente integer,
                    isCompleted bool,
                    foreign key(idPastePedido) referemces tblPastes(idPaste),
                    foreign key(idUsuarioCliente) references tblUsuarios(idUsuario)
                );
                
                insert into table tblUsuario values ('Andrea','a','b','I','');
            """.trimIndent())
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

}