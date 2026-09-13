package zadatak_11_5;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class UpisanKursId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "INDEKS")
    private Integer indeks;

    @Column(name = "IDPREDMETA")
    private Integer idPredmeta;

    @Column(name = "SKGODINA")
    private Integer skGodina;

    public UpisanKursId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpisanKursId)) return false;
        UpisanKursId x = (UpisanKursId)o;
        return Objects.equals(indeks, x.indeks) &&
               Objects.equals(idPredmeta, x.idPredmeta) &&
               Objects.equals(skGodina, x.skGodina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indeks, idPredmeta, skGodina);
    }
}
