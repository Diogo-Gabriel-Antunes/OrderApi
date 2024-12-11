package br.com.api.Services;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
public class Services {

    @Autowired
    protected EntityManager em;
}
