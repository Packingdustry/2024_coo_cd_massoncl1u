package donnees;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * La classe Magasin represente un magasin qui vend des CDs.</p>
 * 
 * cette classe est caracterisee par un ensemble de CDs correspondant aux CDS
 * vendus dans ce magasin.
 * 
 */
public class Magasin {

	/**
	 * la liste des CDs disponibles en magasin
	 */
	private ArrayList<CD> listeCds;

	/**
	 * construit un magasin par defaut qui ne contient pas de CD
	 */
	public Magasin() {
		listeCds = new ArrayList<CD>();
	}

	/**
	 * ajoute un cd au magasin
	 * 
	 * @param cdAAjouter
	 *            le cd a ajouter
	 */
	public void ajouteCd(CD cdAAjouter) {
		listeCds.add(cdAAjouter);
	}

	@Override
	/**
	 * affiche le contenu du magasin
	 */
	public String toString() {
		String chaineResultat = "";
		//parcours des Cds
		for (int i = 0; i < listeCds.size(); i++) {
			chaineResultat += listeCds.get(i);
		}
		chaineResultat += "nb Cds: " + listeCds.size();
		chaineResultat += "\n--------------------------------------\n\n";
		return (chaineResultat);

	}

	/**
	 * @return le nombre de Cds du magasin
	 */
	public int getNombreCds() {
		return listeCds.size();
	}
	
	/**
	 * permet d'acceder � un CD
	 * 
	 * @return le cd a l'indice i ou null si indice est non valide
	 */
	public CD getCd(int i)
	{
		CD res=null;
		if ((i>=0)&&(i<this.listeCds.size()))
			res=this.listeCds.get(i);
		return(res);
	}

	public void trierTitre() {
		ComparateurAlbum comp = new ComparateurAlbum();
		trier(comp);
	}

	public void trierArtiste() {
		ComparateurArtiste comp = new ComparateurArtiste();
		trier(comp);
	}

	public void trier(ComparateurCD comp) {
		ArrayList<CD> listeTemp = new ArrayList<>();
		int nb = listeCds.size();
		for (int i = 0; i < nb; i++) {
			CD min = listeCds.getFirst();
            for (CD cd : listeCds) {
                if (comp.etreAvant(cd, min)) {
                    min = cd;
                }
            }
			listeCds.remove(min);
			listeTemp.add(min);
		}
		listeCds = listeTemp;
	}

	public ArrayList<CD> chercherArtiste(String artiste) {
		SelecteurArtiste selec = new SelecteurArtiste();
		return chercher(selec, artiste);
	}

	public ArrayList<CD> chercherTitre(String titre) {
		SelecteurAlbum selec = new SelecteurAlbum();
		return chercher(selec, titre);
	}

	public ArrayList<CD> chercherTitreEtTitre(String titre1, String titre2) {
		SelecteurAlbum s1 = new SelecteurAlbum();
		SelecteurAlbum s2 = new SelecteurAlbum();
		return chercherET(s1, titre1, s2, titre2);
	}

	public ArrayList<CD> chercherArtisteEtArtiste(String artiste1, String artiste2) {
		SelecteurArtiste s1 = new SelecteurArtiste();
		SelecteurArtiste s2 = new SelecteurArtiste();
		return chercherET(s1, artiste1, s2, artiste2);
	}

	public ArrayList<CD> chercherArtisteEtTitre(String artiste, String titre) {
		SelecteurArtiste s1 = new SelecteurArtiste();
		SelecteurAlbum s2 = new SelecteurAlbum();
		return chercherET(s1, artiste, s2, titre);
	}

	public ArrayList<CD> chercherTitreEtArtiste(String titre, String artiste) {
		return chercherArtisteEtTitre(artiste, titre);
	}

	public ArrayList<CD> chercherET(SelecteurCD s1, String motCle1, SelecteurCD s2, String motCle2) {
		SelecteurET selec = new SelecteurET();
		return chercherMulti(selec, s1, motCle1, s2, motCle2);
	}

	public ArrayList<CD> chercherArtisteOuArtiste(String artiste1, String artiste2) {
		SelecteurArtiste s1 = new SelecteurArtiste();
		SelecteurArtiste s2 = new SelecteurArtiste();
		return chercherOU(s1, artiste1, s2, artiste2);
	}

	public ArrayList<CD> chercherTitreOuTitre(String titre1, String titre2) {
		SelecteurAlbum s1 = new SelecteurAlbum();
		SelecteurAlbum s2 = new SelecteurAlbum();
		return chercherOU(s1, titre1, s2, titre2);
	}

	public ArrayList<CD> chercherArtisteOuTitre(String artiste, String titre) {
		SelecteurArtiste s1 = new SelecteurArtiste();
		SelecteurAlbum s2 = new SelecteurAlbum();
		return chercherOU(s1, artiste, s2, titre);
	}

	public ArrayList<CD> chercherTitreOuArtiste(String titre, String artiste) {
		return chercherArtisteOuTitre(artiste, titre);
	}

	public ArrayList<CD> chercherOU(SelecteurCD s1, String motCle1, SelecteurCD s2, String motCle2) {
		SelecteurOU selec = new SelecteurOU();
		return chercherMulti(selec, s1, motCle1, s2, motCle2);
	}

	public ArrayList<CD> chercherNonArtiste(String artiste) {
		SelecteurArtiste selec = new SelecteurArtiste();
		return chercherNON(selec, artiste);
	}

	public ArrayList<CD> chercherNonTitre(String titre) {
		SelecteurAlbum selec = new SelecteurAlbum();
		return chercherNON(selec, titre);
	}

	public ArrayList<CD> chercherNON(SelecteurCD s1, String motCle) {
		SelecteurNON selec = new SelecteurNON();
		return chercherMulti(selec, s1, motCle, null, null);
	}

	public ArrayList<CD> chercherMulti(SelecteurMulti selec, SelecteurCD s1, String motCle1, SelecteurCD s2, String motCle2) {
		ArrayList<CD> listeTemp = new ArrayList<>();
		for(CD cd : listeCds) {
			if (selec.etreEgal(cd, s1, motCle1, s2, motCle2)) {
				listeTemp.add(cd);
			}
		}
		return listeTemp;
	}

	public ArrayList<CD> chercher(SelecteurCD select, String motCle) {
		ArrayList<CD> listeTemp = new ArrayList<>();
		for(CD cd : listeCds) {
			if (select.etreEgal(cd, motCle)) {
				listeTemp.add(cd);
			}
		}
		return listeTemp;
	}
}
