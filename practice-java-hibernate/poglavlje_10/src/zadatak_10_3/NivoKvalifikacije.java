package zadatak_10_3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DA.NIVOKVALIFIKACIJE")
class NivoKvalifikacije {
    @Id
    private Integer id;

    @Column(name = "NAZIV", nullable = false)
    private String Naziv;

    public NivoKvalifikacije() {
    }

    public NivoKvalifikacije(Integer id, String naziv) {
        this.id = id;
        Naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    @Override
    public String toString() {
        return "Nivo kvalifikacije [id=" + id + ", Naziv=" + Naziv + "]";
    }
}
