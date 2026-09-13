package zadatak_11_6;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DA.DOSIJE")
class Student {
    @Id
    private Integer indeks;

    @Column(name = "IDPROGRAMA", nullable = false)
    private Integer idPrograma;

    @Column(name = "IME", nullable = false)
    private String ime;

    @Column(name = "PREZIME", nullable = false)
    private String prezime;

    @Column(name = "DATUPISA", nullable = false)
    private Date datumUpisa;

    @ManyToOne
    @JoinColumn(name = "IDPROGRAMA", referencedColumnName = "ID", insertable = false, updatable = false)
    private StudijskiProgram studijskiProgram;

    @OneToMany(mappedBy = "student")
    private List<Ispit> ispiti = new ArrayList<>();

    public Integer getIndeks() { return indeks; }
    public Integer getIdPrograma() { return idPrograma; }
    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
    public Date getDatumUpisa() { return datumUpisa; }
    public StudijskiProgram getStudijskiProgram() { return studijskiProgram; }
    public List<Ispit> getIspiti() { return ispiti; }

    public int brojPolozenih() {
        int broj = 0;
        for (Ispit ispit : ispiti) {
            if (ispit.getStatus().equalsIgnoreCase("o") &&
                ispit.getOcena() != null && ispit.getOcena() > 5) {
                broj++;
            }
        }
        return broj;
    }

    public double prosek() {
        double ukupno = 0;
        int broj = 0;

        for (Ispit ispit : ispiti) {
            if (ispit.getStatus().equalsIgnoreCase("o") &&
                ispit.getOcena() != null && ispit.getOcena() > 5) {
                ukupno += ispit.getOcena();
                broj++;
            }
        }

        if (broj == 0)
            return 0;

        return ukupno / broj;
    }
}
