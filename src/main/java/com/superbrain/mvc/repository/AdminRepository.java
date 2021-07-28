package com.superbrain.mvc.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.superbrain.data.domain.admin.Admin;
import com.superbrain.data.domain.admin.QAdmin;
import com.superbrain.data.domain.admin.QAdminInfo;
import com.superbrain.data.domain.base.embeded.Password;
import com.superbrain.data.dto.AdminDTO;
import com.superbrain.mvc.repository.base.BaseRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository public class AdminRepository extends BaseRepository {

    QAdmin qAdmin = QAdmin.admin;
    QAdminInfo qAdminInfo = QAdminInfo.adminInfo;

    public AdminRepository(JPAQueryFactory query) {
        super(query);
    }

    public Optional<Admin> getAdminByUuid(String uuid) {

        Admin admin = query.selectFrom(qAdmin).where(qAdmin.uuid.eq(uuid)).join(qAdmin.admin_info, qAdminInfo).fetchJoin().fetchFirst();

        return (admin != null) ? Optional.of(admin) : Optional.empty();

    }

    public Optional<Admin> getAdminById(String id) {

        Admin admin = query.selectFrom(qAdmin).where(qAdmin.id.eq(id)).join(qAdmin.admin_info, qAdminInfo).fetchJoin().fetchFirst();

        return (admin != null) ? Optional.of(admin) : Optional.empty();

    }

    public long update(Admin admin, AdminDTO.Update param) {

        JPAUpdateClause update = query.update(qAdmin).where(qAdmin.eq(admin));

        if(!admin.getPassword().match(param.getPassword())){
            update.set(qAdmin.password, new Password(param.getPassword(), RandomStringUtils.randomAlphanumeric(12)));
        }

        if(update.isEmpty()) return 0;

        return update.execute();

    }

    public Optional<AdminDTO.ResultDetail> getAdminDetail(String uuid) {

        AdminDTO.ResultDetail result = query.from(qAdminInfo)
                .select(Projections.constructor(AdminDTO.ResultDetail.class,
                        qAdminInfo.admin.uuid, qAdminInfo.admin.id, qAdminInfo.organization, qAdminInfo.time_create, qAdminInfo.time_update))
                .where(qAdminInfo.admin.uuid.eq(uuid))
                .fetchFirst();

       return (result != null) ? Optional.of(result) : Optional.empty();

    }

    public List<AdminDTO.Result> getAdmins() {

        return query.from(qAdminInfo)
                .select(Projections.constructor(AdminDTO.Result.class,
                        qAdminInfo.admin.uuid, qAdminInfo.admin.id, qAdminInfo.organization))
                .fetch();

    }

    public long updateToken(Admin admin, String refresh) {

        JPAUpdateClause update = query.update(qAdmin).where(qAdmin.eq(admin));

        update.set(qAdmin.refresh, refresh);

        return update.execute();

    }
}
