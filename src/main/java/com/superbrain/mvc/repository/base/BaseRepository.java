package com.superbrain.mvc.repository.base;

import com.querydsl.jpa.impl.JPAQueryFactory;

public class BaseRepository {

    protected final JPAQueryFactory query;

    public BaseRepository(JPAQueryFactory query) {
        this.query = query;
    }

}
