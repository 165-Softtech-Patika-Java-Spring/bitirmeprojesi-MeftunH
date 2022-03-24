package com.FinalProject.FinalProject.general.validator;

import javax.persistence.EntityManager;

public interface EntityManagerAwareValidator {
    void setEntityManager(EntityManager entityManager);
}
