import java.io.*;
import java.util.*;

public class ASD4 {
	public static void main(String[] argc) throws FileNotFoundException{
		Scanner odczyt = new Scanner(new File(argc[0]));
		PriorityQueue pq = new PriorityQueue();
		while(odczyt.hasNext()) pq.dodaj(odczyt.next(), odczyt.nextInt());
		for(int i = 1; i < pq.rozmiar;){
			Element e = new Element();
			e.left = pq.take();
			e.right = pq.take();
			e.n = e.left.n + e.right.n;
			e.c = e.left.c + e.right.c;
			pq.dodaj(e);
		}
		pq.print();
	}
}
class PriorityQueue{
	Element pierwszy;
	int rozmiar = 0;
	int iloscLisci = 0;
	void dodaj(String ch, int num){
		Element nowy = new Element(ch, num);
		if(pierwszy == null){//brak ele
			pierwszy = nowy;
			rozmiar++;
			iloscLisci++;
		}
		else{
			if(rozmiar == 1){//jeden ele
				if(nowy.n>pierwszy.n){
					pierwszy.nastepny = nowy;
					rozmiar++;
					iloscLisci++;
				}
				else{
					nowy.nastepny = pierwszy;
					pierwszy = nowy;
					rozmiar++;
					iloscLisci++;
				}
			}
			else{//wiecej niz jeden ele
				if(nowy.n<pierwszy.n){
					nowy.nastepny = pierwszy;
					pierwszy = nowy;
					rozmiar++;
					iloscLisci++;
				}
				else{
					Element poprzedni = pierwszy;
					Element ostatni = pierwszy.nastepny;
					while(nowy.n>ostatni.n && ostatni.nastepny!=null){
						ostatni = ostatni.nastepny;
						poprzedni = poprzedni.nastepny;
					}
					if(nowy.n < ostatni.n){
						nowy.nastepny = ostatni;
						poprzedni.nastepny = nowy;
						rozmiar++;
						iloscLisci++;
					}
					else{
						if(ostatni.nastepny==null){
							ostatni.nastepny = nowy;
							rozmiar++;
							iloscLisci++;
						}
						else{
							nowy.nastepny = ostatni.nastepny;
							ostatni.nastepny = nowy;
							rozmiar++;
							iloscLisci++;
						}
					}
				}
			}
		}
	}
	void dodaj(Element nowy){
		if(pierwszy == null){//brak ele
			pierwszy = nowy;
			rozmiar++;
		}
		else{
			if(rozmiar == 1){//jeden ele
				if(nowy.n>pierwszy.n){
					pierwszy.nastepny = nowy;
					rozmiar++;
				}
				else{
					nowy.nastepny = pierwszy;
					pierwszy = nowy;
					rozmiar++;
				}
			}
			else{//wiecej niz jeden ele
				if(nowy.n<pierwszy.n){
					nowy.nastepny = pierwszy;
					pierwszy = nowy;
					rozmiar++;
				}
				else{
					Element poprzedni = pierwszy;
					Element ostatni = pierwszy.nastepny;
					while(nowy.n>ostatni.n && ostatni.nastepny!=null){
						ostatni = ostatni.nastepny;
						poprzedni = poprzedni.nastepny;
					}
					if(nowy.n < ostatni.n){
						nowy.nastepny = ostatni;
						poprzedni.nastepny = nowy;
						rozmiar++;
					}
					else{
						if(ostatni.nastepny==null){
							ostatni.nastepny = nowy;
							rozmiar++;
						}
						else{
							nowy.nastepny = ostatni.nastepny;
							ostatni.nastepny = nowy;
							rozmiar++;
						}
					}
				}
			}
		}
	}
	Element take(){
		Element zwrot = pierwszy;
		pierwszy = pierwszy.nastepny;
		rozmiar--;
		return zwrot;
	}
	void print(){
		int i = 0;
		Element korzen = pierwszy;
		String kod = "";
		Element poprzedni = pierwszy;
		if(iloscLisci == 1) {
			System.out.println(pierwszy.c + " 0");
		}
		else{
			while(i<iloscLisci){
				if(pierwszy.left!=null){
					poprzedni = pierwszy;
					pierwszy = pierwszy.left;
					kod = kod + "0";
				}
				else if(pierwszy.right!=null){
					poprzedni = pierwszy;
					pierwszy = pierwszy.right;
					kod = kod + "1";
				}
				else{
					if(pierwszy.lisc){
						System.out.println(pierwszy.c + " " + kod);
						i++;
					}
					kod = "";
					if(poprzedni.left!=null) poprzedni.left = null;
					else poprzedni.right = null;
					pierwszy = korzen;
				}
			}
		}
	}
	void printL(){
		Element obecny = pierwszy;
		for(int i = 0; i<rozmiar; i++){
			System.out.println(obecny.c + " " + obecny.n);
			obecny = obecny.nastepny;
		}
	}
}
class Element{
	Element left;
	Element right;
	String c;
	int n;
	Element nastepny;
	boolean lisc;
	Element(String c, int n){
		this.c = c;
		this.n = n;
		nastepny = null;
		lisc = true;
	}
	Element(){
		c = "";
		lisc = false;
	}
}