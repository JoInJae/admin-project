package com.superbrain.mvc.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.superbrain.data.domain.part.user.QUser;
import com.superbrain.data.domain.part.user.QUserAccount;
import com.superbrain.data.dto.UserDTO;
import com.superbrain.mvc.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository public class UserRepository extends BaseRepository {

    QUser qUser = QUser.user;
    QUserAccount qUserAccount = QUserAccount.userAccount;

    public UserRepository(JPAQueryFactory query) {
        super(query);
    }

    public List<UserDTO.Result> getUserList() {

        return query.from(qUser)
                .select(Projections.constructor(UserDTO.Result.class,
                        qUser.uuid, qUser.account.id, qUser.name, qUser.gender, qUser.education, qUser.birth))
                .fetch();

    }

    public Optional<UserDTO.ResultDetail> getUserDetail(String uuid) {

        UserDTO.ResultDetail result = query.from(qUser)
                .select(Projections.constructor(UserDTO.ResultDetail.class,
                        qUser.uuid, qUser.account.id, qUser.name, qUser.gender, qUser.education, qUser.birth, qUser.height, qUser.time_create, qUser.time_update))
                .where(qUser.uuid.eq(uuid)).fetchFirst();

        return (result != null) ? Optional.of(result) : Optional.empty();

    }

}
