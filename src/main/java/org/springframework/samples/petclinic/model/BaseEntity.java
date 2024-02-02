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

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Simple JavaBean domain object with an id property. Used as a base class for objects
 * needing this property. TL:DR 1. This is the class that adds the id variable to all the
 * other tables and is also used in interactions with it 2. @MappedSuperClass is the
 * parent and the base for all other SuperClasses and @Entity -ies who implement it in
 * class 3.Example : public class Person extends BaseEntity {} means here that Person.java
 * imports BaseEntity.java , it's id attribute and interactions 4.Because BaseEntity
 * "implements Serializable" first , all the files that import it will get the
 * dependencies , there is no need to re-import the dependencies and for the variables and
 * functions , they will be referenced from the BaseEntity even if the file does not have
 * such variables/functions already 5.@Id Specifies what to use as a primary key (which in
 * the most cases is the id number) and
 *
 * @GeneratedValue automatically creates values for it
 * @author Ken Krebs
 * @author Juergen Hoeller
 *
 *
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// Get the id of the current item from the table
	public Integer getId() {
		return id;
	}

	// Set the id for the current item with provided number when called
	public void setId(Integer id) {
		this.id = id;
	}

	// check if the item with the selected id exists (is it a new item?)
	public boolean isNew() {
		return this.id == null;
	}

}
