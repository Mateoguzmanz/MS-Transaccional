package com.example.bibliotecaCatalogo.controller;
import com.example.bibliotecaCatalogo.clases.Libro;
import com.example.bibliotecaCatalogo.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@Tag(name = "Libro Controller", description = "Operaciones relacionadas con libros")
public class LibroController {
    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/actuator/health")
    public String health(){
        return "OK";
    }

    @GetMapping("/actuator/metrics")
    public String metrics() {
        return "Metricas";
    }

    @GetMapping("/actuator/info")
    public String info() {
        return "Info";
    }


    @PostMapping("/")
    public Libro saveLibro(Long id){
        return libroService.getLibroById(id);
    }

    @GetMapping
    @Operation(summary = "Buscar todos los Libros", description = "Permite obtener Libros de todos los Prestamos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Libros creados en el sistema",
                    content = @Content(schema = @Schema(implementation = Libro.class)))
    })
    public ResponseEntity<List<Libro>> getAll(){
        List<Libro> libros = libroService.getAllLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar Libro por Id", description = "Permite consultar un Libro por id")
    @Parameter(name = "Id", description = "Id del Libro a buscar")
    @ApiResponse(responseCode = "200", description = "Libro Encontrado")
    public ResponseEntity<Libro> getById(@PathVariable Long id){
        Optional<Libro> libro = Optional.ofNullable(libroService.getLibroById(id));
        return libro.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @Operation(summary = "CrearLibro", description ="Permite Crear un Libro")
    @Parameter(name = "Libro", description = "Lirbo a crear", content = @Content(schema = @Schema(implementation = Libro.class)))
    @ApiResponse(responseCode = "200", description = "Librp Creado")
    public ResponseEntity<Libro> create(@RequestBody Libro libro) {
        libroService.saveLibro(libro);
        return new ResponseEntity<>(libro, HttpStatus.CREATED);
    }



   @PutMapping("/{id}")
   @Operation(summary = "Actualizar un Libro", description = "Permite actualizar un Libro existente")
   @Parameter(name = "Libro", description = "Libro a actualizar", content = @Content(schema = @Schema(implementation = Libro.class)))
   @ApiResponse(responseCode = "200", description = "Libro actualizado",
           content = @Content(schema = @Schema(implementation = Libro.class)))
    public ResponseEntity<Libro> update(@PathVariable Long id, @RequestBody Libro libro ){
        Optional<Libro> existingLibro = Optional.ofNullable(libroService.getLibroById(id));
        if (existingLibro.isPresent()) {
            libro.setId(existingLibro.get().getId());
            libroService.saveLibro(libro);
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Operation(summary = "Borrar un Libro por Id", description = "Permite borrar un Libro, dado un Id")
    @Parameter(name = "Id", description = "Id del Libro a borrar")
    @ApiResponse(responseCode = "204", description = "Libro eliminado")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
