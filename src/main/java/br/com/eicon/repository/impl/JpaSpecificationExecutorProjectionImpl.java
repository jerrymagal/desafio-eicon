package br.com.eicon.repository.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import br.com.eicon.repository.JpaSpecificationExecutorProjection;

public final class JpaSpecificationExecutorProjectionImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements JpaSpecificationExecutorProjection<T> {

	private ProjectionFactory projectionFactory;
	
	
	public JpaSpecificationExecutorProjectionImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.projectionFactory = new SpelAwareProxyProjectionFactory();
	}

	@Override
	public <PROJECTION> Page<PROJECTION> findAll(Specification<T> spec, Class<PROJECTION> projectionClass, Pageable pageable) {
		TypedQuery<T> query = getQuery(spec, pageable);
		return readProjectionPage(spec, projectionClass, pageable, query);
	}
	
	private <PROJECTION> Page<PROJECTION> readProjectionPage(Specification<T> spec, Class<PROJECTION> projectionType, Pageable pageable, TypedQuery<T> query) {
		Page<T> result = (pageable == null) ? new PageImpl<>(query.getResultList()) : readPage(query, getDomainClass(), pageable, spec);
		return result.map(item -> projectionFactory.createProjection(projectionType, item));
	}
}
