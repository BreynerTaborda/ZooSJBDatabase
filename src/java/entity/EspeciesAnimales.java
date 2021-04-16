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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "especies_animales", catalog = "dbzoologicos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspeciesAnimales.findAll", query = "SELECT e FROM EspeciesAnimales e")
    , @NamedQuery(name = "EspeciesAnimales.findByIdEspecies", query = "SELECT e FROM EspeciesAnimales e WHERE e.idEspecies = :idEspecies")
    , @NamedQuery(name = "EspeciesAnimales.findByNombreComun", query = "SELECT e FROM EspeciesAnimales e WHERE e.nombreComun = :nombreComun")
    , @NamedQuery(name = "EspeciesAnimales.findByNombreCientifico", query = "SELECT e FROM EspeciesAnimales e WHERE e.nombreCientifico = :nombreCientifico")
    , @NamedQuery(name = "EspeciesAnimales.findByPeligroExtincion", query = "SELECT e FROM EspeciesAnimales e WHERE e.peligroExtincion = :peligroExtincion")})
public class EspeciesAnimales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESPECIES", nullable = false)
    private Integer idEspecies;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_COMUN", nullable = false, length = 100)
    private String nombreComun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE_CIENTIFICO", nullable = false, length = 200)
    private String nombreCientifico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PELIGRO_EXTINCION", nullable = false)
    private boolean peligroExtincion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especieAnimal")
    private Collection<Animales> animalesCollection;
    @JoinColumn(name = "FAMILIA_ESPECIE", referencedColumnName = "ID_FAMILIAS", nullable = false)
    @ManyToOne(optional = false)
    private FamiliasAnimales familiaEspecie;

    public EspeciesAnimales() {
    }

    public EspeciesAnimales(Integer idEspecies) {
        this.idEspecies = idEspecies;
    }

    public EspeciesAnimales(Integer idEspecies, String nombreComun, String nombreCientifico, boolean peligroExtincion) {
        this.idEspecies = idEspecies;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.peligroExtincion = peligroExtincion;
    }

    public Integer getIdEspecies() {
        return idEspecies;
    }

    public void setIdEspecies(Integer idEspecies) {
        this.idEspecies = idEspecies;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public boolean getPeligroExtincion() {
        return peligroExtincion;
    }

    public void setPeligroExtincion(boolean peligroExtincion) {
        this.peligroExtincion = peligroExtincion;
    }

    @XmlTransient
    public Collection<Animales> getAnimalesCollection() {
        return animalesCollection;
    }

    public void setAnimalesCollection(Collection<Animales> animalesCollection) {
        this.animalesCollection = animalesCollection;
    }

    public FamiliasAnimales getFamiliaEspecie() {
        return familiaEspecie;
    }

    public void setFamiliaEspecie(FamiliasAnimales familiaEspecie) {
        this.familiaEspecie = familiaEspecie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecies != null ? idEspecies.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspeciesAnimales)) {
            return false;
        }
        EspeciesAnimales other = (EspeciesAnimales) object;
        if ((this.idEspecies == null && other.idEspecies != null) || (this.idEspecies != null && !this.idEspecies.equals(other.idEspecies))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EspeciesAnimales[ idEspecies=" + idEspecies + " ]";
    }
    
}
