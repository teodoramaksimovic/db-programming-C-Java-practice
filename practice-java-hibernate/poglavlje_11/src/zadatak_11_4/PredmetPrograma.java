package zadatak_11_4;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DA.PREDMETPROGRAMA")
class PredmetPrograma {
    @EmbeddedId
    private PredmetProgramaId id;

    @Column(name = "VRSTA", nullable = false)
    private String vrsta;

    @Column(name = "SEMESTAR")
    private Integer semestar;

    @ManyToOne
    @JoinColumn(name = "IDPREDMETA", referencedColumnName = "ID", insertable = false, updatable = false)
    private Predmet predmet;

    @ManyToOne
    @JoinColumn(name = "IDPROGRAMA", referencedColumnName = "ID", insertable = false, updatable = false)
    private StudijskiProgram studijskiProgram;

    public String getVrsta() { return vrsta; }
    public Predmet getPredmet() { return predmet; }
    public StudijskiProgram getStudijskiProgram() { return studijskiProgram; }
}
