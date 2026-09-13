package zadatak_11_3;
import javax.persistence.*;
@Entity @Table(name="DOSIJE",schema="DA")
public class Student {
    @Id
    private Integer indeks;

    @Column(name="IME")
    private String ime;

    @Column(name="PREZIME")
    private String prezime;

    @Column(name="IDPROGRAMA")
    private Integer idPrograma;

    public Integer getIndeks(){return indeks;}
    public String getIme(){return ime;}
    public String getPrezime(){return prezime;}
    public Integer getIdPrograma(){return idPrograma;}
}
