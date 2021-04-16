/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Breyner Taborda
 */
@Entity
@Table(catalog = "dbzoologicos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Continentes.findAll", query = "SELECT c FROM Continentes c")
    , @NamedQuery(name = "Continentes.findByIdContinente", query = "SELECT c FROM Continentes c WHERE c.idContinente = :idContinente")
    , @NamedQuery(name = "Continentes.findByNombrecontinente", query = "SELECT c FROM Continentes c WHERE c.nombrecontinente = :nombrecontinente")})
public class Continentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONTINENTE", nullable = false)
    private Integer idContinente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String nombrecontinente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcontinentePais")
    private Collection<Pais> paisCollection;

    public Continentes() {
    }

    public Continentes(Integer idContinente) {
        this.idContinente = idContinente;
    }

    public Continentes(Integer idContinente, String nombrecontinente) {
        this.idContinente = idContinente;
        this.nombrecontinente = nombrecontinente;
    }

    public Integer getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(Integer idContinente) {
        this.idContinente = idContinente;
    }

    public String getNombrecontinente() {
        return nombrecontinente;
    }

    public void setNombrecontinente(String nombrecontinente) {
        this.nombrecontinente = nombrecontinente;
    }

    @XmlTransient
    public Collection<Pais> getPaisCollection() {
        return paisCollection;
    }

    public void setPaisCollection(Collection<Pais> paisCollection) {
        this.paisCollection = paisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContinente != null ? idContinente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Continentes)) {
            return false;
        }
        Continentes other = (Continentes) object;
        if ((this.idContinente == null && other.idContinente != null) || (this.idContinente != null && !this.idContinente.equals(other.idContinente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Continentes[ idContinente=" + idContinente + " ]";
    }
    
}
