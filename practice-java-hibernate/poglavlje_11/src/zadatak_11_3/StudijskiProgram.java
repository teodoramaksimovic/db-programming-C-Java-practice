package zadatak_11_3;
import javax.persistence.*;
@Entity @Table(name="STUDIJSKIPROGRAM",schema="DA")
public class StudijskiProgram {
    @Id
    private Integer id;

    @Column(name="NAZIV")
    private String naziv;

    public Integer getId(){return id;}
    public String getNaziv(){return naziv;}
}
