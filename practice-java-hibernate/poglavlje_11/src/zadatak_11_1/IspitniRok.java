package zadatak_11_1;
import java.sql.Date;
import javax.persistence.*;
@Entity
@Table(name="ISPITNIROK",schema="DA")
public class IspitniRok {
    @EmbeddedId
    private IspitniRokId id;

    @Column(name="NAZIV")
    private String naziv;

    @Column(name="DATPOCETKA")
    private Date datPocetka;

    @Column(name="DATKRAJA")
    private Date datKraja;

    public IspitniRok() {}
    @Override public String toString() {
        return id.getSkGodina()+" "+id.getOznakaRoka()+" - "+naziv+" ("+datPocetka+" - "+datKraja+")";
    }
}
