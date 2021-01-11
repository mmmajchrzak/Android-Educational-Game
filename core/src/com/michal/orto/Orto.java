package com.michal.orto;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Align;
import java.util.ArrayList;
import java.util.Random;



public class Orto extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture layoutMenu;
	private Texture layoutGra;
	private Texture kulkaGracza;
	private Texture nowaGra;
	private Texture poziomy;
	private Texture zasady;
	private Texture strzalkaPowrotu;
	private Texture barierki;
	private Texture belka;
	private Texture meteoryt;
	private Texture belkaCzerwona;
	private Texture U;
	private Texture O;
	private Texture Z;
	private Texture RZ;
	private Texture CH;
	private Texture H;
	private Texture ortografiaU;
	private Texture ortografiaO;
	private Texture ortografiaRZ;
	private Texture ortografiaZ;
	private Texture ortografiaCH;
	private Texture ortografiaH;


	private	Vector3 nowaGraWektor;
	private	Vector3 strzalkaPowrotuWektor;
	private	Vector3 sprawdzaniePrzejsciaOrtografia;
	private	Vector3 poziomyWektor;
	private	Vector3 zasadyWektor;

	private	Rectangle nowaGraPole;
	private	Rectangle strzalkaPowrotuPole;
	private Rectangle przejscieRZ;
	private	Rectangle przejscieZ;
	private	Rectangle przejscieU;
	private	Rectangle przejscieO;
	private	Rectangle przejscieH;
	private	Rectangle przejscieCH;
	private	Rectangle poziomyPole;
	private	Rectangle zasadyPole;

	private FreeTypeFontGenerator fontGenerator;
	private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;
	private FreeTypeFontGenerator fontGeneratorKoncowy;
	private FreeTypeFontGenerator.FreeTypeFontParameter fontParameterKoncowy;
	private FreeTypeFontGenerator fontGeneratorWyraz;
	private FreeTypeFontGenerator.FreeTypeFontParameter fontParameterWyraz;
	private BitmapFont font;
	private BitmapFont fontWyraz;
	private BitmapFont fontKoncowy;
	private int pozycjaGraczaX;
	private int pozycjaGraczaY;
	private int pozycjaGraczaX1;
	private int pozycjaGraczaY1;
	private int pozycjaGraczaX2;
	private int pozycjaGraczaY2;
	private int licznikBelek;
	private int licznikMeteorytow;
	private int licznikWyniku;
	private int licznikU;
	private int czestotliwoscOrtografi;
	private int dlugoscTrwaniaOrtografi;
	private int wynik;
	private int wylosujWyraz;
	private int stanStrzalek =0;
	private int statusGry = 0;


	private Rectangle kulkaRectangle;
	private Rectangle barierkaLewaRectangle;
	private Rectangle barierkaPrawaRectangle;

	private String zasadyPisowniRz;
	private String zasadyPisowniZ;
	private String zasadyPisowniU;
	private String zasadyPisowniO;
	private String zasadyPisowniH;
	private String zasadyPisowniCH;
	private String wynikNapis;
	private String zasadyGry;

	private boolean menuGlowne = true;
	private boolean ekranStartowy = true;

	private boolean zadanieOrtograficzne = false;
	private boolean ortografiaZakonczona = true;
	private boolean grajOdNowa = true;

	private ArrayList<Integer> belkiXs = new ArrayList<Integer>();
	private ArrayList<Integer> belkiYs = new ArrayList<Integer>();

	private ArrayList<Integer> UXs = new ArrayList<Integer>();
	private ArrayList<Integer> UYs = new ArrayList<Integer>();

	private ArrayList<Integer> OXs = new ArrayList<Integer>();
	private ArrayList<Integer> OYs = new ArrayList<Integer>();

	private ArrayList<Integer> ZXs = new ArrayList<Integer>();
	private ArrayList<Integer> ZYs = new ArrayList<Integer>();

	private ArrayList<Integer> RZXs = new ArrayList<Integer>();
	private ArrayList<Integer> RZYs = new ArrayList<Integer>();

	private ArrayList<Integer> HXs = new ArrayList<Integer>();
	private ArrayList<Integer> HYs = new ArrayList<Integer>();

	private ArrayList<Integer> CHXs = new ArrayList<Integer>();
	private ArrayList<Integer> CHYs = new ArrayList<Integer>();

	private ArrayList<Integer> belkiCzerwoneXs = new ArrayList<Integer>();
	private ArrayList<Integer> belkiCzerwoneYs = new ArrayList<Integer>();

	private ArrayList<Integer> belkiOrtograficzneLeweXs = new ArrayList<Integer>();
	private ArrayList<Integer> belkiOrtograficzneLeweYs = new ArrayList<Integer>();

	private ArrayList<Integer> belkiOrtograficznePraweXs = new ArrayList<Integer>();
	private ArrayList<Integer> belkiOrtograficznePraweYs = new ArrayList<Integer>();

	private ArrayList<Integer> belkiOrtografiaXs = new ArrayList<Integer>();
	private ArrayList<Integer> belkiOrtografiaYs = new ArrayList<Integer>();

	private ArrayList<Integer> meteorytXs = new ArrayList<Integer>();
	private ArrayList<Integer> meteorytYs = new ArrayList<Integer>();

	private ArrayList<Rectangle> belkaRectangle = new ArrayList<Rectangle>();

	private ArrayList<Rectangle> meteorytRectangle = new ArrayList<Rectangle>();

	private ArrayList<Rectangle> belkaCzerwonaRectangle = new ArrayList<Rectangle>();

	private ArrayList<Rectangle> belkaOrtograficznaLewaRectangle = new ArrayList<Rectangle>();

	private ArrayList<Rectangle> belkaOrtograficznaPrawaRectangle = new ArrayList<Rectangle>();


	private Random losowa;
	private Random numerWyrazu;


	@Override
	public void create () {
		batch = new SpriteBatch();
		layoutMenu = new Texture("layoutMenu.jpg");
		layoutGra = new Texture("layoutGra.jpg");
		kulkaGracza = new Texture("kulkaGraczaPrzycieta.png");
		belka = new Texture("belkaPoziomaPrzycieta.png");
		belkaCzerwona = new Texture("belkaCzerwonaPoprawionav3.png");
		meteoryt = new Texture("meteorytBlure.png");
		barierki = new Texture("barierki.png");
		nowaGra = new Texture("Nowagra.png");
		poziomy = new Texture("zasady.png");
		zasady = new Texture("ortografia.png");
		strzalkaPowrotu = new Texture("strzalkaPowrotu.png");
		U = new Texture("U.png");
		O = new Texture("Ó.png");
		Z = new Texture("Ż.png");
		RZ = new Texture("RZ.png");
		H = new Texture("H.png");
		CH = new Texture("CH.png");

		ortografiaU = new Texture("ortografiaU.png");
		ortografiaO = new Texture("ortografiaÓ.png");
		ortografiaZ = new Texture("ortografiaŻ.png");
		ortografiaRZ = new Texture("ortografiaRZ.png");
		ortografiaH = new Texture("ortografiaH.png");
		ortografiaCH = new Texture("ortografiaCH.png");



		kulkaRectangle = new Rectangle();
		barierkaLewaRectangle = new Rectangle();
		barierkaPrawaRectangle = new Rectangle();

		losowa = new Random();
		numerWyrazu = new Random();

		fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Aleo-Italic.otf"));
		fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParameter.size=60;
		font = fontGenerator.generateFont(fontParameter);

		fontGeneratorKoncowy = new FreeTypeFontGenerator(Gdx.files.internal("Aleo-Italic.otf"));
		fontParameterKoncowy = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParameterKoncowy.size=140;
		fontKoncowy = fontGeneratorKoncowy.generateFont(fontParameterKoncowy);

		fontGeneratorWyraz = new FreeTypeFontGenerator(Gdx.files.internal("nasalization-rg.ttf"));
		fontParameterWyraz = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParameterWyraz.size=140;
		fontWyraz = fontGeneratorWyraz.generateFont(fontParameterWyraz);

	}

	public void poruszanieKulka(){

		if (ekranStartowy) {
			pozycjaGraczaX = Gdx.graphics.getWidth() / 13 - kulkaGracza.getWidth() / 2;
			pozycjaGraczaY = Gdx.graphics.getHeight() / 11 - kulkaGracza.getHeight()/2 ;
		}
		if (Gdx.input.justTouched()) {

			pozycjaGraczaX1 = Gdx.input.getX() - kulkaGracza.getWidth() / 2;
			pozycjaGraczaY1 = Gdx.graphics.getHeight() - Gdx.input.getY() - kulkaGracza.getHeight() / 2;
		}

		if (Gdx.input.isTouched()) {
			ekranStartowy = false;
			//pozycjaGraczaX = 0;
			//pozycjaGraczaY = 0;
			pozycjaGraczaX2 = Gdx.input.getX() - kulkaGracza.getWidth() / 2;
			pozycjaGraczaY2 = Gdx.graphics.getHeight() - Gdx.input.getY() - kulkaGracza.getHeight() / 2;
			//pozycjaGraczaX = pozycjaGraczaX+pozycjaGraczaX2-pozycjaGraczaX1;
			//pozycjaGraczaY = pozycjaGraczaY+pozycjaGraczaY2-pozycjaGraczaY1;
		}
		if(!Gdx.input.isTouched()){
			pozycjaGraczaX = pozycjaGraczaX + pozycjaGraczaX2 - pozycjaGraczaX1;
			pozycjaGraczaY = pozycjaGraczaY + pozycjaGraczaY2 - pozycjaGraczaY1;
			pozycjaGraczaX1 = 0;
			pozycjaGraczaX2 = 0;
			pozycjaGraczaY1 = 0;
			pozycjaGraczaY2 = 0;
		}
	}

	public void warunkiPrzejsciaOrtografia(){

		if (strzalkaPowrotuPole.contains(strzalkaPowrotuWektor.x, strzalkaPowrotuWektor.y) && menuGlowne == false)          // Sprawdzenie czy współrzędne zawierają sie w prostokątnym polu
		{
			menuGlowne = true;
			stanStrzalek = 0;
			zasadyWektor.x = 0;                                                                                                // zerowanie pola Zasady, nie chcemy go w if wyzej bo pole Zasady ma zawierać wcześniej klikniete dane tak długo az nie bedziemy chcieli wyjsc
			zasadyWektor.y = 0;
		}

		if(przejscieRZ.contains(sprawdzaniePrzejsciaOrtografia.x, sprawdzaniePrzejsciaOrtografia.y)){
			stanStrzalek=0;
		}
		if(przejscieZ.contains(sprawdzaniePrzejsciaOrtografia.x, sprawdzaniePrzejsciaOrtografia.y)){
			stanStrzalek=1;
		}
		if(przejscieU.contains(sprawdzaniePrzejsciaOrtografia.x, sprawdzaniePrzejsciaOrtografia.y)){
			stanStrzalek=2;
		}
		if(przejscieO.contains(sprawdzaniePrzejsciaOrtografia.x, sprawdzaniePrzejsciaOrtografia.y)){
			stanStrzalek=3;
		}
		if(przejscieH.contains(sprawdzaniePrzejsciaOrtografia.x, sprawdzaniePrzejsciaOrtografia.y)){
			stanStrzalek=4;
		}
		if(przejscieCH.contains(sprawdzaniePrzejsciaOrtografia.x, sprawdzaniePrzejsciaOrtografia.y)){
			stanStrzalek=5;
		}
	}

	public void losowanko(){
		float wylosujWyraz2 = numerWyrazu.nextFloat() * 59;
		wylosujWyraz = (int) wylosujWyraz2;
	}

	public void stworzBelke(){
		float szerokosc = losowa.nextFloat() * 14/22*Gdx.graphics.getWidth();
		belkiXs.add((int)szerokosc);
		belkiYs.add(Gdx.graphics.getHeight());
	}

	public void stworzBelkeOrtograficznaLewa(){
			float szerokosc = Gdx.graphics.getWidth() / 12;
			belkiOrtograficzneLeweXs.add((int) szerokosc);
			belkiOrtograficzneLeweYs.add(Gdx.graphics.getHeight());
	}

	public void renderBelkiOrtograficznejLewej(){
		belkaOrtograficznaLewaRectangle.clear();
		for (int i = 0; i < belkiOrtograficzneLeweYs.size(); i++) {
			batch.draw(belka, belkiOrtograficzneLeweXs.get(i), belkiOrtograficzneLeweYs.get(i));
			belkiOrtograficzneLeweYs.set(i, belkiOrtograficzneLeweYs.get(i) - 20);
			belkaOrtograficznaLewaRectangle.add(new Rectangle(belkiOrtograficzneLeweXs.get(i) + belka.getWidth()/ 11, belkiOrtograficzneLeweYs.get(i) + belka.getHeight() * 45 / 93, belka.getWidth() - belka.getWidth() / 11, belka.getHeight() - belka.getHeight() * 83 / 93));
		}
	}

	public void kolizjaBelkiOrtograficznejLewej(){
		for (int i = 0; i < belkaOrtograficznaLewaRectangle.size(); i++) {
			if (Intersector.overlaps(kulkaRectangle, belkaOrtograficznaLewaRectangle.get(i))) {
				statusGry = 3;
			}
		}
	}



	public void stworzBelkeOrtograficznaPrawa(){
		float szerokosc =Gdx.graphics.getWidth()/2+Gdx.graphics.getWidth()/8;
		belkiOrtograficznePraweXs.add((int)szerokosc);
		belkiOrtograficznePraweYs.add(Gdx.graphics.getHeight());
	}

	public void renderBelkiOrtograficznejPrawej(){
		belkaOrtograficznaPrawaRectangle.clear();
		for (int i = 0; i < belkiOrtograficznePraweYs.size(); i++) {
			batch.draw(belka, belkiOrtograficznePraweXs.get(i), belkiOrtograficznePraweYs.get(i));
			belkiOrtograficznePraweYs.set(i, belkiOrtograficznePraweYs.get(i) - 20);
			belkaOrtograficznaPrawaRectangle.add(new Rectangle(belkiOrtograficznePraweXs.get(i) + belka.getWidth()  / 11, belkiOrtograficznePraweYs.get(i) + belka.getHeight() * 45 / 93, belka.getWidth() - belka.getWidth() * 3 / 11, belka.getHeight() - belka.getHeight() * 83 / 93));
		}
	}

	public void kolizjaBelkiOrtograficznejPrawej(){
		for (int i = 0; i < belkaOrtograficznaPrawaRectangle.size(); i++) {
			if (Intersector.overlaps(kulkaRectangle, belkaOrtograficznaPrawaRectangle.get(i))) {
				statusGry = 3;
			}
		}
	}

	public void stworzBelkeCzerwona(){
		float szerokosc = Gdx.graphics.getWidth()/3;
		belkiCzerwoneXs.add((int)szerokosc);
		belkiCzerwoneYs.add(Gdx.graphics.getHeight());
	}

	public void renderKolizjaBelkiCzerwonej(){
		belkaCzerwonaRectangle.clear();
		for(int i=0; i<belkiCzerwoneYs.size();i++) {
			batch.draw(belkaCzerwona, belkiCzerwoneXs.get(i), belkiCzerwoneYs.get(i));
			belkiCzerwoneYs.set(i, belkiCzerwoneYs.get(i) - 20);
			belkaCzerwonaRectangle.add(new Rectangle(belkiCzerwoneXs.get(i) + belkaCzerwona.getWidth()*2/11, belkiCzerwoneYs.get(i) + belkaCzerwona.getHeight()*45/93, belkaCzerwona.getWidth() - belkaCzerwona.getWidth()*4/11, belkaCzerwona.getHeight()- belkaCzerwona.getHeight()*83/93));
		}

		for(int i=0; i<belkaCzerwonaRectangle.size(); i++){
			if(Intersector.overlaps(kulkaRectangle, belkaCzerwonaRectangle.get(i))){
				statusGry=3;
			}
		}
	}

	public void stworzU(){
		float szerokosc =Gdx.graphics.getWidth()/8; //(1/2)*Gdx.graphics.getWidth();
		UXs.add((int)szerokosc);
		UYs.add(Gdx.graphics.getHeight());
	}

	public void stworzO(){
		float szerokosc =Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/3;//12/22*Gdx.graphics.getWidth();
		OXs.add((int)szerokosc);
		OYs.add(Gdx.graphics.getHeight());
	}

	public void stworzZ(){
		float szerokosc =Gdx.graphics.getWidth()/8;
		ZXs.add((int)szerokosc);
		ZYs.add(Gdx.graphics.getHeight());
	}

	public void stworzRZ(){
		float szerokosc =Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/3;
		RZXs.add((int)szerokosc);
		RZYs.add(Gdx.graphics.getHeight());
	}

	public void stworzH(){
		float szerokosc =Gdx.graphics.getWidth()/8;
		HXs.add((int)szerokosc);
		HYs.add(Gdx.graphics.getHeight());
	}

	public void stworzCH(){
		float szerokosc =Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/3;
		CHXs.add((int)szerokosc);
		CHYs.add(Gdx.graphics.getHeight());
	}

	public void stworzMeteoryt(){
		float szerokosc = losowa.nextFloat() * 14/22*Gdx.graphics.getWidth();
		meteorytXs.add((int)szerokosc);
		meteorytYs.add(Gdx.graphics.getHeight());
	}


	@Override
	public void render () {


		if(statusGry==0){ //Menu i rzeczy z menu oprócz gry

			grajOdNowa = true;
			if(menuGlowne==true)																									// Sprawdzanie wejscia do menu głównego
			{
				batch.begin();
				batch.draw(layoutMenu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());								// wstawienie tła menu
				batch.draw(nowaGra, (Gdx.graphics.getWidth()-nowaGra.getWidth())/2, 2*Gdx.graphics.getHeight()/3);																					// wstawienie napisow
				batch.draw(poziomy, (Gdx.graphics.getWidth()-poziomy.getWidth())/2, Gdx.graphics.getHeight()/2);
				batch.draw(zasady, (Gdx.graphics.getWidth()-zasady.getWidth())/2, Gdx.graphics.getHeight()/3);
				batch.end();

				nowaGraWektor = new Vector3( Gdx.input.getX() , Gdx.input.getY(),0 );											// Przypisanie współrzędnych kliknięcia do tmp
				nowaGraPole = new Rectangle((Gdx.graphics.getWidth()-nowaGra.getWidth())/2,Gdx.graphics.getHeight()/3-nowaGra.getHeight(),nowaGra.getWidth(),nowaGra.getHeight());

				poziomyWektor = new Vector3( Gdx.input.getX() , Gdx.input.getY(),0 );
				poziomyPole = new Rectangle((Gdx.graphics.getWidth()-zasady.getWidth())/2,Gdx.graphics.getHeight()/2-poziomy.getHeight(),poziomy.getWidth(),poziomy.getHeight());

				zasadyWektor = new Vector3( Gdx.input.getX() , Gdx.input.getY(),0 );
				zasadyPole = new Rectangle((Gdx.graphics.getWidth()-zasady.getWidth())/2,2*Gdx.graphics.getHeight()/3-zasady.getHeight(),zasady.getWidth(),zasady.getHeight());
			}


			if(nowaGraPole.contains(nowaGraWektor.x,nowaGraWektor.y))																// Sprawdzenie wejścia do Nowa Gra
			{
				statusGry=1;
			}


			if(poziomyPole.contains(poziomyWektor.x,poziomyWektor.y))																// Sprawdzenie wejścia do Poziomy
			{
				Zasady zasady = new Zasady();
				zasadyGry = zasady.graZasady();
				batch.begin();
				batch.draw(layoutMenu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				batch.draw(strzalkaPowrotu, 0, Gdx.graphics.getHeight()-221);
				font.draw(batch, zasadyGry, 30, Gdx.graphics.getHeight()-300, 1000,1000 , true);
				batch.end();

				menuGlowne = false;

				strzalkaPowrotuWektor = new Vector3(Gdx.input.getX() , Gdx.input.getY(), 0);                                     // Przypisanie współrzędnych kliknięcia do Strzałki powrotu
				strzalkaPowrotuPole = new Rectangle(0,0,208,221);                                       		// tworzenie prostokątnego pola o wymiarach Strzałki powrotnej

				if (strzalkaPowrotuPole.contains(strzalkaPowrotuWektor.x, strzalkaPowrotuWektor.y) && menuGlowne == false)          // Sprawdzenie czy współrzędne zawierają sie w prostokątnym polu
				{
					Gdx.app.log("MyTag", "powrot");
					menuGlowne = true;																								// Powrót co menu głównego
					poziomyWektor.x = 0;																							// zerowanie pola Poziomy, nie chcemy go w if wyzej bo pole Poziomy ma zawierać wcześniej klikniete dane tak długo az nie bedziemy chcieli wyjsc
					poziomyWektor.y = 0;
				}

			}


			if(zasadyPole.contains(zasadyWektor.x,zasadyWektor.y) && stanStrzalek==0)																	// Sprawdzenie wejścia do Zasady
			{
				Zasady zasady = new Zasady();
				zasadyPisowniRz=zasady.rzZasady();
				batch.begin();
				batch.draw(layoutMenu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				batch.draw(strzalkaPowrotu, 0, Gdx.graphics.getHeight()-strzalkaPowrotu.getHeight());
				batch.draw(ortografiaCH, Gdx.graphics.getWidth()*5/6-20, 0);
				batch.draw(ortografiaH, Gdx.graphics.getWidth()*2/3, 0);
				batch.draw(ortografiaO, Gdx.graphics.getWidth()/2, 0);
				batch.draw(ortografiaU, Gdx.graphics.getWidth()/3, 0);
				batch.draw(ortografiaZ, Gdx.graphics.getWidth()/6+40, 0);
				batch.draw(ortografiaRZ, 20, 0);
				font.draw(batch, zasadyPisowniRz, 30, Gdx.graphics.getHeight()-300, 1000,1000 , true);
				batch.end();

				menuGlowne = false;

				strzalkaPowrotuWektor = new Vector3(Gdx.input.getX() , Gdx.input.getY(), 0);                                     // Przypisanie współrzędnych kliknięcia do Strzałki powrotu
				strzalkaPowrotuPole = new Rectangle(0,0,208,221);                                       		// tworzenie prostokątnego pola o wymiarach Strzałki powrotnej

				przejscieRZ = new Rectangle(30, Gdx.graphics.getHeight()-ortografiaRZ.getHeight(), ortografiaRZ.getWidth(), ortografiaRZ.getHeight());
				przejscieZ = new Rectangle(Gdx.graphics.getWidth()/6+40, Gdx.graphics.getHeight()-ortografiaZ.getHeight(), ortografiaZ.getWidth(), ortografiaZ.getHeight());
				przejscieO = new Rectangle(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()-ortografiaO.getHeight(), ortografiaO.getWidth(), ortografiaO.getHeight());
				przejscieU = new Rectangle(Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()-ortografiaU.getHeight(), ortografiaU.getWidth(), ortografiaU.getHeight());
				przejscieH = new Rectangle(Gdx.graphics.getWidth()*2/3, Gdx.graphics.getHeight()-ortografiaH.getHeight(), ortografiaH.getWidth(), ortografiaH.getHeight());
				przejscieCH = new Rectangle(Gdx.graphics.getWidth()*5/6-20, Gdx.graphics.getHeight()-ortografiaCH.getHeight(), ortografiaCH.getWidth(), ortografiaCH.getHeight());
				sprawdzaniePrzejsciaOrtografia = new Vector3(Gdx.input.getX() , Gdx.input.getY(), 0);
				warunkiPrzejsciaOrtografia();
			}

			if(stanStrzalek==1){
				Zasady zasady = new Zasady();
				zasadyPisowniZ=zasady.żZasady();
				strzalkaPowrotuWektor = new Vector3(Gdx.input.getX() , Gdx.input.getY(), 0);
				sprawdzaniePrzejsciaOrtografia = new Vector3(Gdx.input.getX() , Gdx.input.getY(), 0);

				batch.begin();
				batch.draw(layoutMenu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				batch.draw(strzalkaPowrotu, 0, Gdx.graphics.getHeight()-strzalkaPowrotu.getHeight());
				batch.draw(ortografiaCH, Gdx.graphics.getWidth()*5/6-20, 0);
				batch.draw(ortografiaH, Gdx.graphics.getWidth()*2/3, 0);
				batch.draw(ortografiaO, Gdx.graphics.getWidth()/2, 0);
				batch.draw(ortografiaU, Gdx.graphics.getWidth()/3, 0);
				batch.draw(ortografiaZ, Gdx.graphics.getWidth()/6+40, 0);
				batch.draw(ortografiaRZ, 20, 0);
				font.draw(batch, zasadyPisowniZ, 30, Gdx.graphics.getHeight()-300, 1000,1000 , true);
				batch.end();

				warunkiPrzejsciaOrtografia();
			}

			if(stanStrzalek==2){
				Zasady zasady = new Zasady();
				zasadyPisowniU=zasady.uZasady();
				strzalkaPowrotuWektor = new Vector3(Gdx.input.getX() , Gdx.input.getY(), 0);
				sprawdzaniePrzejsciaOrtografia = new Vector3(Gdx.input.getX() , Gdx.input.getY(), 0);

				batch.begin();
				batch.draw(layoutMenu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				batch.draw(strzalkaPowrotu, 0, Gdx.graphics.getHeight()-strzalkaPowrotu.getHeight());
				batch.draw(ortografiaCH, Gdx.graphics.getWidth()*5/6-20, 0);
				batch.draw(ortografiaH, Gdx.graphics.getWidth()*2/3, 0);
				batch.draw(ortografiaO, Gdx.graphics.getWidth()/2, 0);
				batch.draw(ortografiaU, Gdx.graphics.getWidth()/3, 0);
				batch.draw(ortografiaZ, Gdx.graphics.getWidth()/6+40, 0);
				batch.draw(ortografiaRZ, 20, 0);
				font.draw(batch, zasadyPisowniU, 30, Gdx.graphics.getHeight()-300, 1000,1000 , true);
				batch.end();

				warunkiPrzejsciaOrtografia();

			}

			if(stanStrzalek==3) {
				Zasady zasady = new Zasady();
				zasadyPisowniO = zasady.óZasady();
				strzalkaPowrotuWektor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
				sprawdzaniePrzejsciaOrtografia = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

				batch.begin();
				batch.draw(layoutMenu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				batch.draw(strzalkaPowrotu, 0, Gdx.graphics.getHeight() - strzalkaPowrotu.getHeight());
				batch.draw(ortografiaCH, Gdx.graphics.getWidth() * 5 / 6 - 20, 0);
				batch.draw(ortografiaH, Gdx.graphics.getWidth() * 2 / 3, 0);
				batch.draw(ortografiaO, Gdx.graphics.getWidth() / 2, 0);
				batch.draw(ortografiaU, Gdx.graphics.getWidth() / 3, 0);
				batch.draw(ortografiaZ, Gdx.graphics.getWidth() / 6 + 40, 0);
				batch.draw(ortografiaRZ, 20, 0);
				font.draw(batch, zasadyPisowniO, 30, Gdx.graphics.getHeight() - 300, 1000, 1000, true);
				batch.end();

				warunkiPrzejsciaOrtografia();

			}

			if(stanStrzalek==4) {
				Zasady zasady = new Zasady();
				zasadyPisowniH = zasady.hZasady();
				strzalkaPowrotuWektor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
				sprawdzaniePrzejsciaOrtografia = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

				batch.begin();
				batch.draw(layoutMenu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				batch.draw(strzalkaPowrotu, 0, Gdx.graphics.getHeight() - strzalkaPowrotu.getHeight());
				batch.draw(ortografiaCH, Gdx.graphics.getWidth() * 5 / 6 - 20, 0);
				batch.draw(ortografiaH, Gdx.graphics.getWidth() * 2 / 3, 0);
				batch.draw(ortografiaO, Gdx.graphics.getWidth() / 2, 0);
				batch.draw(ortografiaU, Gdx.graphics.getWidth() / 3, 0);
				batch.draw(ortografiaZ, Gdx.graphics.getWidth() / 6 + 40, 0);
				batch.draw(ortografiaRZ, 20, 0);
				font.draw(batch, zasadyPisowniH, 30, Gdx.graphics.getHeight() - 300, 1000, 1000, true);
				batch.end();

				warunkiPrzejsciaOrtografia();

			}

			if(stanStrzalek==5) {
				Zasady zasady = new Zasady();
				zasadyPisowniCH = zasady.chZasady();
				strzalkaPowrotuWektor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
				sprawdzaniePrzejsciaOrtografia = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

				batch.begin();
				batch.draw(layoutMenu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				batch.draw(strzalkaPowrotu, 0, Gdx.graphics.getHeight() - strzalkaPowrotu.getHeight());
				batch.draw(ortografiaCH, Gdx.graphics.getWidth() * 5 / 6 - 20, 0);
				batch.draw(ortografiaH, Gdx.graphics.getWidth() * 2 / 3, 0);
				batch.draw(ortografiaO, Gdx.graphics.getWidth() / 2, 0);
				batch.draw(ortografiaU, Gdx.graphics.getWidth() / 3, 0);
				batch.draw(ortografiaZ, Gdx.graphics.getWidth() / 6 + 40, 0);
				batch.draw(ortografiaRZ, 20, 0);
				font.draw(batch, zasadyPisowniCH, 30, Gdx.graphics.getHeight() - 300, 1000, 1000, true);
				batch.end();

				warunkiPrzejsciaOrtografia();

			}
		}else if(statusGry==1){  //GRA W GOTOWOSCI

			menuGlowne = false;
			batch.begin();
			batch.draw(layoutGra, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			batch.draw(barierki, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			batch.draw(kulkaGracza, Gdx.graphics.getWidth()/2-kulkaGracza.getWidth()/2, Gdx.graphics.getHeight()/8-kulkaGracza.getHeight()/2);
			batch.end();
			if(Gdx.input.justTouched()) {
				statusGry=2;
			}
		}else if(statusGry==2){  //GRA DZIALA

			menuGlowne = false;



			//wyrazPoczatkowy(0);
			batch.begin();
			batch.draw(layoutGra, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

			//BELKI POZIOME
			if(licznikBelek < 15){
				licznikBelek++;
			}else{
				licznikBelek = 0;
				if(czestotliwoscOrtografi<30 && ortografiaZakonczona) {
					czestotliwoscOrtografi++;
					zadanieOrtograficzne=false;
					stworzBelke();
				}else{
					zadanieOrtograficzne = true;
					czestotliwoscOrtografi=0;
				}
			}
			belkaRectangle.clear();
			for(int i=0; i<belkiYs.size();i++){
				batch.draw(belka, belkiXs.get(i), belkiYs.get(i));
				belkiYs.set(i, belkiYs.get(i)-20);
				belkaRectangle.add(new Rectangle(belkiXs.get(i) + belka.getWidth()*2/11, belkiYs.get(i) + belka.getHeight()*45/93, belka.getWidth() - belka.getWidth()*4/11, belka.getHeight()- belka.getHeight()*83/93));
			}

			//METEORYT
			if(licznikMeteorytow < 100){
				licznikMeteorytow++;
			}else{
				licznikMeteorytow = 0;
				if(!zadanieOrtograficzne) {
					stworzMeteoryt();
				}
			}
			meteorytRectangle.clear();
			for(int i=0; i<meteorytYs.size();i++){
				batch.draw(meteoryt, meteorytXs.get(i), meteorytYs.get(i));
				meteorytYs.set(i, meteorytYs.get(i) - 70);
				meteorytRectangle.add(new Rectangle(meteorytXs.get(i) + meteoryt.getWidth() * 6 / 15, meteorytYs.get(i), meteoryt.getWidth() - meteoryt.getWidth() * 9 / 11, meteoryt.getHeight() - meteoryt.getHeight() * 83 / 93));
			}


			if(zadanieOrtograficzne && dlugoscTrwaniaOrtografi<300){
				dlugoscTrwaniaOrtografi++;
				ortografiaZakonczona = false;
				WyrazyOrtograficzne wywolajWyraz = new WyrazyOrtograficzne();
				if(dlugoscTrwaniaOrtografi==1){
				losowanko();
				}
				fontWyraz.draw(batch, wywolajWyraz.poczatekWyrazu(wylosujWyraz) + "_" + wywolajWyraz.koniecWyrazu(wylosujWyraz), 0, Gdx.graphics.getHeight() - 50, Gdx.graphics.getWidth(), Align.center, true);


				if(wywolajWyraz.srodekWyrazu(wylosujWyraz)=="u" || wywolajWyraz.srodekWyrazu(wylosujWyraz)=="ó" ){
					if(licznikU < 20){
						licznikU++;
					}else{
						licznikU = 0;
						if(dlugoscTrwaniaOrtografi<150) {
							stworzU();
							stworzO();

						}

					}

					for(int i=0; i<UYs.size();i++) {
						batch.draw(U, UXs.get(i), UYs.get(i));
						UYs.set(i, UYs.get(i) - 20);
					}
					for(int i=0; i<OYs.size();i++) {
						batch.draw(O, OXs.get(i), OYs.get(i));
						OYs.set(i, OYs.get(i) - 20);
					}

				}

				if(wywolajWyraz.srodekWyrazu(wylosujWyraz)=="ż" || wywolajWyraz.srodekWyrazu(wylosujWyraz)=="rz" ){
					if(licznikU < 20){
						licznikU++;
					}else{
						licznikU = 0;
						if(dlugoscTrwaniaOrtografi<150) {
							stworzZ();
							stworzRZ();
						}
					}


					for(int i=0; i<ZYs.size();i++) {
						batch.draw(Z, ZXs.get(i), ZYs.get(i));
						ZYs.set(i, ZYs.get(i) - 20);
					}
					for(int i=0; i<RZYs.size();i++) {
						batch.draw(RZ, RZXs.get(i), RZYs.get(i));
						RZYs.set(i, RZYs.get(i) - 20);
					}
				}

				if(wywolajWyraz.srodekWyrazu(wylosujWyraz)=="h" || wywolajWyraz.srodekWyrazu(wylosujWyraz)=="ch" ){
					if(licznikU < 20){
						licznikU++;
					}else{
						licznikU = 0;
						if(dlugoscTrwaniaOrtografi<150) {
							stworzH();
							stworzCH();
						}
					}

/**funkaa**/
					for(int i=0; i<HYs.size();i++) {
						batch.draw(H, HXs.get(i), HYs.get(i));
						HYs.set(i, HYs.get(i) - 20);
					}
					for(int i=0; i<CHYs.size();i++) {
						batch.draw(CH, CHXs.get(i), CHYs.get(i));
						CHYs.set(i, CHYs.get(i) - 20);
					}
				}




				if(wywolajWyraz.srodekWyrazu(wylosujWyraz)=="u") {

                    if (dlugoscTrwaniaOrtografi == 160) {
                        stworzBelkeOrtograficznaLewa();
						stworzBelkeCzerwona();
						stworzBelkeOrtograficznaPrawa();
                    }
					renderBelkiOrtograficznejLewej();
                    renderKolizjaBelkiCzerwonej();
                    renderBelkiOrtograficznejPrawej();
                    kolizjaBelkiOrtograficznejPrawej();
                }

				if(wywolajWyraz.srodekWyrazu(wylosujWyraz)=="ó") {

					if (dlugoscTrwaniaOrtografi == 160) {
						stworzBelkeOrtograficznaLewa();
						stworzBelkeCzerwona();
						stworzBelkeOrtograficznaPrawa();
					}
					renderBelkiOrtograficznejLewej();
					kolizjaBelkiOrtograficznejLewej();
					renderKolizjaBelkiCzerwonej();
					renderBelkiOrtograficznejPrawej();
				}

				if(wywolajWyraz.srodekWyrazu(wylosujWyraz)=="ż") {

					if (dlugoscTrwaniaOrtografi == 160) {
						stworzBelkeOrtograficznaLewa();
						stworzBelkeCzerwona();
						stworzBelkeOrtograficznaPrawa();
					}
					renderBelkiOrtograficznejLewej();
					renderKolizjaBelkiCzerwonej();
					renderBelkiOrtograficznejPrawej();
					kolizjaBelkiOrtograficznejPrawej();
				}

				if(wywolajWyraz.srodekWyrazu(wylosujWyraz)=="rz") {

					if (dlugoscTrwaniaOrtografi == 160) {
						stworzBelkeOrtograficznaLewa();
						stworzBelkeCzerwona();
						stworzBelkeOrtograficznaPrawa();
					}
					renderBelkiOrtograficznejLewej();
					kolizjaBelkiOrtograficznejLewej();
					renderKolizjaBelkiCzerwonej();
					renderBelkiOrtograficznejPrawej();
				}

				if(wywolajWyraz.srodekWyrazu(wylosujWyraz)=="h") {

					if (dlugoscTrwaniaOrtografi == 160) {
						stworzBelkeOrtograficznaLewa();
						stworzBelkeCzerwona();
						stworzBelkeOrtograficznaPrawa();
					}
					renderBelkiOrtograficznejLewej();
					renderKolizjaBelkiCzerwonej();
					renderBelkiOrtograficznejPrawej();
					kolizjaBelkiOrtograficznejPrawej();
				}

				if(wywolajWyraz.srodekWyrazu(wylosujWyraz)=="ch") {

					if (dlugoscTrwaniaOrtografi == 160) {
						stworzBelkeOrtograficznaLewa();
						stworzBelkeCzerwona();
						stworzBelkeOrtograficznaPrawa();
					}
					renderBelkiOrtograficznejLewej();
					kolizjaBelkiOrtograficznejLewej();
					renderKolizjaBelkiCzerwonej();
					renderBelkiOrtograficznejPrawej();
				}


			}else{
				dlugoscTrwaniaOrtografi=0;
				ortografiaZakonczona=true;
				zadanieOrtograficzne=false;
			}


			poruszanieKulka();
			batch.draw(barierki, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			batch.draw(kulkaGracza, pozycjaGraczaX + pozycjaGraczaX2 - pozycjaGraczaX1, pozycjaGraczaY + pozycjaGraczaY2 - pozycjaGraczaY1);

			kulkaRectangle = new Rectangle(pozycjaGraczaX + pozycjaGraczaX2 - pozycjaGraczaX1 + kulkaGracza.getWidth()/3, pozycjaGraczaY + pozycjaGraczaY2 - pozycjaGraczaY1 + kulkaGracza.getHeight()/3, kulkaGracza.getWidth() - kulkaGracza.getWidth()*5/8, kulkaGracza.getHeight() - kulkaGracza.getHeight()*5/8);
			barierkaLewaRectangle = new Rectangle(0, 0, barierki.getWidth()*23/290, barierki.getHeight());
			barierkaPrawaRectangle = new Rectangle(barierki.getWidth()*267/290, 0, Gdx.graphics.getWidth()*1/10, barierki.getHeight());

			if(Intersector.overlaps(kulkaRectangle, barierkaLewaRectangle)){
				statusGry=3;
			}
			if(Intersector.overlaps(kulkaRectangle, barierkaPrawaRectangle)){
				statusGry=3;
			}

			for(int i=0; i<meteorytRectangle.size(); i++){
				if(Intersector.overlaps(kulkaRectangle, meteorytRectangle.get(i))){
					statusGry=3;
				}
			}

			for(int i=0; i<belkaRectangle.size(); i++){
				if(Intersector.overlaps(kulkaRectangle, belkaRectangle.get(i))){
					statusGry=3;
				}
			}

			if(licznikWyniku<10){
				licznikWyniku++;
			}else {
				licznikWyniku=0;
				wynik++;
			}
			wynikNapis = Integer.toString(wynik);
			font.draw(batch, String.valueOf(wynik), 100, 100);
			batch.end();

			strzalkaPowrotuWektor = new Vector3(Gdx.input.getX() , Gdx.input.getY(), 0);                                     // Przypisanie współrzędnych kliknięcia do Strzałki powrotu
			strzalkaPowrotuPole = new Rectangle(0,0,208,221);                                       		// tworzenie prostokątnego pola o wymiarach Strzałki powrotnej

		}
		else if(statusGry==3){  //KONIEC GRY
			batch.begin();
			batch.draw(layoutGra, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			fontWyraz.draw(batch, "\nKoniec Gry\n\nTwój wynik:\n", 30, Gdx.graphics.getHeight() - 300, 1000, Align.center, true);
			fontKoncowy.draw(batch, "\n\n\n\n"+wynikNapis, 30, Gdx.graphics.getHeight() - 300, 1000, Align.center, true);
			font.draw(batch, "Dotknij ekranu by zagrac ponownie", 30, Gdx.graphics.getHeight()/4, 1000, Align.center, true);
			batch.draw(strzalkaPowrotu, 0, Gdx.graphics.getHeight() - 221);
			batch.end();

			strzalkaPowrotuWektor = new Vector3(Gdx.input.getX() , Gdx.input.getY(), 0);                                     // Przypisanie współrzędnych kliknięcia do Strzałki powrotu
			strzalkaPowrotuPole = new Rectangle(0,0,strzalkaPowrotu.getWidth(),strzalkaPowrotu.getHeight());

			if (strzalkaPowrotuPole.contains(strzalkaPowrotuWektor.x, strzalkaPowrotuWektor.y) && menuGlowne == false)          // Sprawdzenie czy współrzędne zawierają sie w prostokątnym polu
			{
				menuGlowne = true;																								// Powrót co menu głównego
				statusGry=0;
				nowaGraWektor.x = 0;																							// zerowanie pola nowaGra, nie chcemy go w if wyzej bo pole nowaGra ma zawierać wcześniej klikniete dane tak długo az nie bedziemy chcieli wyjsc
				nowaGraWektor.y = 0;

				wynik=0;
				belkiXs.clear();
				belkiYs.clear();
				belkaRectangle.clear();
				licznikBelek=0;
				meteorytXs.clear();
				meteorytYs.clear();
				meteorytRectangle.clear();
				licznikMeteorytow=0;
				pozycjaGraczaX = Gdx.graphics.getWidth() / 2 - kulkaGracza.getWidth() / 2;
				pozycjaGraczaY = Gdx.graphics.getHeight() / 8 - kulkaGracza.getHeight() / 2;
				pozycjaGraczaX1 = 0;
				pozycjaGraczaX2 = 0;
				pozycjaGraczaY1 = 0;
				pozycjaGraczaY2 = 0;
				ekranStartowy =true;
				czestotliwoscOrtografi=0;
				zadanieOrtograficzne=false;
				dlugoscTrwaniaOrtografi=0;
				ortografiaZakonczona=true;
				licznikU=0;
				belkiCzerwoneXs.clear();
				belkiCzerwoneYs.clear();
				belkiOrtograficzneLeweXs.clear();
				belkiOrtograficzneLeweYs.clear();
				belkiOrtograficznePraweXs.clear();
				belkiOrtograficznePraweYs.clear();
				ZXs.clear();
				ZYs.clear();
				RZXs.clear();
				RZYs.clear();
				HXs.clear();
				HYs.clear();
				CHYs.clear();
				CHXs.clear();
				UXs.clear();
				UYs.clear();
				OXs.clear();
				OYs.clear();
				grajOdNowa = false;
				statusGry=0;

			}

			if(Gdx.input.justTouched() && grajOdNowa){

				wynik=0;
				belkiXs.clear();
				belkiYs.clear();
				belkaRectangle.clear();
				licznikBelek=0;
				meteorytXs.clear();
				meteorytYs.clear();
				meteorytRectangle.clear();
				licznikMeteorytow=0;
				pozycjaGraczaX = Gdx.graphics.getWidth() / 2 - kulkaGracza.getWidth() / 2;
				pozycjaGraczaY = Gdx.graphics.getHeight() / 8 - kulkaGracza.getHeight() / 2;
				pozycjaGraczaX1 = 0;
				pozycjaGraczaX2 = 0;
				pozycjaGraczaY1 = 0;
				pozycjaGraczaY2 = 0;
				ekranStartowy =true;
				czestotliwoscOrtografi=0;
				zadanieOrtograficzne=false;
				dlugoscTrwaniaOrtografi=0;
				ortografiaZakonczona=true;
				licznikU=0;
				belkiCzerwoneXs.clear();
				belkiCzerwoneYs.clear();
				belkiOrtograficzneLeweXs.clear();
				belkiOrtograficzneLeweYs.clear();
				belkiOrtograficznePraweXs.clear();
				belkiOrtograficznePraweYs.clear();
				ZXs.clear();
				ZYs.clear();
				RZXs.clear();
				RZYs.clear();
				HXs.clear();
				HYs.clear();
				CHYs.clear();
				CHXs.clear();
				UXs.clear();
				UYs.clear();
				OXs.clear();
				OYs.clear();
				statusGry=1;

			}


		}



	}


	public void dispose (){

		batch.dispose();
		font.dispose();
		fontWyraz.dispose();
		fontKoncowy.dispose();
		layoutMenu.dispose();
		nowaGra.dispose();
		poziomy.dispose();
		zasady.dispose();
		strzalkaPowrotu.dispose();
	}
}
