package com.superbrain.mvc.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.superbrain.data.domain.universal.Organization;
import com.superbrain.data.domain.universal.QOrganization;
import com.superbrain.data.dto.OrganizationDTO;
import com.superbrain.mvc.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository public class OrganizationRepository extends BaseRepository {

    public OrganizationRepository(JPAQueryFactory query) {
        super(query);
    }

    QOrganization qOrganization = QOrganization.organization;

    public long update(Organization organization, OrganizationDTO.Update param) {

        JPAUpdateClause update = query.update(qOrganization).where(qOrganization.eq(organization));

        if (!organization.getName().equals(param.getName())){
            update.set(qOrganization.name, param.getName());
        }

        if (update.isEmpty()){
            return 0;
        }

        return update.execute();

    }

    public void remove(Organization organization){

        query.delete(qOrganization).where(qOrganization.eq(organization)).execute();

    }

    public Optional<Organization> getOrganization(String uuid) {

        Organization organization = query.selectFrom(qOrganization)
                .where(qOrganization.uuid.eq(uuid)).fetchFirst();

        return (organization != null) ? Optional.of(organization) : Optional.empty();

    }

    public Optional<OrganizationDTO.DetailResult> getOrganizationDetail(String uuid) {

        OrganizationDTO.DetailResult result = query.from(qOrganization)
                .select(Projections.constructor(OrganizationDTO.DetailResult.class,
                        qOrganization.uuid, qOrganization.name, qOrganization.role, qOrganization.etc, qOrganization.time_create, qOrganization.time_update))
                .where(qOrganization.uuid.eq(uuid)).fetchFirst();

        return (result != null) ? Optional.of(result) : Optional.empty();

    }

    public List<OrganizationDTO.Result> getOrganizations() {
        return query.from(qOrganization)
                .select(Projections.constructor(OrganizationDTO.Result.class,
                        qOrganization.uuid, qOrganization.name, qOrganization.role))
                .fetch();
    }
}
