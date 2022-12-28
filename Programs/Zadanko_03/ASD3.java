import java.io.*;
import java.util.*;

public class ASD3{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner odczyt = new Scanner(new File(args[0]));
		int iloscAkcji = odczyt.nextInt();
		Lista lista = new Lista();
		while(odczyt.hasNext()) lista.dodaj(odczyt.nextInt());
		for(int i = 0; i<iloscAkcji; i++) lista.decyzjaZycia();
		lista.print();
		odczyt.close();
	}
}
class Element{
	int liczba;
	Element nastepny;
	Element(int l){
		liczba = l;
		nastepny = null;
	}
}
class Lista{
	Element pierwszy;
	void dodaj(int liczba){
		Element nowy = new Element(liczba);
		if(pierwszy == null){
			pierwszy = nowy;
			pierwszy.nastepny = pierwszy;
		}
		else{
			Element ostatni = pierwszy;
			while(ostatni.nastepny != pierwszy){
				ostatni = ostatni.nastepny;
			}
			ostatni.nastepny = nowy;
			nowy.nastepny = pierwszy;
		}
	}
	void add(){
		Element nowy = new Element(pierwszy.liczba-1);
		nowy.nastepny = pierwszy.nastepny;
		pierwszy.nastepny = nowy;
		int pomoc = pierwszy.liczba;
		for(int i = 0; i<pomoc; i++){
			pierwszy = pierwszy.nastepny;
		}
	}
	void delete(){
		int pomoc = pierwszy.nastepny.liczba;
		pierwszy.nastepny = pierwszy.nastepny.nastepny;
		for(int i = 0; i<pomoc; i++){
			pierwszy = pierwszy.nastepny;
		}
	}
	void decyzjaZycia(){
		if(pierwszy.liczba%2 == 0) this.delete();
		else this.add();
	}
	void print(){
		Element obecny = pierwszy;
		System.out.print(obecny.liczba + " ");
		obecny = obecny.nastepny;
		while(obecny != pierwszy){
			System.out.print(obecny.liczba + " ");
			obecny = obecny.nastepny;
		}
	}
}