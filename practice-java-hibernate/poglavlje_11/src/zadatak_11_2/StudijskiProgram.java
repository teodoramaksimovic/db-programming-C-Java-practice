package zadatak_11_2;
import java.util.List;
import javax.persistence.*;
@Entity @Table(name="STUDIJSKIPROGRAM",schema="DA")
public class StudijskiProgram {
    @Id
    private Integer id;

    @Column(name="NAZIV")
    private String naziv;

    @Column(name="OBIMESPB")
    private Integer espb;

    @OneToMany(mappedBy="studijskiProgram")
    private List<Student> studenti;

    public Integer getId() { return id; }
    public String getNaziv() { return naziv; }
    public Integer getEspb() { return espb; }
}
