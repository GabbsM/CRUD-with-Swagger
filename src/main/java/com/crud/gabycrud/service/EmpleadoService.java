package com.crud.gabycrud.service;

import com.crud.gabycrud.model.Empleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    private final List<Empleado> listaEmpleados = new ArrayList<>(); // Lista para logar la persistencia en memoria

    // Crear empleado:
    private int cont = 1;

    public Empleado crearEmpleado(Empleado empleado) {

        empleado.setId(cont++);
        listaEmpleados.add(empleado);
        return empleado;
    }

    // Buscar todos los empleados:
    public List<Empleado> getAll() {
        return listaEmpleados;
    }

    // Buscar un empleado por puesto de trabajo:

    public List<Empleado> buscarEmpleadoPorPuesto(String puesto) {

        List<Empleado> listaPorPuesto = new ArrayList<>();

        for (int i = 0; i < listaEmpleados.size(); i++) {

            Empleado current = listaEmpleados.get(i);
            if (current.getPuesto().equals(puesto)) {

                listaPorPuesto.add(current);
            }

        }
        return listaPorPuesto;

    }

    // Buscar un empleado por ID:
    public Empleado buscarEmpleado(int id) {

        for (int i = 0; i < listaEmpleados.size(); i++) {

            Empleado current = listaEmpleados.get(i);
            if (current.getId() == id) {
                return current;
            }
        }
        return null;
    }

    // Actualizar datos de un empleado por ID:
    public Empleado update(Empleado empleado) {
        for (int i = 0; i < listaEmpleados.size(); i++) {

            Empleado current = listaEmpleados.get(i);

            if (current.getId() == empleado.getId()) {
                current.setNombre(empleado.getNombre());
                current.setPuesto(empleado.getPuesto());

                return current;
            }

        }
        return null;

    }

    // Status:
    // Si la request es incorrecta: 400(Bad Request)
    //

    // Borrar un empleado por ID:
    public Empleado delete(int id) {
        for (int i = 0; i < listaEmpleados.size(); i++) {

            Empleado current = listaEmpleados.get(i);
            if (current.getId() == id) {
                listaEmpleados.remove(i);
                return current;
            }
        }
        return null;
    }
}
