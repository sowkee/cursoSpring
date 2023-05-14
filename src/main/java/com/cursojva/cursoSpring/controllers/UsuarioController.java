package com.cursojva.cursoSpring.controllers;


import com.cursojva.cursoSpring.dto.UsuarioDto;
import com.cursojva.cursoSpring.negocio.UsuarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping(path = "/usuarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {

    @Autowired
    private UsuarioNegocio usuarioNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> mostrarUsuarios() {
        Map<String, Object> res = new HashMap<>();
        List<UsuarioDto> listUsuarioDto = this.usuarioNegocio.encontrarTodos();
        res.put("status", HttpStatus.ACCEPTED);
        res.put("data", listUsuarioDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearUsuario(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<String, Object>();

        System.out.println("@@@@@"+request.toString());
        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setIdUsuario(0);
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setIdentificacion(Integer.parseInt(request.get("identificacion").toString()));
        usuarioDto.setFechaNacimiento(new Date());
        usuarioDto.setFechaIngreso(new Date());
        usuarioDto.setTelefono(request.get("telefono").toString());
        usuarioDto.setDireccion(request.get("direccion").toString());


        String respuesta = this.usuarioNegocio.guardarUsuario(usuarioDto);

        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);


        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarUsuario(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<String, Object>();
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(Integer.parseInt(request.get("id").toString()));
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setIdentificacion(Integer.parseInt(request.get("identificacion").toString()));
        usuarioDto.setFechaNacimiento(new Date());
        usuarioDto.setFechaIngreso(new Date());
        usuarioDto.setTelefono(request.get("telefono").toString());
        usuarioDto.setDireccion(request.get("direccion").toString());
        usuarioDto.setPassword(request.get("password").toString());

        String respuesta = this.usuarioNegocio.guardarUsuario(usuarioDto);

        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);


        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> eliminarUsuario(@PathVariable int id){
        Map<String, Object> res = new HashMap<>();
        String respuesta = this.usuarioNegocio.eliminar(id);

        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);

        return new ResponseEntity<>(res, HttpStatus.OK);

    }

}
    /*@Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader (value = "Authorization") String token){

        if(!validarToken(token)) {
            return null;
        }

        return usuarioDAO.getUsuario();
    }

    public boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDAO.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader (value = "Authorization") String token,
                         @PathVariable Long id){
        if(!validarToken(token)) {
            return;
        }
        usuarioDAO.eliminar(id);

    }

     */


