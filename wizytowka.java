package wizytowka;

import java.io.FileWriter;			//Biblioteka odpowiadaj�ca za obs�uge zapisu do pliku
import java.io.BufferedReader;			//Biblioteka odpowiadaj�ca za obs�uge zapisu do pliku
import java.io.File;			//Biblioteka odpowiadaj�ca za obs�uge dost�pu do pliku
import java.io.FileReader;			//Biblioteka odpowiadaj�ca za obs�uge odczytu z pliku
import java.io.IOException;			//Biblioteka odpowiadaj�ca za obs�ug� wyj�tk�w (try...catch)
import java.time.LocalDateTime;			//Biblioteka odpowiadaj�ca za odczyt aktualnej daty i czasu
import java.util.Scanner;			//Biblioteka odpowiadaj�ca za pobieranie danych z klawiatury

//Patryk Andrzejewski
//U-15565
//Wizyt�wka

/* Test szyfrowania
String test = "Patryk Andrzejewski";
System.out.println(szyfrowanie(test));
System.out.println(odszyfrowanie(test));
*/

public class wizytowka {			//G��wna klasa
	//Funkcja z menu
	public static void menu() {
		System.out.println("Menu programu wizytowka");			//Wy�wietlanie tre�ci menu
		System.out.println("-----------------------");			//Wy�wietlanie tre�ci menu
		System.out.println("1. Zapisz dane");			//Wy�wietlanie tre�ci menu
		System.out.println("2. Odczytaj dane");			//Wy�wietlanie tre�ci menu
		System.out.println("3. Zamknij program");			//Wy�wietlanie tre�ci menu
		System.out.println("-----------------------");			//Wy�wietlanie tre�ci menu
	}
	//Funkcja odpowiadaj�ca za dodawanie danych do pliku zapis.txt
	public static void zapis_wizytowka(String imie,String nazwisko,String n_f,String a_f,String regon,String telefon,String adresmail) {
		try {
			FileWriter Zapis = new FileWriter("zapis.txt", true);			//Utworzenie zmiennej zapis kt�ra daje dost�p do pliku "zapis.txt" znajduj�cego si� w folderze z klas� oraz nadanie jej atrybutu "true" kt�ry odpowiada za dodawanie danych na ko�cu pliku zamiast go nadpisywa�
			imie = (imie + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			imie = szyfrowanie(imie);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(imie);			//Zapis danych do pliku
			nazwisko = (nazwisko + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			nazwisko = szyfrowanie(nazwisko);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(nazwisko);			//Zapis danych do pliku
			n_f = (n_f + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			n_f = szyfrowanie(n_f);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(n_f);			//Zapis danych do pliku
			a_f = (a_f + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			a_f = szyfrowanie(a_f);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(a_f);			//Zapis danych do pliku
			regon = (regon + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			regon = szyfrowanie(regon);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(regon);			//Zapis danych do pliku
			telefon = (telefon + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			telefon = szyfrowanie(telefon);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(telefon);			//Zapis danych do pliku
			adresmail = (adresmail + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			adresmail = szyfrowanie(adresmail);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(adresmail);			//Zapis danych do pliku
			String data = ("Data utworzenia: " + LocalDateTime.now() + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			data = szyfrowanie(data);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(data);			//Zapis aktualnej daty z komputera do pliku
			Zapis.close();			//Zamkni�cie dost�pu do pliku
		}catch (IOException a) {
			System.out.println("*Wyst�pi� b��d podczas pr�by zapisu do pliku*");			//Informacja o b�edzie
			a.printStackTrace();
		}
	}
	//Funkcja odpowiadaj�ca za odczyt danych z pliku zapis.txt
	public static void odczyt_wizytowek() {
		try {
			FileReader Odczyt = new FileReader("zapis.txt");			//Utworzenie zmiennej odczyt kt�ra daje dost�p do pliku "zapis.txt" znajduj�cego si� w folderze z klas�.
			BufferedReader bodczyt = new BufferedReader(Odczyt);
			String linia;		//Deklaracja zmiennej	
			while ((linia = bodczyt.readLine()) != null){		//P�tla odpowiadaj�ca za wypisanie zawarto�ci pliku 
				linia = odszyfrowanie(linia);			//Wywo�anie funkcji odszyfrowania danych i zapis zwr�conych danych do zmiennej
				System.out.print(linia);			//Wy�wietlenie danych
			}
			Odczyt.close();			//Zamkni�cie dost�pu do pliku
		    System.out.println("*Odczytano z powodzeniem dane z pliku*");			//Informacja o poprawnym odczytaniu danych
		}catch (IOException a) {
			System.out.println("Wyst�pi� b��d podczas pr�by zapisu do pliku");			//Informacja o b�edzie
			a.printStackTrace();
		}
	}
	//funkcja odpowiadaj�ca za szyfrowanie wiadomo�ci
	public static String szyfrowanie(String tresc) {
		StringBuilder budowniczy = new StringBuilder(tresc);
		int przeskok = 2;			//utworzenie zmiennej kt�ra jest kluczem
		for (int i = 0; i < budowniczy.length(); i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
			int c = (int)budowniczy.charAt(i);			//utworzenie zmiennej i nadanie jej warto�ci liczbowej podanego znaku
			if(c + przeskok > 122) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
				c =  31 + (przeskok - (122 - c));			//Zmiana wato�ci o podany klucz/przeskok
			}
			else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
				c+=przeskok;			//Zmiana wato�ci o podany klucz/przeskok
			}
			budowniczy.setCharAt(i, (char)c);			//zmiana warto�ci liczbowej na znak
		}
		return budowniczy.toString();			//Zwr�cenie warto�ci
	}
	//funkcja odpowiadaj�ca za odszyfrowanie wiadomo�ci
	public static String odszyfrowanie(String tresc) {
		StringBuilder budowniczy = new StringBuilder(tresc);
		int przeskok = 2;			//utworzenie zmiennej kt�ra jest kluczem
		for (int i = 0; i < budowniczy.length(); i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
			int c = (int)budowniczy.charAt(i);			//utworzenie zmiennej i nadanie jej warto�ci liczbowej podanego znaku
			if(c - przeskok < 32 && c - przeskok != 10 && c - przeskok !=13) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
				c = 123 - (przeskok - (c - 32));			//Zmiana wato�ci o podany klucz/przeskok
			}
			else if(c - przeskok == 10) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
				c -=przeskok;			//Zmiana wato�ci o podany klucz/przeskok
			}
			else if(c -przeskok == 13) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
				c -=przeskok;			//Zmiana wato�ci o podany klucz/przeskok
			}
			else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
				c-=przeskok;			//Zmiana wato�ci o podany klucz/przeskok
			}
			budowniczy.setCharAt(i, (char)c);			//zmiana warto�ci liczbowej na znak
		}
		return budowniczy.toString();			//Zwr�cenie warto�ci
	}
	//Funkcja main
	public static void main(String[] args) {
		try {
			File myObj = new File("zapis.txt");			//Utworzenie pliku zapis.txt
			if (myObj.createNewFile()) {			//p�tla sprawdzaj�ca czy plik istnia�
				System.out.println("*Utworzono plik: " + myObj.getName() + "*");			//Wy�wietla dane na ekranie
			} else {
				System.out.println("*Plik istnieje*");			//Wy�wietla dane na ekranie
			}
		}
		catch (IOException b) {
			System.out.println("*Wyst�pi� b��d podczas pr�by stworzenia pliku*");			//Informacja o b�edzie
			b.printStackTrace();
		}
		Scanner in = new Scanner(System.in);			//Utworzenie zmiennej odpowiadaj�cej za odczyt danych z klawiatury
		int kontrolka=0;			//zmienna kontrolka
		String imie = new String();			//Zmienna imie
		String nazwisko = new String();			//Zmienna nazwisko
		String n_f = new String();			//Zmienna firmy
		String a_f = new String();			//Zmienna adres firmy
		String regon = new String();			//Zmienna regon
		String telefon = new String();			//Zmienna numeru
		String adresmail = new String();			//Zmienna adresu mail
		do {			//G��wna p�tla w kt�rej s� odwo�ania do innych funkcji
			menu();			//odwo�anie si� do funkcji menu
			kontrolka = in.nextInt();			//Nadanie zmiennej warto�ci z klawiatury
			if(kontrolka==1) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
				in.nextLine();			//Wywo�anie nowej lini aby pozby� si� zjadanych danych przez nextInt
				System.out.println("Podaj imie :");			//Wy�wietlenie informacji
				imie=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwisko :");			//Wy�wietlenie informacji
				nazwisko=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwe firmy :");			//Wy�wietlenie informacji
				n_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres firmy :");			//Wy�wietlenie informacji
				a_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer regon :");			//Wy�wietlenie informacji
				regon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer telefonu :");			//Wy�wietlenie informacji
				telefon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres email :");			//Wy�wietlenie informacji
				adresmail=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				zapis_wizytowka(imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//odwo�anie si� do funkcji zapis_wizytowka oraz w nawiasie wszystkie zmienne kt�re s� przekazane
			}else if(kontrolka==2) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
				odczyt_wizytowek();			//odwo�anie si� do funkcji odczyt_wizytowek
			}
		}while(kontrolka<3);			//warunek p�tli do (dzia�a je�eli kontrolka jest mniejsza ni� 5)
		in.close();			//zamkni�cie strumienia in
	}
}