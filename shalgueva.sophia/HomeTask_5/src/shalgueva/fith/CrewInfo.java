package shalgueva.fith;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CrewInfo {
	String shipCaptain() default "Jack Sparrow";
}
