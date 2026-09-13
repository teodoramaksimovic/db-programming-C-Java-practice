package zadatak_11_3;
import java.io.Serializable; import java.util.Objects; import javax.persistence.*;
@Embeddable
public class IspitId implements Serializable {
    @Column(name="SKGODINA")
    private Short skGodina;

    @Column(name="OZNAKAROKA")
    private String oznakaRoka;

    @Column(name="INDEKS")
    private Integer indeks;
    @Column(name="IDPREDMETA")
    private Integer idPredmeta;
    @Column(name="SEMESTAR")
    private Short semestar;

    public IspitId(){}
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(!(o instanceof IspitId))
            return false;
        IspitId x=(IspitId)o;
        return Objects.equals(skGodina,x.skGodina) && Objects.equals(oznakaRoka,x.oznakaRoka) &&
                Objects.equals(indeks,x.indeks) && Objects.equals(idPredmeta,x.idPredmeta) && Objects.equals(semestar,x.semestar);
    }
    @Override public int hashCode(){
        return Objects.hash(skGodina,oznakaRoka,indeks,idPredmeta,semestar);
    }
}
