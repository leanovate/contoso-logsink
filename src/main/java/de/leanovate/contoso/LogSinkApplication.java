package de.leanovate.contoso;

import static org.springframework.boot.SpringApplication.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

@SpringBootApplication
@EnableBinding(Sink.class)
public class LogSinkApplication {

	private int messageAmount = 0;

	public static void main(String[] args) {
		run(LogSinkApplication.class, args);
	}

	@ServiceActivator(inputChannel=Sink.INPUT)
	public void logMessage(String message) {
		System.out.println(++messageAmount + ": " + message);
	}
}
