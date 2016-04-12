package se.martin.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author M
 *
 */
public class Main {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.martin.jpa.config");
			context.refresh();
		}
	}
}
