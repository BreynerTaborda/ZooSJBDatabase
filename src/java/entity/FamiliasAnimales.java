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
@Table(name = "familias_animales", catalog = "dbzoologicos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamiliasAnimales.findAll", query = "SELECT f FROM FamiliasAnimales f")
    , @NamedQuery(name = "FamiliasAnimales.findByIdFamilias", query = "SELECT f FROM FamiliasAnimales f WHERE f.idFamilias = :idFamilias")
    , @NamedQuery(name = "FamiliasAnimales.findByNombreFamilia", query = "SELECT f FROM FamiliasAnimales f WHERE f.nombreFamilia = :nombreFamilia")})
public class FamiliasAnimales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FAMILIAS", nullable = false)
    private Integer idFamilias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_FAMILIA", nullable = false, length = 30)
    private String nombreFamilia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familiaEspecie")
    private Collection<EspeciesAnimales> especiesAnimalesCollection;

    public FamiliasAnimales() {
    }

    public FamiliasAnimales(Integer idFamilias) {
        this.idFamilias = idFamilias;
    }

    public FamiliasAnimales(Integer idFamilias, String nombreFamilia) {
        this.idFamilias = idFamilias;
        this.nombreFamilia = nombreFamilia;
    }

    public Integer getIdFamilias() {
        return idFamilias;
    }

    public void setIdFamilias(Integer idFamilias) {
        this.idFamilias = idFamilias;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    @XmlTransient
    public Collection<EspeciesAnimales> getEspeciesAnimalesCollection() {
        return especiesAnimalesCollection;
    }

    public void setEspeciesAnimalesCollection(Collection<EspeciesAnimales> especiesAnimalesCollection) {
        this.especiesAnimalesCollection = especiesAnimalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamilias != null ? idFamilias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamiliasAnimales)) {
            return false;
        }
        FamiliasAnimales other = (FamiliasAnimales) object;
        if ((this.idFamilias == null && other.idFamilias != null) || (this.idFamilias != null && !this.idFamilias.equals(other.idFamilias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FamiliasAnimales[ idFamilias=" + idFamilias + " ]";
    }
    
}
