package api.pixelPulse.pixelPulse.controller;

import api.pixelPulse.pixelPulse.DTOS.DTOLogin;
import api.pixelPulse.pixelPulse.DTOS.DTOUser;
import api.pixelPulse.pixelPulse.entities.Database;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// endpoint
@RequestMapping("/users")
@RestController()
public class UserController {

    //HTTP METHOD


    @GetMapping("/")
    public String hello() {
        return "online!";
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody DTOLogin loginData) throws Exception {

        try{
            Database db = new Database();
            DTOUser user = db.getUser(loginData.email(), loginData.password());
            return ResponseEntity.status(200).body(user);

        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(404).body("Não conseguimos encontrar esse usuário");
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody DTOUser users) {
        try {
            Database db = new Database();
            db.Register(users);
            return ResponseEntity.status(201).body("Usuario criado.");

        } catch (Exception e) {

            return ResponseEntity.status(500).body("Ocorreu um erro.");
        }

    }
}
