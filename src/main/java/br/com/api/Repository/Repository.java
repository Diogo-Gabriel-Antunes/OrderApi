package br.com.api.Repository;


import br.com.api.Infra.SessionManager;
import jakarta.persistence.EntityManager;
import org.acme.SQL.SQLCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Repository {

    @Autowired
    protected EntityManager em;

    public SQLCreator criaSql(String entity, String clausula){
        SQLCreator sql = new SQLCreator();
        sql.consultaNativa(false);
        sql.setEm(em);
        sql.select(clausula,entity)
        .from(entity + " " + clausula);

//        sql.where(clausula + ".userUuid = :user")
//                .param("user", SessionManager.user.get().getUuid());
        return sql;
    }

}
