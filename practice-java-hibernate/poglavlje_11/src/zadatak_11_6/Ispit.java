package zadatak_11_6;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DA.ISPIT")
class Ispit {
    @EmbeddedId
    private IspitId id;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "OCENA")
    private Integer ocena;

    @ManyToOne
    @JoinColumn(name = "INDEKS", referencedColumnName = "INDEKS", insertable = false, updatable = false)
    private Student student;

    public String getStatus() { return status; }
    public Integer getOcena() { return ocena; }
    public Student getStudent() { return student; }
}
