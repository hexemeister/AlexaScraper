import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Principal {

	public static void main(String[] args) {
		
		List<String> listaDeLinks = new ArrayList<>(); //cria lista de links

		try {
			for (int i = 0; i < 20; i++) { //intera pelas 20 paginas do Alexa
				String url = "http://www.alexa.com/topsites/countries;" + i + "/BR"; //url do alexa
				Document doc = Jsoup.connect(url).get(); // conecta e faz parse da pagina
				if (i == 0) 							// titulo da pagina, so pra fica bonitinho
					System.out.println(doc.title() + "\n");
				Elements links = doc.select("p.desc-paragraph"); // seleciona todos os elementos p que possuem classe desc-paragraph

				for (Element element : links) {
					listaDeLinks.add(element.text()); // adiciona na lista
				}
			}

			System.out.println("Quantidade de links: " + listaDeLinks.size()); // Aviso de quantos achou
			

			String[] array = new String[listaDeLinks.size()]; // Array pra exportar pra csv
			array = listaDeLinks.toArray(array); // transforma list para array
			StringBuilder sb = new StringBuilder(); // stringbuilder é mais rapido
			int i = 0;
			for (String element : array) { // contruindo o csv
				sb.append(element);
				sb.append(",\n");
				System.out.println(++i + " " + element);
			}
			
			// grava e fecha o arquivo
			FileWriter file = new FileWriter("top500SitesAlexa.csv");
			file.write(sb.toString());
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}