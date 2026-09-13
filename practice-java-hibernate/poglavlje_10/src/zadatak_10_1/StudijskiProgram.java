package zadatak_10_1;

import javax.persistence.*;

@Entity
@Table(name="STUDIJSKIPROGRAM", schema="DA")
class StudijskiProgram {
    @Id private
    Integer id;

    @Column(name="OZNAKA", nullable=false)
    private String oznaka;

    @Column(name="NAZIV", nullable=false)
    private String naziv;

    @Column(name="OBIMESPB", nullable=false)
    private Integer espb;

    @Column(name="IDNIVOA", nullable=false)
    private Integer nivo;

    @Column(name="ZVANJE", nullable=false)
    private String zvanje;

    @Column(name="OPIS")
    private String opis;

    public StudijskiProgram() {}

    public StudijskiProgram(Integer id, String oznaka, String naziv, Integer espb,
                            Integer nivo, String zvanje, String opis) {
        this.id=id; this.oznaka=oznaka; this.naziv=naziv; this.espb=espb;
        this.nivo=nivo; this.zvanje=zvanje; this.opis=opis;
    }

    public Integer getId() { return id; }
    public String getOznaka() { return oznaka; }
    public void setOznaka(String oznaka) { this.oznaka=oznaka; }
    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv=naziv; }
    public Integer getEspb() { return espb; }
    public void setEspb(Integer espb) { this.espb=espb; }
    public Integer getNivo() { return nivo; }
    public void setNivo(Integer nivo) { this.nivo=nivo; }
    public String getZvanje() { return zvanje; }
    public void setZvanje(String zvanje) { this.zvanje=zvanje; }
    public String getOpis() { return opis; }
    public void setOpis(String opis) { this.opis=opis; }

    @Override
    public String toString() {
        return "StudijskiProgram(id="+id+", oznaka='"+oznaka+"', naziv='"+naziv+
               "', espb="+espb+", nivo="+nivo+", zvanje='"+zvanje+"', opis='"+opis+"')";
    }
}
