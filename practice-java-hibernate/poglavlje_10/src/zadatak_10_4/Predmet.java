package zadatak_10_4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DA.PREDMET")
class Predmet {
    @Id
    private Integer id;

    @Column(name = "OZNAKA", nullable = false)
    private String Oznaka;

    @Column(name = "NAZIV", nullable = false)
    private String Naziv;

    @Column(name = "ESPB", nullable = false)
    private Integer Espb;

    public Predmet() {
    }

    public Predmet(Integer id, String oznaka, String naziv, Integer espb) {
        this.id = id;
        Oznaka = oznaka;
        Naziv = naziv;
        Espb = espb;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getOznaka() { return Oznaka; }
    public void setOznaka(String oznaka) { Oznaka = oznaka; }
    public String getNaziv() { return Naziv; }
    public void setNaziv(String naziv) { Naziv = naziv; }
    public Integer getEspb() { return Espb; }
    public void setEspb(Integer espb) { Espb = espb; }

    @Override
    public String toString() {
        return "Predmet [id=" + id + ", Oznaka=" + Oznaka + ", Naziv=" + Naziv + ", Espb=" + Espb + "]";
    }
}
