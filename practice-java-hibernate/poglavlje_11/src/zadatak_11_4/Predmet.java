package zadatak_11_4;

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

    public Integer getId() { return id; }
    public String getOznaka() { return Oznaka; }
    public String getNaziv() { return Naziv; }
    public Integer getEspb() { return Espb; }
}
