package zadatak_10_2;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="ISPITNIROK", schema="DA")
class IspitniRok {
    @EmbeddedId
    private IspitniRokId id;

    @Column(name="NAZIV", nullable=false)
    private String naziv;

    @Column(name="DATPOCETKA", nullable=false)
    private Date datPocetka;

    @Column(name="DATKRAJA", nullable=false)
    private Date datKraja;

    public IspitniRok() {}
    public IspitniRok(IspitniRokId id, String naziv, Date datPocetka, Date datKraja) {
        this.id=id; this.naziv=naziv; this.datPocetka=datPocetka; this.datKraja=datKraja;
    }
    @Override public String toString() {
        return "IspitniRok("+id.getSkGodina()+", "+id.getOznakaRoka()+", naziv='"+naziv+
               "', "+datPocetka+" - "+datKraja+")";
    }
}
