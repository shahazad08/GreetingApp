package com.GreetingApp.GreetingApp.Service;

import com.GreetingApp.GreetingApp.dto.Greeting;
import com.GreetingApp.GreetingApp.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IGreetingService {
    Greeting greetingMessage();

    ResponseEntity<User> greetingMessageWithRepo(@RequestBody User user);

    User getById(@PathVariable Long id);


}
