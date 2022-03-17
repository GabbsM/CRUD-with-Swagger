package com.crud.gabycrud.controller;

import com.crud.gabycrud.model.Empleado;
import com.crud.gabycrud.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

    // SWAGGER-UI: http://localhost:8081/swagger-ui

    @Autowired // Detectamos que tiene definido un empleadoService. También se puede hacer con constructor
    private EmpleadoService empleadoService;


    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    // C CREAR = POST
    // R READ = GET
    // U UPDAT = PUT
    // D DELETE = DELETE

    @GetMapping("/getall")
    public List<Empleado> getAll() {
        return empleadoService.getAll();
    }

    @PostMapping("/create")

    public Empleado creaEmpledo(@RequestBody Empleado empleado) {
        return empleadoService.crearEmpleado(empleado);
    }

    @GetMapping("/read")
    public Empleado read(@RequestParam Empleado id) {
        return null;
    }

    @GetMapping("/puesto")
    public List<Empleado> puesto(@RequestParam String puesto) {
        return empleadoService.buscarEmpleadoPorPuesto(puesto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Empleado> borrar(@RequestParam int id) {

        Empleado borrado = empleadoService.delete(id);

        // Código de error:

        if (borrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(borrado);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Empleado> delete(@PathVariable int id) {

        Empleado borrado = empleadoService.delete(id);

        if (borrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(borrado);
    }

    @PutMapping("/update")
    public ResponseEntity<Empleado> update(@RequestBody Empleado empleado) {

        Empleado actualizado = empleadoService.update(empleado);

        if (actualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(actualizado);


    }


    // PUT: (/update/idUsuario) Body = Empleado con datos nuevos.
    // GET: (/get/RequestParam = id)
    // DELETE: (/delete/idUsuario)

    //** PATH VARIABLE */ IMPORTANTE


}