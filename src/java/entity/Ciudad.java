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
@Table(catalog = "dbzoologicos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad")
    , @NamedQuery(name = "Ciudad.findByNombreCuidad", query = "SELECT c FROM Ciudad c WHERE c.nombreCuidad = :nombreCuidad")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CIUDAD", nullable = false)
    private Integer idCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBRE_CUIDAD", nullable = false, length = 150)
    private String nombreCuidad;
    @JoinColumn(name = "IDPAIS_CIUDAD", referencedColumnName = "ID_PAIS", nullable = false)
    @ManyToOne(optional = false)
    private Pais idpaisCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadZoo")
    private Collection<Zoologicos> zoologicosCollection;

    public Ciudad() {
    }

    public Ciudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad(Integer idCiudad, String nombreCuidad) {
        this.idCiudad = idCiudad;
        this.nombreCuidad = nombreCuidad;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCuidad() {
        return nombreCuidad;
    }

    public void setNombreCuidad(String nombreCuidad) {
        this.nombreCuidad = nombreCuidad;
    }

    public Pais getIdpaisCiudad() {
        return idpaisCiudad;
    }

    public void setIdpaisCiudad(Pais idpaisCiudad) {
        this.idpaisCiudad = idpaisCiudad;
    }

    @XmlTransient
    public Collection<Zoologicos> getZoologicosCollection() {
        return zoologicosCollection;
    }

    public void setZoologicosCollection(Collection<Zoologicos> zoologicosCollection) {
        this.zoologicosCollection = zoologicosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ciudad[ idCiudad=" + idCiudad + " ]";
    }
    
}
