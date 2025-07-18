package jjgg.springsecurity.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/auth")
public class AuthController {

    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @PostMapping("/post")
    public String post() {
        return "post";
    }

    @PutMapping("/put")
    public String put() {
        return "put";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "put";
    }

    @PatchMapping("/patch")
    public String patch() {
        return "patch";
    }
}
