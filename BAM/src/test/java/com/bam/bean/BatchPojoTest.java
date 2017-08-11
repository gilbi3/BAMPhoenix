package com.bam.bean;
import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.bam.bean.Batch;

/**
 * 
 * @author Ramses Testing the Batch Pojo's setter and getters, no-args
 *         constructor and toString method using JUnit.
 *
 */
public class BatchPojoTest {
	// Individual, well named tests

	@Test
	public void shouldHaveANoArgsConstructor() {
		assertThat(Batch.class, hasValidBeanConstructor());
	}

	@Test
	public void gettersAndSettersShouldWorkForEachProperty() {
		assertThat(Batch.class, hasValidGettersAndSetters());
	}

	@Test
	public void allPropertiesShouldBeRepresentedInToStringOutput() {
		assertThat(Batch.class, hasValidBeanToString());
	}

}