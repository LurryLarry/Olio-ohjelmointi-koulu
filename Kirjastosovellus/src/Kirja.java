
public class Kirja {
	
	private String teoksenNimi;
	private String tekijanNimi;
	private int julkaisuVuosi;
	private int indeksi;
	
	public Kirja(String teoksenNimi, String tekijanNimi, int julkaisuVuosi, int indeksi) {
		this.indeksi = indeksi;
		this.teoksenNimi = teoksenNimi;
		this.tekijanNimi = tekijanNimi;
		this.julkaisuVuosi = julkaisuVuosi;
	}

	public Kirja() {
		this.indeksi = 900+1;
		this.teoksenNimi = "Uusi kirja";
		this.tekijanNimi = "Uusi tekijä";
		this.julkaisuVuosi = 0;
	}

	@Override
	public String toString() {
		return "Kirja [teoksenNimi=" + teoksenNimi + ", tekijanNimi=" + tekijanNimi + ", julkaisuVuosi=" + julkaisuVuosi
				+ "]";
	}

	public String getTeoksenNimi() {
		return teoksenNimi;
	}

	public void setTeoksenNimi(String teoksenNimi) {
		this.teoksenNimi = teoksenNimi;
	}

	public String getTekijanNimi() {
		return tekijanNimi;
	}

	public void setTekijanNimi(String tekijanNimi) {
		this.tekijanNimi = tekijanNimi;
	}

	public int getJulkaisuVuosi() {
		return julkaisuVuosi;
	}

	public void setJulkaisuVuosi(int julkaisuVuosi) {
		this.julkaisuVuosi = julkaisuVuosi;
	}

	public int getIndeksi() {
		return indeksi;
	}

	public void setIndeksi(int indeksi) {
		this.indeksi = indeksi;
	}
}
