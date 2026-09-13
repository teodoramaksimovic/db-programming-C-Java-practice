package zadatak_11_3;
import javax.persistence.*;
@Entity @Table(name="ISPIT",schema="DA")
public class Ispit {
    @EmbeddedId
    private IspitId id;

    @Column(name="OCENA")
    private Short ocena;

    @Column(name="STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name="INDEKS",referencedColumnName="INDEKS",insertable=false,updatable=false)
    private Student student;

    public Short getOcena(){return ocena;}
    public String getStatus(){return status;}
    public Student getStudent(){return student;}
}
