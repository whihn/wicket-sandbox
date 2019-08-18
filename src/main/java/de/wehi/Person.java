package de.wehi;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Person implements Serializable {

	private String name;
	private int age;
}
