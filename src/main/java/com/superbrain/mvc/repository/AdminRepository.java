package com.superbrain.mvc.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.superbrain.data.domain.part.admin.Admin;
import com.superbrain.data.domain.part.admin.AdminAccount;
import com.superbrain.data.domain.part.admin.QAdmin;
import com.superbrain.data.domain.base.embeded.Password;
import com.superbrain.data.domain.part.admin.QAdminAccount;
import com.superbrain.data.dto.AdminDTO;
import com.superbrain.mvc.repository.base.BaseRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository public class AdminRepository extends BaseRepository {

    QAdmin qAdmin = QAdmin.admin;
    QAdminAccount qAdminAccount = QAdminAccount.adminAccount;

    public AdminRepository(JPAQueryFactory query) {
        super(query);
    }

    public Optional<Admin> getAdmin(String uuid) {

        Admin admin = query.selectFrom(qAdmin).where(qAdmin.uuid.eq(uuid)).fetchFirst();

        return (admin != null) ? Optional.of(admin) : Optional.empty();

    }

    public Optional<AdminAccount> getAdminAccount(String uuid) {

        AdminAccount account = query.selectFrom(qAdminAccount).where(qAdminAccount.admin.uuid.eq(uuid)).join(qAdminAccount.admin, qAdmin).fetchJoin().fetchFirst();

        return (account != null) ? Optional.of(account) : Optional.empty();

    }

    public Optional<AdminAccount> getAdminById(String id) {

        AdminAccount account = query.selectFrom(qAdminAccount).where(qAdminAccount.id.eq(id)).join(qAdminAccount.admin, qAdmin).fetchJoin().fetchFirst();

        return (account != null) ? Optional.of(account) : Optional.empty();

    }

    public long update(AdminAccount account, AdminDTO.Update param) {

        JPAUpdateClause update = query.update(qAdminAccount).where(qAdminAccount.eq(account));

        if(!account.getPassword().match(param.getPassword())){
            update.set(qAdminAccount.password, new Password(param.getPassword(), RandomStringUtils.randomAlphanumeric(12)));
        }

        if(update.isEmpty()) return 0;

        return update.execute();

    }

    public Optional<AdminDTO.ResultDetail> getAdminDetail(String uuid) {

        AdminDTO.ResultDetail result = query.from(qAdmin)
                .select(Projections.constructor(AdminDTO.ResultDetail.class,
                        qAdmin.uuid, qAdmin.account.id, qAdmin.organization, qAdmin.time_create, qAdmin.time_update))
                .where(qAdmin.uuid.eq(uuid))
                .fetchFirst();

       return (result != null) ? Optional.of(result) : Optional.empty();

    }

    public List<AdminDTO.Result> getAdminList() {

        return query.from(qAdmin)
                .select(Projections.constructor(AdminDTO.Result.class,
                        qAdmin.uuid, qAdmin.account.id, qAdmin.organization))
                .fetch();

    }

    public long updateToken(AdminAccount account, String refresh) {

        JPAUpdateClause update = query.update(qAdminAccount).where(qAdminAccount.eq(account));

        update.set(qAdminAccount.refresh, refresh);

        return update.execute();

    }
}
