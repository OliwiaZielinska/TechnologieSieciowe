package com.example.technologiesieciowelista1;

import org.springframework.web.bind.annotation.*;

@RestController     // Kontroler w aplikacji
@RequestMapping("/api")     // Wszystkie wywołania będą wymagały /api dobre do dzielenia

public class HelloController {
    // KOMUNIKACJA Z UŻYTKOWNIKIEM
    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello world!";
    }

    @GetMapping("/helloSomeone")
    public String helloSomeone(@RequestParam(required = false) String name, @RequestParam("param2") String surname){
        if(name==null){
            name = "John";
        }
        return "Hello " + name + " " + surname + " ! ";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + " ! ";
    }

    @GetMapping("/add")
    public int add(@RequestParam int liczba_a, @RequestParam int liczba_b){
        return liczba_a + liczba_b;
    }

    /* DODATKOWE KODY Z ZAJĘĆ
    @GetMapping("/helloSomeone3")
    public String helloSomeone3(@RequestParam String name){
        return "Hello " + name + "! ";
    }

    @GetMapping("/helloSomeone1")
    public String helloSomeone1(@RequestParam String name, @RequestParam String surname){
        return "Hello " + name + " " + surname + " ! ";
    }

    @GetMapping("/helloSomeone2")
    public String helloSomeone2(@RequestParam(required = false) String name, @RequestParam String surname){
        if(name==null){
            name = "John";
        }
        return "Hello " + name + " " + surname + " ! ";
    }*/
}
