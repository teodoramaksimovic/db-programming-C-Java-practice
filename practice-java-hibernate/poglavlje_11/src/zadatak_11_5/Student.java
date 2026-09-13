package zadatak_11_5;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DA.DOSIJE")
class Student {
    @Id
    private Integer indeks;

    @Column(name = "IME", nullable = false)
    private String ime;

    @Column(name = "PREZIME", nullable = false)
    private String prezime;

    public Integer getIndeks() { return indeks; }
    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
}
