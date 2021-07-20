package com.superbrain.configuration;

import javax.persistence.EntityManager;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class Querydsl {

	private final EntityManager em;

	public Querydsl(EntityManager em) {
		this.em = em;
	}

	@Bean
	public JPAQueryFactory jpaQueryFactory(){
		return new JPAQueryFactory(em);
	}
	
}
