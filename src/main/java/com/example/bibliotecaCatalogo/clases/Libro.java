package com.example.bibliotecaCatalogo.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "Biblioteca")
@Schema(description = "Biblioteca")
public class Libro {
    @Id
    @Schema(description = "Id unico del libro, usualmente una identificacion con tipo", example = "C65437374")
    private Long id;
    @Schema(description = "Titulo del libro", example = "Viaje al centro de la tierra")
    private String titulo;
    @Schema(description = "Autor del libro", example = "Gabriel Garcia Marquez")
    private String autor;
    @Schema(description = "ISBN del libro", example = "978-3-16-148410-0")
    private String isbn;
    @Schema(description = "Paginas del libro", example = "256")
    private int paginas;

    public Libro(Long id, String titulo, String autor, String isbn, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}


