import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ACheckerScrapper {

	/*
	 * ------WebKitFormBoundaryWDf7JndXBGc75B9H Content-Disposition: form-data;
	 * name="uri"
	 * 
	 * www.google.com.br ------WebKitFormBoundaryWDf7JndXBGc75B9H
	 * Content-Disposition: form-data; name="validate_uri"
	 * 
	 * Check It ------WebKitFormBoundaryWDf7JndXBGc75B9H Content-Disposition:
	 * form-data; name="MAX_FILE_SIZE"
	 * 
	 * 52428800 ------WebKitFormBoundaryWDf7JndXBGc75B9H Content-Disposition:
	 * form-data; name="uploadfile"; filename="" Content-Type:
	 * application/octet-stream
	 * 
	 * 
	 * ------WebKitFormBoundaryWDf7JndXBGc75B9H Content-Disposition: form-data;
	 * name="pastehtml"
	 * 
	 * 
	 * ------WebKitFormBoundaryWDf7JndXBGc75B9H Content-Disposition: form-data;
	 * name="radio_gid[]"
	 * 
	 * 8 ------WebKitFormBoundaryWDf7JndXBGc75B9H Content-Disposition:
	 * form-data; name="checkbox_gid[]"
	 * 
	 * 8 ------WebKitFormBoundaryWDf7JndXBGc75B9H Content-Disposition:
	 * form-data; name="rpt_format"
	 * 
	 * 1 ------WebKitFormBoundaryWDf7JndXBGc75B9H--
	 */

	public static void main(String[] args) {

		final String listaDeLinks = "Google.com.br,Google.com,Youtube.com,Facebook.com,Globo.com,Uol.com.br,"
				+ "Live.com,Mercadolivre.com.br,Blogspot.com.br,Yahoo.com,Blastingnews.com,Wikipedia.org,Whatsapp.com,"
				+ "Instagram.com,Twitter.com,Olx.com.br,Linkedin.com,Msn.com,Abril.com.br,Blogger.com,Curapelanatureza.com.br,"
				+ "Wordpress.com,Netflix.com,Americanas.com.br,Popads.net,Caixa.gov.br,Xvideos.com,Folha.uol.com.br,Onclickads.net,"
				+ "Aliexpress.com,Techtudo.com.br,Fatosdesconhecidos.com.br,Correios.com.br,Stackoverflow.com,Microsoft.com,"
				+ "Sp.gov.br,Pinterest.com,Adf.ly,Uptodown.com,Amazon.com,Itau.com.br,T.co,Thewhizmarketing.com,Submarino.com.br,"
				+ "Github.com,Bol.uol.com.br,Tecmundo.com.br,Paypal.com,Tumblr.com,Misteriosdomundo.org,Blogspot.com,"
				+ "Fazenda.gov.br,Bradesco.com.br,Reclameaqui.com.br,Terra.com.br,Bb.com.br,Ig.com.br,Esporte.uol.com.br,"
				+ "Bing.com,Googleusercontent.com,Metropoles.com,Walmart.com.br,Baixaki.com.br,Estadao.com.br,Noticias.uol.com.br,"
				+ "Buscape.com.br,Apple.com,Netshoes.com.br,Vagalume.com.br,Trello.com,Dropbox.com,Bp.blogspot.com,Bancobrasil.com.br,"
				+ "4shared.com,Bet365.com,R7.com,Letras.mus.br,Casasbahia.com.br,Clicrbs.com.br,Imgur.com,Jusbrasil.com.br,Santander.com.br,"
				+ "Extra.com.br,Outbrain.com,Vivo.com.br,Reddit.com,Santandernet.com.br,Office.com,Pornhub.com,Banco.bradesco,Amazonaws.com,"
				+ "Pagseguro.uol.com.br,Mega.nz,Adobe.com,Xhamster.com,Adorocinema.com,Kabum.com.br,Mg.gov.br,Catracalivre.com.br,"
				+ "Oantagonista.com,Blogosfera.uol.com.br,Ero-advertising.com,Media-box.co,Freepik.com,Ebay.com,Wordpress.org,Slideshare.net,"
				+ "Mediafire.com,Campograndenews.com.br,Godaddy.com,Saraiva.com.br,Booking.com,Magazineluiza.com.br,Thepiratebay.org,"
				+ "Shoptime.com.br,Decolar.com,Iwanttodeliver.com,Popcash.net,Imdb.com,Vagas.com.br,Oi.com.br,Pr.gov.br,Vimeo.com,"
				+ "Microsoftonline.com,Thewhizproducts.com,Dafiti.com.br,Adbooth.com,Savefrom.net,Hao123.com,Mercadolivre.com,Elo7.com.br,"
				+ "Usp.br,Pontofrio.com.br,Tse.jus.br,Inep.gov.br,Amazon.com.br,Acesso.uol.com.br,Cifraclub.com.br,Locaweb.com.br,"
				+ "Infusionsoft.com,Txxx.com,Tripadvisor.com.br,Infomoney.com.br,R7mediar.com,Mec.gov.br,Olhardigital.uol.com.br,"
				+ "Wix.com,Tvefamosos.uol.com.br,Espn.uol.com.br,Giphy.com,Leg.br,Neobux.com,Zendesk.com,Toptestes.com,Economia.uol.com.br,"
				+ "Webmotors.com.br,Ebc.com.br,Bmail.uol.com.br,Ask.com,Wikia.com,Climatempo.com.br,Comandofilmes.net,Eleicoes.uol.com.br,"
				+ "Zoom.com.br,Buzzfeed.com,Files.wordpress.com,W3schools.com,Pciconcursos.com.br,Wikihow.com,Spotify.com,Tim.com.br,"
				+ "Shutterstock.com,Tudocelular.com,Upornia.com,Planalto.gov.br,Vivareal.com.br,Lomadee.com,Badoo.com,Taboola.com,Ufrgs.br,"
				+ "Clickjogos.com.br,Clixsense.com,Mail.uol.com.br,Skype.com,Hotmart.com,Fbcdn.net,Doubleclick.net,Superanimes.com,"
				+ "Doutissima.com.br,Ne10.uol.com.br,Latam.com,Zapimoveis.com.br,Brasilescola.uol.com.br,Fastpokemap.se,Hardware.com.br,"
				+ "Twitch.tv,Ricardoeletro.com.br,Voegol.com.br,Grancursosonline.com.br,Github.io,Unb.br,Netcombo.com.br,Terraclicks.com,"
				+ "Sinonimos.com.br,Dicio.com.br,Eleicoes2016.com.br,Addthis.com,Soundcloud.com,Themeforest.net,Steampowered.com,Animeai.net,"
				+ "Infojobs.com.br,Wetransfer.com,Mailchimp.com,Legendas.tv,Minhavida.com.br,Claro.com.br,Alibaba.com,Redtube.com,Suamusica.com.br,"
				+ "Slack.com,Mercadopago.com,Myway.com,Peixeurbano.com.br,Gearbest.com,Hilltopads.net,Bbc.com,Globaloffers.link,Cloudify.cc,"
				+ "Ouo.io,Scribd.com,Feedly.com,Wixsite.com,Stackexchange.com,Omelete.uol.com.br,Filmesonlinegratis.net,Filmesonlinex.net,"
				+ "Band.uol.com.br,Sh.st,Leadzupc.com,Pensador.uol.com.br,Batepapo.uol.com.br,Rj.gov.br,Torrentdosfilmes.com,Passeidireto.com,"
				+ "Skoob.com.br,Lance.com.br,Dicionarioinformal.com.br,Leagueoflegends.com,Clicksgear.com,Uber.com,Mozilla.org,Registro.br,"
				+ "Sourceforge.net,Scielo.br,Cloudfront.net,Dell.com,Archive.org,Deviantart.com,Filmeseseriesonline.net,Onclickpredictiv.com,"
				+ "Pinimg.com,Kanui.com.br,Bitly.com,Zippyshare.com,Consultaremedios.com.br,Thepiratefilmes.com,Tudogostoso.com.br,Infoescola.com,"
				+ "Vivaolinux.com.br,Nametests.com,Voeazul.com.br,Webmail-seguro.com.br,Hostinger.com.br,Shopfacil.com.br,Brasil247.com,Mp.br,"
				+ "Tradeadexchange.com,Tjsp.jus.br,Clubedohardware.com.br,Gazetadopovo.com.br,Megafilmesonline.net,Aovivonatv.com,Medium.com,"
				+ "Chaturbate.com,Reimageplus.com,Guiamais.com.br,Gizmodo.uol.com.br,Webinarjam.net,Hclips.com,Redetv.uol.com.br,Megacurioso.com.br,"
				+ "Quora.com,Vk.com,Adexchangeprediction.com,Parsexual.net,Behance.net,Palcomp3.com,9gag.com,Salesforce.com,Rs.gov.br,Catho.com.br,"
				+ "Sambaporno.com,Unicamp.br,Filmesonlinehd1.com,Canva.com,Airbnb.com.br,Messenger.com,Flickr.com,Sapo.pt,Ahnegao.com.br,Exoclick.com,"
				+ "Bibliaonline.com.br,Brainly.com.br,Doublepimp.com,Netvasco.com.br,Hstpnetwork.com,Tattoodo.com,Noticiasdatv.uol.com.br,Sexlog.com,"
				+ "Dailymotion.com,Media.tumblr.com,Lelivros.me,Icarros.com.br,Ba.gov.br,Pixabay.com,Valor.com.br,Leroymerlin.com.br,"
				+ "Virgula.uol.com.br,Diariodelweb.it,Digitalocean.com,Disqus.com,Tvplusnewtab.com,Natura.net,Leadlovers.com,"
				+ "Adnetworkperformance.com,Estilo.uol.com.br,Cameraprive.com,Cam4.com,Estacio.br,Bitbucket.org,Newtab-media.com,Unesp.br,"
				+ "Sine.com.br,Vice.com,Imasters.com.br,Diarioinenglish.com,Meaww.com,Elpais.com,Universal.org,Trabalhosfeitos.com,Goo.gl,Sc.gov.br,"
				+ "Telegram.org,Istoe.com.br,Moip.com.br,Eduzz.com,Ce.gov.br,Hinode.com.br,Ufsc.br,Publipt.com,Incrivel.club,Mediawhirl.net,"
				+ "Minhateca.com.br,Cnpq.br,Vivalocal.com,Zoho.com,Icloud.com,Centauro.com.br,Quizzstar.com,Ign.com,Seriesonlinehd.org,"
				+ "Significados.com.br,4dsply.com,Fgv.br,Mercadopago.com.br,Zlx.com.br,Youtube-mp3.org,Tecnoblog.net,Polemicaparaiba.com.br,"
				+ "Pb.gov.br,Adrenaline.uol.com.br,Hardmob.com.br,Apontador.com.br,Pe.gov.br,Ebah.com.br,Ytimg.com,Vix.com,Pornocarioca.com,"
				+ "Indeed.com.br,Enjoei.com.br,Correiobraziliense.com.br,Pt.wix.com,Canaltech.com.br,Naosalvo.com.br,Evernote.com,Df.gov.br,"
				+ "Prnt.sc,Codecanyon.net,Clipconverter.cc,Lojaintegrada.com.br,Xpg.uol.com.br,Openload.co,Jogos.uol.com.br,Devmedia.com.br,"
				+ "Samsung.com,Videodownloadconverter.com,Portalcorreio.com.br,Em.com.br,Zopim.com,Speedtest.net,Folha.com.br,Correio24horas.com.br,"
				+ "Force.com,Php.net,Betfair.com,Ccm.net,Senac.br,Egrana.com.br,Onlinevideoconverter.com,Timbeta.com.br,Colaboraread.com.br,"
				+ "Cityadspix.com,Bongacams.com,Oqvestir.com.br,Smiles.com.br,Estantevirtual.com.br,Merkur-slots.com,Tuasaude.com,Oasgames.com,"
				+ "Imovelweb.com.br,Assistindoseriesonline.net,Udemy.com,Soubarato.com.br,Issuu.com,Cnet.com,Beeg.com,Maispb.com.br,"
				+ "Minhaconexao.com.br,Boafoda.com,Dafont.com,Softonic.com.br,Legiaodosherois.uol.com.br,Zattini.com.br,Mais.uol.com.br,"
				+ "Revistaforum.com.br,Asana.com,Mt.gov.br,Portalinteressante.com,Telelistas.net,Twimg.com,Lojasrenner.com.br,Dfsites.com.br,"
				+ "Diariodosertao.com.br,Hostgator.com.br,Wikimedia.org,Groupon.com.br,Empiricus.com.br,Ampclicks.com,Avg.com,Otempo.com.br,"
				+ "Educacao.uol.com.br,Samplicio.us,Musica.uol.com.br,Melhoresdestinos.com.br,Uolhost.uol.com.br,Omb100.com,Searchmgr.com,"
				+ "Bcash.com.br,Java.com,Dx.com,Caras.uol.com.br,Bling.com.br,Xvideosporno.blog.br,Sebrae.com.br,Blackboard.com,Email.uol.com.br,"
				+ "Shoowplay.tk,Rdstation.com.br,Isanalyze.com,Esy.es,Ufmg.br,Nanoadexchange.com,Carrefour.com.br,Linguee.com.br,Kalunga.com.br,"
				+ "Hp.com,Roblox.com,Steamcommunity.com,Mobly.com.br,Livrariacultura.com.br,Ashleymadison.com,Duolingo.com,Spotscenered.info,"
				+ "Posthaus.com.br,Ozock.com,Linkshrink.net,Clickpb.com.br,Naointendo.com.br,Youporn.com".toLowerCase();
		
		int posicao = 1;
//		final String link = "Correios.com.br";
		String[] arrayDeLinks = listaDeLinks.split(",");
		
		for (String link : arrayDeLinks) {
			
			Document document = validaLinkWCGA2(link);
			
			String tituloValidador = tituloValidador(document);
			String linkValidado = linkValidado(document);
			String qtErros = qtErrorsLink(document).toString();
			String qtLikelyErrors = qtLikelyErrorsLink(document).toString();
			String qtPotentialErrors = qtPotentialErrorsLink(document).toString();
			String qtErrosA = qtErrosLvlALink(document).toString();
			String qtErrosAA = qtErrosLvlAALink(document).toString();
			String qtErrosAAA = qtErrosLvlAAALink(document).toString();
			String qtOcorrenciasA = QtOcorrenciasLvlA(document).toString();
			String qtOcorrenciasAA = QtOcorrenciasLvlAA(document).toString();
			String qtOcorrenciasAAA = QtOcorrenciasLvlAAA(document).toString();
			
			String totalDeErrosPotenciais = new Integer(qtLikelyErrors + qtPotentialErrors).toString();
			
			// Controle pelo Console
			
			System.out.println("Titulo da pagina: " + tituloValidador + "\n");
			System.out.println("Accessibility Review (Guidelines: WCAG 2.0 Level AAA) "
					+ linkValidado(document) + "\n");
			System.out.println("Classificacao: " + posicao + "\n");
			System.out.println("Numero de erros: " + qtErros);
			System.out.println("Numero de likely: " + qtLikelyErrors);
			System.out.println("Numero de potential: " + qtPotentialErrors);
			System.out.println("Qtd erros nivel A: " + qtErrosA);
			System.out.println("Qtd erros nivel AA: " + qtErrosAA );
			System.out.println("Qtd erros nivel AAA: " + qtErrosAAA);
			System.out.println("Qtd ocorrencias nivel A: " + qtOcorrenciasA );
			System.out.println("Qtd ocorrencias nivel AA: " + qtOcorrenciasAA);
			System.out.println("Qtd ocorrencias nivel AAA: " + qtOcorrenciasAAA);
			String titulo = "Classificação, Site, A, AA,AAA, OcorrenciasA, OcorrenciasAA, OcorrenciasAAA, Potencial";
			
			
			StringBuffer sb = new StringBuffer(titulo);
			sb.append(Integer.toString(posicao)).append(",").append(linkValidado).append(",").append(qtErrosA).append(",")
			.append(qtErrosAA).append(",").append(qtErrosAAA).append(",").append(qtOcorrenciasA).append(",").append(qtOcorrenciasAA)
			.append(",").append(qtOcorrenciasAAA).append(",").append(totalDeErrosPotenciais).append("\n");
			
			System.out.println(titulo);
			System.out.println(sb.toString());
			// grava e fecha o arquivo
			FileWriter file;
			try {
				file = new FileWriter("resultado/resultado.csv", true);
				file.write(sb.toString());
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			posicao++;
		}

	}

	public static Integer qtErrosLvlAAALink(Document document) {
		return document.select("div#AC_errors>h4:contains((AAA))").size();
	}

	public static Integer qtErrosLvlAALink(Document document) {
		return document.select("div#AC_errors>h4:contains((AA))").size();
	}

	public static Integer qtErrosLvlALink(Document document) {
		return document.select("div#AC_errors>h4:contains((A))").size();
	}

	public static Integer qtPotentialErrorsLink(Document document) {
		return new Integer(document.select("span#AC_num_of_potential").text());
	}

	public static Integer qtLikelyErrorsLink(Document document) {
		return new Integer(document.select("span#AC_num_of_likely").text());
	}

	public static Integer qtErrorsLink(Document document) {
		return new Integer(document.select("span#AC_num_of_errors").text());
	}

	public static String linkValidado(Document document) {
		return document.select("input#checkuri").val().toLowerCase();
	}

	public static String tituloValidador(Document document) {
		return document.title();
	}

	public static Document validaLinkWCGA2(String link) {
		Document document = null;
		try {
		Connection.Response loginForm = Jsoup.connect("http://achecker.ca/checker/index.php")
				.method(Connection
				.Method.GET)
				.execute();

			document = Jsoup.connect("http://achecker.ca/checker/index.php")
					.timeout(0) 							// aumenta o timeout
					.data("uri", link)
					.data("validate_uri", "Check It")
					.data("MAX_FILE_SIZE", "52428800")
					.data("radio_gid[]", "9")
					.data("checkbox_gid[]", "8")
					.data("rpt_format", "1")
					.cookies(loginForm.cookies())
					.post();
		} catch (IOException e) {
			e.printStackTrace();
			validaLinkWCGA2(link);
		}
		
		return document;
	}
	public static Document validaLinkWCGA1(String link) {
		Document document = null;
		try {
			Connection.Response loginForm = Jsoup.connect("http://achecker.ca/checker/index.php")
					.method(Connection
							.Method.GET)
					.execute();
			
			document = Jsoup.connect("http://achecker.ca/checker/index.php")
					.timeout(0) 							// aumenta o timeout
					.data("uri", link)
					.data("validate_uri", "Check It")
					.data("MAX_FILE_SIZE", "52428800")
					.data("radio_gid[]", "6")
					.data("checkbox_gid[]", "8")
					.data("rpt_format", "1")
					.cookies(loginForm.cookies())
					.post();
		} catch (IOException e) {
			e.printStackTrace();
			validaLinkWCGA1(link);
		}
		
		return document;
	}
	
	public static Integer QtOcorrenciasLvlA(Document document) {
		Elements divsAAA = document.select("div#AC_errors h4:contains((A))+br+div.gd_one_check");
		List<Element> todos = new ArrayList<>();
		Element node = divsAAA.first();
		for (Element element : divsAAA) {
			while (node != null && node.tagName().equalsIgnoreCase("div")
					&& node.className().equalsIgnoreCase("gd_one_check")) {
				todos.add(node);
				node = node.nextElementSibling();
			}
		}
		Document doc = Jsoup.parse(todos.toString());
		return doc.select("tr").size();
	}

	public static Integer QtOcorrenciasLvlAA(Document document) {
		Elements divsAAA = document.select("div#AC_errors h4:contains((AA))+br+div.gd_one_check");
		List<Element> todos = new ArrayList<>();
		Element node = divsAAA.first();
		for (Element element : divsAAA) {
			while (node != null && node.tagName().equalsIgnoreCase("div")
					&& node.className().equalsIgnoreCase("gd_one_check")) {
				todos.add(node);
				node = node.nextElementSibling();
			}
		}
		Document doc = Jsoup.parse(todos.toString());
		return doc.select("tr").size();
	}

	public static Integer QtOcorrenciasLvlAAA(Document document) {
		Elements divsAAA = document.select("div#AC_errors h4:contains((AAA))+br+div.gd_one_check");
		List<Element> todos = new ArrayList<>();
		Element node = divsAAA.first();
		for (Element element : divsAAA) {
			while (node != null && node.tagName().equalsIgnoreCase("div")
					&& node.className().equalsIgnoreCase("gd_one_check")) {
				todos.add(node);
				node = node.nextElementSibling();
			}
		}
		Document doc = Jsoup.parse(todos.toString());
		return doc.select("tr").size();
	}
}
