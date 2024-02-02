/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * Simple JavaBean domain object adds a name property to <code>BaseEntity</code>. Used as
 * a base class for objects needing these properties.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller TL:DR This class is the extension of BaseEntity and is used as
 * a base for Pet.java - this class provides a table variable name with its interactions
 * for example pets which by default should have an id and a name but may have some extra
 * attribute such as birth date ,animal type and exc.
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {

	/**
	 * Here @Column adds a normal non-primary key to the table with it's identifying name
	 * being "name" in the database
	 */
	@Column(name = "name")
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Override is used to change usual behaviour of java - toString usually transforms a
	// predefined variable into string
	@Override
	public String toString() {
		return this.getName();
	}

}
