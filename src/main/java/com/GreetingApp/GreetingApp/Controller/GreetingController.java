package com.GreetingApp.GreetingApp.Controller;

import com.GreetingApp.GreetingApp.Service.GreetingService;
import com.GreetingApp.GreetingApp.Service.IGreetingService;
import com.GreetingApp.GreetingApp.dto.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {


        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        @GetMapping(value = { "/greeting", "/greeting/", "/greeting/home" })
        public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }

        @GetMapping("greeting/{name}")
        public Greeting greetings(@PathVariable String name) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }

@Autowired
    IGreetingService greetingService;


        @GetMapping("greeting/service")
    public Greeting greeting() {
            return greetingService.greetingMessage();
        }
    }

