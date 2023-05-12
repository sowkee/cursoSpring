package com.cursojva.cursoSpring.controllers;

import com.cursojva.cursoSpring.dto.ConcesionarioDto;
import com.cursojva.cursoSpring.negocio.ConcesionarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/concesionarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class ConcesionarioController {

    @Autowired
    private ConcesionarioNegocio concesionarioNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> mostrarConcesionario(){
        Map<String, Object> res = new HashMap<>();
        List<ConcesionarioDto> listConcesionarioDto = this.concesionarioNegocio.encontrarTodos();
        res.put("status", HttpStatus.ACCEPTED);
        res.put("data", listConcesionarioDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearConcesionario(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<String, Object>();
        ConcesionarioDto concesionarioDto = new ConcesionarioDto();
        concesionarioDto.setIdConcesionario(0);
        concesionarioDto.setNombre(request.get("nombre").toString());
        concesionarioDto.setCorreo(request.get("correo").toString());
        concesionarioDto.setTelefono(request.get("telefono").toString());
        concesionarioDto.setDireccion(request.get("direccion").toString());

        String respuesta = this.concesionarioNegocio.guardarConcesionario(concesionarioDto);

        res.put("status", HttpStatus.ACCEPTED);
        res.put("data", respuesta);


        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarConcesionario(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<String, Object>();
        ConcesionarioDto concesionarioDto = new ConcesionarioDto();
        concesionarioDto.setIdConcesionario(Integer.parseInt(request.get("id").toString()));
        concesionarioDto.setNombre(request.get("nombre").toString());
        concesionarioDto.setCorreo(request.get("correo").toString());
        concesionarioDto.setTelefono(request.get("telefono").toString());
        concesionarioDto.setDireccion(request.get("direccion").toString());

        String respuesta = this.concesionarioNegocio.guardarConcesionario(concesionarioDto);

        res.put("status", HttpStatus.ACCEPTED);
        res.put("data", respuesta);


        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
