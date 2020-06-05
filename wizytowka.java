package wizytowka;

import java.io.FileWriter;			//Biblioteka odpowiadaj¹ca za obs³uge zapisu do pliku
import java.io.BufferedReader;			//Biblioteka odpowiadaj¹ca za obs³uge zapisu do pliku
import java.io.File;			//Biblioteka odpowiadaj¹ca za obs³uge dostêpu do pliku
import java.io.FileReader;			//Biblioteka odpowiadaj¹ca za obs³uge odczytu z pliku
import java.io.IOException;			//Biblioteka odpowiadaj¹ca za obs³ugê wyj¹tków (try...catch)
import java.time.LocalDateTime;			//Biblioteka odpowiadaj¹ca za odczyt aktualnej daty i czasu
import java.util.Scanner;			//Biblioteka odpowiadaj¹ca za pobieranie danych z klawiatury

//Patryk Andrzejewski
//U-15565
//Wizytówka

/* Test szyfrowania
String test = "Patryk Andrzejewski";
System.out.println(szyfrowanie(test));
System.out.println(odszyfrowanie(test));
*/

public class wizytowka {			//G³ówna klasa
	//Funkcja z menu
	public static void menu() {
		System.out.println("Menu programu wizytowka");			//Wyœwietlanie treœci menu
		System.out.println("-----------------------");			//Wyœwietlanie treœci menu
		System.out.println("1. Zapisz dane");			//Wyœwietlanie treœci menu
		System.out.println("2. Odczytaj dane");			//Wyœwietlanie treœci menu
		System.out.println("3. Zamknij program");			//Wyœwietlanie treœci menu
		System.out.println("-----------------------");			//Wyœwietlanie treœci menu
	}
	//Funkcja odpowiadaj¹ca za dodawanie danych do pliku zapis.txt
	public static void zapis_wizytowka(String imie,String nazwisko,String n_f,String a_f,String regon,String telefon,String adresmail) {
		try {
			FileWriter Zapis = new FileWriter("zapis.txt", true);			//Utworzenie zmiennej zapis która daje dostêp do pliku "zapis.txt" znajduj¹cego siê w folderze z klas¹ oraz nadanie jej atrybutu "true" który odpowiada za dodawanie danych na koñcu pliku zamiast go nadpisywaæ
			imie = (imie + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			imie = szyfrowanie(imie);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(imie);			//Zapis danych do pliku
			nazwisko = (nazwisko + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			nazwisko = szyfrowanie(nazwisko);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(nazwisko);			//Zapis danych do pliku
			n_f = (n_f + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			n_f = szyfrowanie(n_f);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(n_f);			//Zapis danych do pliku
			a_f = (a_f + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			a_f = szyfrowanie(a_f);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(a_f);			//Zapis danych do pliku
			regon = (regon + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			regon = szyfrowanie(regon);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(regon);			//Zapis danych do pliku
			telefon = (telefon + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			telefon = szyfrowanie(telefon);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(telefon);			//Zapis danych do pliku
			adresmail = (adresmail + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			adresmail = szyfrowanie(adresmail);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(adresmail);			//Zapis danych do pliku
			String data = ("Data utworzenia: " + LocalDateTime.now() + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			data = szyfrowanie(data);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(data);			//Zapis aktualnej daty z komputera do pliku
			Zapis.close();			//Zamkniêcie dostêpu do pliku
		}catch (IOException a) {
			System.out.println("*Wyst¹pi³ b³¹d podczas próby zapisu do pliku*");			//Informacja o b³edzie
			a.printStackTrace();
		}
	}
	//Funkcja odpowiadaj¹ca za odczyt danych z pliku zapis.txt
	public static void odczyt_wizytowek() {
		try {
			FileReader Odczyt = new FileReader("zapis.txt");			//Utworzenie zmiennej odczyt która daje dostêp do pliku "zapis.txt" znajduj¹cego siê w folderze z klas¹.
			BufferedReader bodczyt = new BufferedReader(Odczyt);
			String linia;		//Deklaracja zmiennej	
			while ((linia = bodczyt.readLine()) != null){		//Pêtla odpowiadaj¹ca za wypisanie zawartoœci pliku 
				linia = odszyfrowanie(linia);			//Wywo³anie funkcji odszyfrowania danych i zapis zwróconych danych do zmiennej
				System.out.print(linia);			//Wyœwietlenie danych
			}
			Odczyt.close();			//Zamkniêcie dostêpu do pliku
		    System.out.println("*Odczytano z powodzeniem dane z pliku*");			//Informacja o poprawnym odczytaniu danych
		}catch (IOException a) {
			System.out.println("Wyst¹pi³ b³¹d podczas próby zapisu do pliku");			//Informacja o b³edzie
			a.printStackTrace();
		}
	}
	//funkcja odpowiadaj¹ca za szyfrowanie wiadomoœci
	public static String szyfrowanie(String tresc) {
		StringBuilder budowniczy = new StringBuilder(tresc);
		int przeskok = 2;			//utworzenie zmiennej która jest kluczem
		for (int i = 0; i < budowniczy.length(); i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
			int c = (int)budowniczy.charAt(i);			//utworzenie zmiennej i nadanie jej wartoœci liczbowej podanego znaku
			if(c + przeskok > 122) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
				c =  31 + (przeskok - (122 - c));			//Zmiana watoœci o podany klucz/przeskok
			}
			else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
				c+=przeskok;			//Zmiana watoœci o podany klucz/przeskok
			}
			budowniczy.setCharAt(i, (char)c);			//zmiana wartoœci liczbowej na znak
		}
		return budowniczy.toString();			//Zwrócenie wartoœci
	}
	//funkcja odpowiadaj¹ca za odszyfrowanie wiadomoœci
	public static String odszyfrowanie(String tresc) {
		StringBuilder budowniczy = new StringBuilder(tresc);
		int przeskok = 2;			//utworzenie zmiennej która jest kluczem
		for (int i = 0; i < budowniczy.length(); i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
			int c = (int)budowniczy.charAt(i);			//utworzenie zmiennej i nadanie jej wartoœci liczbowej podanego znaku
			if(c - przeskok < 32 && c - przeskok != 10 && c - przeskok !=13) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
				c = 123 - (przeskok - (c - 32));			//Zmiana watoœci o podany klucz/przeskok
			}
			else if(c - przeskok == 10) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
				c -=przeskok;			//Zmiana watoœci o podany klucz/przeskok
			}
			else if(c -przeskok == 13) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
				c -=przeskok;			//Zmiana watoœci o podany klucz/przeskok
			}
			else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
				c-=przeskok;			//Zmiana watoœci o podany klucz/przeskok
			}
			budowniczy.setCharAt(i, (char)c);			//zmiana wartoœci liczbowej na znak
		}
		return budowniczy.toString();			//Zwrócenie wartoœci
	}
	//Funkcja main
	public static void main(String[] args) {
		try {
			File myObj = new File("zapis.txt");			//Utworzenie pliku zapis.txt
			if (myObj.createNewFile()) {			//pêtla sprawdzaj¹ca czy plik istnia³
				System.out.println("*Utworzono plik: " + myObj.getName() + "*");			//Wyœwietla dane na ekranie
			} else {
				System.out.println("*Plik istnieje*");			//Wyœwietla dane na ekranie
			}
		}
		catch (IOException b) {
			System.out.println("*Wyst¹pi³ b³¹d podczas próby stworzenia pliku*");			//Informacja o b³edzie
			b.printStackTrace();
		}
		Scanner in = new Scanner(System.in);			//Utworzenie zmiennej odpowiadaj¹cej za odczyt danych z klawiatury
		int kontrolka=0;			//zmienna kontrolka
		String imie = new String();			//Zmienna imie
		String nazwisko = new String();			//Zmienna nazwisko
		String n_f = new String();			//Zmienna firmy
		String a_f = new String();			//Zmienna adres firmy
		String regon = new String();			//Zmienna regon
		String telefon = new String();			//Zmienna numeru
		String adresmail = new String();			//Zmienna adresu mail
		do {			//G³ówna pêtla w której s¹ odwo³ania do innych funkcji
			menu();			//odwo³anie siê do funkcji menu
			kontrolka = in.nextInt();			//Nadanie zmiennej wartoœci z klawiatury
			if(kontrolka==1) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
				in.nextLine();			//Wywo³anie nowej lini aby pozbyæ siê zjadanych danych przez nextInt
				System.out.println("Podaj imie :");			//Wyœwietlenie informacji
				imie=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwisko :");			//Wyœwietlenie informacji
				nazwisko=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwe firmy :");			//Wyœwietlenie informacji
				n_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres firmy :");			//Wyœwietlenie informacji
				a_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer regon :");			//Wyœwietlenie informacji
				regon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer telefonu :");			//Wyœwietlenie informacji
				telefon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres email :");			//Wyœwietlenie informacji
				adresmail=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				zapis_wizytowka(imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//odwo³anie siê do funkcji zapis_wizytowka oraz w nawiasie wszystkie zmienne które s¹ przekazane
			}else if(kontrolka==2) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
				odczyt_wizytowek();			//odwo³anie siê do funkcji odczyt_wizytowek
			}
		}while(kontrolka<3);			//warunek pêtli do (dzia³a je¿eli kontrolka jest mniejsza ni¿ 5)
		in.close();			//zamkniêcie strumienia in
	}
}