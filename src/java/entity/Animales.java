/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Animales.findAll", query = "SELECT a FROM Animales a")
    , @NamedQuery(name = "Animales.findByIdAnimal", query = "SELECT a FROM Animales a WHERE a.idAnimal = :idAnimal")
    , @NamedQuery(name = "Animales.findByNombreAnimal", query = "SELECT a FROM Animales a WHERE a.nombreAnimal = :nombreAnimal")
    , @NamedQuery(name = "Animales.findByGenero", query = "SELECT a FROM Animales a WHERE a.genero = :genero")
    , @NamedQuery(name = "Animales.findByFecNac", query = "SELECT a FROM Animales a WHERE a.fecNac = :fecNac")})
public class Animales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ANIMAL", nullable = false)
    private Integer idAnimal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_ANIMAL", nullable = false, length = 100)
    private String nombreAnimal;
    @Size(max = 25)
    @Column(length = 25)
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_NAC", nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fecNac;
    @ManyToMany(mappedBy = "animalesCollection")
    private Collection<Zoologicos> zoologicosCollection;
    @JoinColumn(name = "ESPECIE_ANIMAL", referencedColumnName = "ID_ESPECIES", nullable = false)
    @ManyToOne(optional = false)
    private EspeciesAnimales especieAnimal;
    @JoinColumn(name = "PAIS_ORIGEN", referencedColumnName = "ID_PAIS", nullable = false)
    @ManyToOne(optional = false)
    private Pais paisOrigen;

    public Animales() {
    }

    public Animales(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Animales(Integer idAnimal, String nombreAnimal, Date fecNac) {
        this.idAnimal = idAnimal;
        this.nombreAnimal = nombreAnimal;
        this.fecNac = fecNac;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecNac() {
        if(fecNac != null){
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = sdfDate.format(fecNac);
            System.out.println("AAAAAAAAAA: " + fecNac);
            System.out.println("BBBBBBBBBB: " + strDate);
        }
       
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        System.out.println("AAAAAAAAAA: " + fecNac);
        this.fecNac = fecNac;
    }

    @XmlTransient
    public Collection<Zoologicos> getZoologicosCollection() {
        return zoologicosCollection;
    }

    public void setZoologicosCollection(Collection<Zoologicos> zoologicosCollection) {
        this.zoologicosCollection = zoologicosCollection;
    }

    public EspeciesAnimales getEspecieAnimal() {
        return especieAnimal;
    }

    public void setEspecieAnimal(EspeciesAnimales especieAnimal) {
        this.especieAnimal = especieAnimal;
    }

    public Pais getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(Pais paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animales)) {
            return false;
        }
        Animales other = (Animales) object;
        if ((this.idAnimal == null && other.idAnimal != null) || (this.idAnimal != null && !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Animales[ idAnimal=" + idAnimal + " ]";
    }
    
}
