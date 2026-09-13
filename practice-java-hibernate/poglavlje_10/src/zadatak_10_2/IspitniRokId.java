package zadatak_10_2;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
class IspitniRokId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="SKGODINA")
    private Short skGodina;

    @Column(name="OZNAKAROKA")
    private String oznakaRoka;

    public IspitniRokId() {}
    public IspitniRokId(int skGodina, String oznakaRoka) {
        this.skGodina=(short)skGodina; this.oznakaRoka=oznakaRoka;
    }
    public Short getSkGodina() { return skGodina; }
    public String getOznakaRoka() { return oznakaRoka; }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof IspitniRokId))
            return false;
        IspitniRokId x=(IspitniRokId)o;
        return Objects.equals(skGodina,x.skGodina) && Objects.equals(oznakaRoka,x.oznakaRoka);
    }
    @Override public int hashCode() { return Objects.hash(skGodina, oznakaRoka); }
}
