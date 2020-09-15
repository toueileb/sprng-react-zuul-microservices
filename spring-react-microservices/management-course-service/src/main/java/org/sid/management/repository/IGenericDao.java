package org.sid.management.repository;

import org.sid.management.model.IModel;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericDao<T extends IModel> {

}
