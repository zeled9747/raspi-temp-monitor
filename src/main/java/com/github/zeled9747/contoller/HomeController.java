package com.github.zeled9747.contoller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import reactor.core.publisher.Flux;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@ResponseBody
	@GetMapping(path = "/temperature", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> streamTemperature() {
		return Flux.interval(Duration.ofSeconds(1)).map(sequence -> randomTemperature());
	}

	private String randomTemperature() {
		return String.valueOf(Math.round((Math.random() * 100)));
	}

}
