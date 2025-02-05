package main;

import java.util.ArrayList;
import java.util.Arrays;

import obiecte.Diagnostic;
import obiecte.ParteCorp;

import repository.ParteCorpRepository;
public class PopulareDiagnostice {
	/**
	 * Populare tabel diagnostice
	 * @param args
	 */
	public static void main(String[] args) {
		
		//ochi
		Diagnostic conjunctivita = new Diagnostic("Conjunctivita", new ArrayList<>(Arrays.asList("Usturime", "Roseata")), "Nu ati avut o igiena oculara corespunzatoare", "Clatire ochi - Administrare picaturi farmaceutice - Evitarea atingerii", false);
		Diagnostic alergieAnimale = new Diagnostic("AlergieAnimal", new ArrayList<>(Arrays.asList("Usturime", "Roseata")), "Aveti o posibila alergie la animale", "Evitarea contactului cu animalele - Dezinfectare totala", false);
		Diagnostic iritatieOchi = new Diagnostic("Iritatie Ochi", new ArrayList<>(Arrays.asList("Usturime", "Sensibilitate lumina")), "Expunere la praf sau substante iritante", "Clatiri cu apa - Aplicare picaturi antiinflamatorii", false);
		Diagnostic infectieOculara = new Diagnostic("Infectie Oculara", new ArrayList<>(Arrays.asList("Usturime", "Vedere incetosata")), "Posibila infectie bacteriana sau virala", "Tratament cu antibiotice - Clatiri oculare", true);
		ArrayList<Diagnostic> diagnosticeOchi = new ArrayList<>(Arrays.asList(conjunctivita,alergieAnimale,iritatieOchi,infectieOculara));
		ParteCorp Ochi = new ParteCorp("Ochi",diagnosticeOchi);
		
		//urechi
		Diagnostic otita = new Diagnostic("Otita", new ArrayList<>(Arrays.asList("Durere")), "Ati contactat o bacterie", "Administrare picaturi farmaceutice - Evitare zone cu umiditate crescuta", true);
		Diagnostic dop = new Diagnostic("Dop de ceara", new ArrayList<>(Arrays.asList("Durere", "Mancarime")), "Nu ati avut o igiena a urechilor corespunzatoare", "Administrare picaturi farmaceutice - Vizita Doctor ORL", false);
		Diagnostic infectieUreche = new Diagnostic("Infectie Ureche", new ArrayList<>(Arrays.asList("Durere severa", "Mancarime", "Febra")), "Posibila infectie bacteriana", "Antibiotice - Vizita la medic ORL", true);
		Diagnostic iritatieUreche = new Diagnostic("Iritatie Ureche", new ArrayList<>(Arrays.asList("Mancarime", "Uscaciune")), "Expunere la substante iritante sau apa", "Clatire cu solutie salina - Aplicare unguente", false);
		ArrayList<Diagnostic> diagnosticeUrechi = new ArrayList<>(Arrays.asList(otita,dop,infectieUreche,iritatieUreche));
		ParteCorp Urechi = new ParteCorp("Urechi",diagnosticeUrechi);
		
		//gura
		Diagnostic gingivita = new Diagnostic("Gingivita", new ArrayList<>(Arrays.asList("Sangerare gingii", "Usturime")), "Nu ati avut o igiena orala corespunzatoare", "Periaj regulat - Folosirea apei de gura - Vizita la dentist", false);
		Diagnostic stomatita = new Diagnostic("Stomatita", new ArrayList<>(Arrays.asList("Durere gura", "Uscaciune gura")), "Posibila infectie sau iritare a mucoasei bucale", "Clatiri bucale antiseptice - Evitarea alimentelor iritante", false);
		Diagnostic abceseGura = new Diagnostic("Abces Gura", new ArrayList<>(Arrays.asList("Durere intensa", "Umflatura gura")), "Posibila infectie bacteriana", "Tratament cu antibiotice - Drenaj chirurgical", true);
		Diagnostic durereDentara = new Diagnostic("Durere Dentara", new ArrayList<>(Arrays.asList("Durere", "Sensibilitate la rece")), "Posibila carie dentara sau infectie", "Vizita la dentist - Tratament cu antibiotice", false);
		ArrayList<Diagnostic> diagnosticeGura = new ArrayList<>(Arrays.asList(gingivita,stomatita,abceseGura,durereDentara));
		ParteCorp Gura = new ParteCorp("Gura",diagnosticeGura);
		
		//gat
		Diagnostic faringita = new Diagnostic("Faringita", new ArrayList<>(Arrays.asList("Durere gat", "Dificultate inghitire")), "Posibila infectie virala sau bacteriana", "Odihna - Clatiri cu solutii antiseptice - Antibiotice daca este necesar", false);
		Diagnostic laringita = new Diagnostic("Laringita", new ArrayList<>(Arrays.asList("Raguseala", "Durere gat")), "Iritatie sau infectie a corzilor vocale", "Odihna vocala - Inhalatii de aburi - Evitarea fumatului", false);
		Diagnostic amigdalita = new Diagnostic("Amigdalita", new ArrayList<>(Arrays.asList("Durere in gat", "Febra")), "Posibila infectie bacteriana a amigdalelor", "Tratament cu antibiotice - Odihna - Clatiri cu solutii antiseptice", true);
		Diagnostic durereGat = new Diagnostic("Durere Gat", new ArrayList<>(Arrays.asList("Durere inghitire", "Inflamatie")), "Posibila infectie virala", "Odihna - Clatiri cu solutii antiseptice - Odihna vocala", false);
		ArrayList<Diagnostic> diagnosticeGat = new ArrayList<>(Arrays.asList(faringita,laringita,amigdalita,durereGat));
		ParteCorp Gat = new ParteCorp("Gat",diagnosticeGat);
		
		//mana
		Diagnostic entorsaMana = new Diagnostic("Entorsa Mana", new ArrayList<>(Arrays.asList("Durere", "Umflare")), "Leziune provocata de intinderea ligamentelor", "Aplicare gheata - Imobilizare - Consult medical daca este necesar", false);
		Diagnostic fracturaMana = new Diagnostic("Fractura Mana", new ArrayList<>(Arrays.asList("Durere severa", "Umflatura", "Dificultate miscare")), "Leziune osoasa", "Imobilizare - Radiografie - Tratament chirurgical in caz de fractura deschisa", true);
		Diagnostic artritaMana = new Diagnostic("Artrita Mana", new ArrayList<>(Arrays.asList("Durere articulatie", "Rigiditate")), "Inflamatie a articulatiilor mainii", "Tratament antiinflamator - Fizioterapie", false);
		Diagnostic febraMusuclaraMana = new Diagnostic("Febra musculara Mana", new ArrayList<>(Arrays.asList("Durere acuta", "Dificultate miscare")), "Posibila leziune usoara sau oboseala musculara", "Odihna - Aplicare gheata - Masaj", false);
		ArrayList<Diagnostic> diagnosticeMana = new ArrayList<>(Arrays.asList(entorsaMana,fracturaMana,artritaMana,febraMusuclaraMana));
		ParteCorp Mana = new ParteCorp("Mana",diagnosticeMana);
		
		//picior
		Diagnostic entorsaPicior = new Diagnostic("Entorsa Picior", new ArrayList<>(Arrays.asList("Durere", "Umflare")), "Leziune ligamentara cauzata de rasucire sau accident", "Aplicare gheata - Imobilizare - Odihna", false);
		Diagnostic fracturaPicior = new Diagnostic("Fractura Picior", new ArrayList<>(Arrays.asList("Durere severa", "Umflatura", "Deformare picior")), "Fractura a unui os al piciorului", "Imobilizare - Radiografie - Tratament chirurgical daca este necesar", true);
		Diagnostic tendinitaPicior = new Diagnostic("Tendinita Picior", new ArrayList<>(Arrays.asList("Durere tendon", "Umflare")), "Inflamatie a tendonului", "Odihna - Fizioterapie - Tratament antiinflamator", false);
		Diagnostic febraMuscularaPicior = new Diagnostic("Febra musculara Picior", new ArrayList<>(Arrays.asList("Durere usoara", "Sensibilitate")), "Posibila oboseala sau disconfort muscular", "Odihna - Masaj - Aplicare gheata", false);
		ArrayList<Diagnostic> diagnosticePicior = new ArrayList<>(Arrays.asList(entorsaPicior,fracturaPicior,tendinitaPicior,febraMuscularaPicior));
		ParteCorp Picior = new ParteCorp("Picior",diagnosticePicior);
		
		//piept
		Diagnostic bronsita = new Diagnostic("Bronsita", new ArrayList<>(Arrays.asList("Tuse", "Dificultate respiratorie")), "Inflamatie a bronhiilor, adesea cauzata de o infectie virala", "Odihna - Medicamente pentru calmarea tusei - Inhalatii", false);
		Diagnostic pleurezie = new Diagnostic("Pleurezie", new ArrayList<>(Arrays.asList("Durere toracica", "Dificultate respiratorie")), "Inflamatie a pleurei (membrana care inveleste plamanii)", "Tratament antiinflamator - Antibiotice in caz de infectie bacteriana", true);
		Diagnostic infarct = new Diagnostic("Infarct Miocardic", new ArrayList<>(Arrays.asList("Durere toracica", "Transpiratie excesiva", "Dificultate respiratorie")), "Blocaj al unui vas de sange care duce la o parte a inimii", "Tratament de urgenta - Spitalizare imediata - Medicamente pentru dizolvarea cheagurilor", true);
		Diagnostic durerePiept = new Diagnostic("Durere Piept", new ArrayList<>(Arrays.asList("Durere toracica", "Presiune")), "Posibila disconfort din cauza stresului sau a unei probleme musculo-scheletale", "Odihna - Consult medical pentru investigatii suplimentare", false);
		ArrayList<Diagnostic> diagnosticePiept = new ArrayList<>(Arrays.asList(bronsita,pleurezie,infarct,durerePiept));
		ParteCorp Piept = new ParteCorp("Piept",diagnosticePiept);
		
		//abdomen
		Diagnostic apendicita = new Diagnostic("Apendicita", new ArrayList<>(Arrays.asList("Durere abdomen", "Febra")), "Inflamatie a apendicelui, care poate necesita interventie chirurgicala", "Tratament chirurgical - Apendicectomie", true);
		Diagnostic colecistita = new Diagnostic("Colecistita", new ArrayList<>(Arrays.asList("Durere bila", "Greata", "Febra")), "Inflamatie a vezicii biliare", "Tratament medicamentos - Posibilitate de interventie chirurgicala", false);
		Diagnostic gastrita = new Diagnostic("Gastrita", new ArrayList<>(Arrays.asList("Durere stomac", "Greata")), "Inflamatie a mucoasei stomacului, adesea cauzata de infectii sau stres", "Tratament cu medicamente pentru reducerea aciditatii - Dieta", false);
		Diagnostic indigestie = new Diagnostic("Indigestie", new ArrayList<>(Arrays.asList("Durere stomac", "Balonare", "Greata")), "Consumul de alimente greu de digerat", "Evitarea alimentelor grase - Medicamente pentru digestie", false);
		ArrayList<Diagnostic> diagnosticeAbdomen = new ArrayList<>(Arrays.asList(apendicita,colecistita,gastrita,indigestie));
		ParteCorp Abdomen = new ParteCorp("Abdomen",diagnosticeAbdomen);
	
	
		boolean result1 = ParteCorpRepository.addOrUpdateParteCorp(Ochi);
		System.out.println("adaugare parte corp " + result1);
		
		boolean result2 = ParteCorpRepository.addOrUpdateParteCorp(Gura);
		System.out.println("adaugare parte corp " + result2);


		boolean result3 = ParteCorpRepository.addOrUpdateParteCorp(Urechi);
		System.out.println("adaugare parte corp " + result3);
		
		boolean result4 = ParteCorpRepository.addOrUpdateParteCorp(Gat);
		System.out.println("adaugare parte corp " + result4);
		
		boolean result5 = ParteCorpRepository.addOrUpdateParteCorp(Piept);
		System.out.println("adaugare parte corp " + result5);
		
		boolean result6 = ParteCorpRepository.addOrUpdateParteCorp(Abdomen);
		System.out.println("adaugare parte corp " + result6);
		
		boolean result7 = ParteCorpRepository.addOrUpdateParteCorp(Mana);
		System.out.println("adaugare parte corp " + result7);
		
		boolean result8 = ParteCorpRepository.addOrUpdateParteCorp(Picior);
		System.out.println("adaugare parte corp " + result8);
	
	
	}

	

}
