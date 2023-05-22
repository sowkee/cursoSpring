package com.cursojva.cursoSpring.controllers;

import com.cursojva.cursoSpring.dto.UsuarioDto;
import com.cursojva.cursoSpring.dto.VehiculoDto;
import com.cursojva.cursoSpring.dto.VentaDto;
import com.cursojva.cursoSpring.negocio.VentaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/ventas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class VentaController {
    @Autowired
    private VentaNegocio ventaNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> mostrarVentas() {
        Map<String, Object> res = new HashMap<>();
        List<VentaDto> listVentaDto = this.ventaNegocio.encontrarTodos();
        res.put("status", HttpStatus.CREATED);
        res.put("data", listVentaDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearVenta(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<String, Object>();

        System.out.println("@@@@@"+request.toString());
        VentaDto ventaDto = new VentaDto();

        ventaDto.setIdVenta(0);
        ventaDto.setFechaVenta(new Date());
        ventaDto.setPrecioFinal(Integer.parseInt(request.get("precioFinal").toString()));
        ventaDto.setObservaciones(request.get("observaciones").toString());

        String respuesta = this.ventaNegocio.guardarVenta(ventaDto);

        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);


        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarUsuario(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<String, Object>();

        VentaDto ventaDto = new VentaDto();
        ventaDto.setIdVenta(Integer.parseInt(request.get("idVenta").toString()));
        ventaDto.setFechaVenta(new Date());
        ventaDto.setPrecioFinal(Integer.parseInt(request.get("precioFinal").toString()));
        ventaDto.setObservaciones(request.get("observaciones").toString());

        String respuesta = this.ventaNegocio.guardarVenta(ventaDto);

        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);


        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> eliminarVenta (@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();

        String respuesta = this.ventaNegocio.eliminar(id);

        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
