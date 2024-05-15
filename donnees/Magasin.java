package donnees;

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
		ArrayList<CD> listeTemp = new ArrayList<>();
		int nb = listeCds.size();
		for (int i = 0; i < nb; i++) {
			CD min = listeCds.getFirst();
			for (int j = 0; j < listeCds.size(); j++) {
				if (min.compareTitre(listeCds.get(j)) > 0) {
					min = listeCds.get(j);
				}
			}
			listeCds.remove(min);
			listeTemp.add(min);
		}
		listeCds = listeTemp;
	}

	public void trierArtiste() {
		ArrayList<CD> listeTemp = new ArrayList<>();
		int nb = listeCds.size();
		for (int i = 0; i < nb; i++) {
			CD min = listeCds.getFirst();
			for (int j = 0; j < listeCds.size(); j++) {
				if (min.compareArtiste(listeCds.get(j)) > 0) {
					min = listeCds.get(j);
				}
			}
			listeCds.remove(min);
			listeTemp.add(min);
		}
		listeCds = listeTemp;
	}

}
