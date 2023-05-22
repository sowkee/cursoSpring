package com.cursojva.cursoSpring.controllers;

import com.cursojva.cursoSpring.dto.VehiculoDto;
import com.cursojva.cursoSpring.negocio.VehiculoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/vehiculos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VehiculoController {
    @Autowired
    private VehiculoNegocio vehiculoNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> mostrarVehiculos() {
        Map<String, Object> res = new HashMap<>();
        List<VehiculoDto> listVehiculoDto = this.vehiculoNegocio.encontrarTodos();
        res.put("status", HttpStatus.CREATED);
        res.put("data", listVehiculoDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearVehiculo(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<String, Object>();

        System.out.println("@@@@@"+request.toString());
        VehiculoDto vehiculoDto = new VehiculoDto();

        vehiculoDto.setIdVehiculos(0);
        vehiculoDto.setKilometraje(Integer.parseInt(request.get("kilometraje").toString()));
        vehiculoDto.setMatricula(request.get("matricula").toString());
        vehiculoDto.setMarca(request.get("marca").toString());
        vehiculoDto.setModelo(request.get("modelo").toString());
        vehiculoDto.setColor(request.get("color").toString());
        vehiculoDto.setPrecio(Integer.parseInt(request.get("precio").toString()));

        String respuesta = this.vehiculoNegocio.guardarVehiculo(vehiculoDto);

        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);


        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarVehiculos(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<String, Object>();
        VehiculoDto vehiculoDto = new VehiculoDto();
        vehiculoDto.setIdVehiculos(Integer.parseInt(request.get("id").toString()));
        vehiculoDto.setKilometraje(Integer.parseInt(request.get("kilometraje").toString()));
        vehiculoDto.setMatricula(request.get("matricula").toString());
        vehiculoDto.setMarca(request.get("marca").toString());
        vehiculoDto.setModelo(request.get("modelo").toString());
        vehiculoDto.setColor(request.get("color").toString());
        vehiculoDto.setPrecio(Integer.parseInt(request.get("precio").toString()));

        String respuesta = this.vehiculoNegocio.guardarVehiculo(vehiculoDto);

        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);


        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> eliminarVehiculo (@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();

        String respuesta = this.vehiculoNegocio.eliminar(id);

        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
