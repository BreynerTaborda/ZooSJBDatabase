/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Zoologicos.findAll", query = "SELECT z FROM Zoologicos z")
    , @NamedQuery(name = "Zoologicos.findByIdZoo", query = "SELECT z FROM Zoologicos z WHERE z.idZoo = :idZoo")
    , @NamedQuery(name = "Zoologicos.findByNombreZoo", query = "SELECT z FROM Zoologicos z WHERE z.nombreZoo = :nombreZoo")
    , @NamedQuery(name = "Zoologicos.findByTama\u00e3O", query = "SELECT z FROM Zoologicos z WHERE z.tama\u00e3O = :tama\u00e3O")
    , @NamedQuery(name = "Zoologicos.findByPresupuesto", query = "SELECT z FROM Zoologicos z WHERE z.presupuesto = :presupuesto")})
public class Zoologicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ZOO", nullable = false)
    private Integer idZoo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_ZOO", nullable = false, length = 100)
    private String nombreZoo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAMA\u00c3\u2018O", nullable = false)
    private int tamaãO;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private float presupuesto;
    @JoinTable(name = "zoo_animales", joinColumns = {
        @JoinColumn(name = "ID_ZOO_ZA", referencedColumnName = "ID_ZOO", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ANIMAL_ZA", referencedColumnName = "ID_ANIMAL", nullable = false)})
    @ManyToMany
    private Collection<Animales> animalesCollection;
    @JoinColumn(name = "CIUDAD_ZOO", referencedColumnName = "ID_CIUDAD", nullable = false)
    @ManyToOne(optional = false)
    private Ciudad ciudadZoo;

    public Zoologicos() {
    }

    public Zoologicos(Integer idZoo) {
        this.idZoo = idZoo;
    }

    public Zoologicos(Integer idZoo, String nombreZoo, int tamaãO, float presupuesto) {
        this.idZoo = idZoo;
        this.nombreZoo = nombreZoo;
        this.tamaãO = tamaãO;
        this.presupuesto = presupuesto;
    }

    public Integer getIdZoo() {
        return idZoo;
    }

    public void setIdZoo(Integer idZoo) {
        this.idZoo = idZoo;
    }

    public String getNombreZoo() {
        return nombreZoo;
    }

    public void setNombreZoo(String nombreZoo) {
        this.nombreZoo = nombreZoo;
    }

    public int getTamaãO() {
        return tamaãO;
    }

    public void setTamaãO(int tamaãO) {
        this.tamaãO = tamaãO;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    @XmlTransient
    public Collection<Animales> getAnimalesCollection() {
        return animalesCollection;
    }

    public void setAnimalesCollection(Collection<Animales> animalesCollection) {
        this.animalesCollection = animalesCollection;
    }

    public Ciudad getCiudadZoo() {
        return ciudadZoo;
    }

    public void setCiudadZoo(Ciudad ciudadZoo) {
        this.ciudadZoo = ciudadZoo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZoo != null ? idZoo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zoologicos)) {
            return false;
        }
        Zoologicos other = (Zoologicos) object;
        if ((this.idZoo == null && other.idZoo != null) || (this.idZoo != null && !this.idZoo.equals(other.idZoo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Zoologicos[ idZoo=" + idZoo + " ]";
    }
    
}
