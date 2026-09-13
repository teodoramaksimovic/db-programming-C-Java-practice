package zadatak_11_5;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DA.UPISANKURS")
class UpisanKurs {
    @EmbeddedId
    private UpisanKursId id;

    @Column(name = "SEMESTAR")
    private Integer semestar;

    @ManyToOne
    @JoinColumn(name = "INDEKS", referencedColumnName = "INDEKS", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "IDPREDMETA", referencedColumnName = "ID", insertable = false, updatable = false)
    private Predmet predmet;

    public Student getStudent() { return student; }
    public Predmet getPredmet() { return predmet; }
}
