package zadatak_11_4;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class PredmetProgramaId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "IDPREDMETA")
    private Integer idPredmeta;

    @Column(name = "IDPROGRAMA")
    private Integer idPrograma;

    public PredmetProgramaId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PredmetProgramaId)) return false;
        PredmetProgramaId x = (PredmetProgramaId)o;
        return Objects.equals(idPredmeta, x.idPredmeta) && Objects.equals(idPrograma, x.idPrograma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPredmeta, idPrograma);
    }
}
