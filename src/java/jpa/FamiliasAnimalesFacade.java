/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.FamiliasAnimales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Breyner Taborda
 */
@Stateless
public class FamiliasAnimalesFacade extends AbstractFacade<FamiliasAnimales> {

    @PersistenceContext(unitName = "ZooSJBDatabasePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FamiliasAnimalesFacade() {
        super(FamiliasAnimales.class);
    }
    
}
