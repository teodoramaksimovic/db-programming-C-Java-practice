package zadatak_11_2;
import javax.persistence.*;
@Entity @Table(name="DOSIJE",schema="DA")
public class Student {
    @Id
    private Integer indeks;

    @Column(name="IME")
    private String ime;

    @Column(name="PREZIME")
    private String prezime;

    @Column(name="MESTORODJENJA")
    private String mesto;

    @ManyToOne
    @JoinColumn(name="IDPROGRAMA",referencedColumnName="ID",insertable=false,updatable=false)
    private StudijskiProgram studijskiProgram;

    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
    public StudijskiProgram getStudijskiProgram() { return studijskiProgram; }
}
