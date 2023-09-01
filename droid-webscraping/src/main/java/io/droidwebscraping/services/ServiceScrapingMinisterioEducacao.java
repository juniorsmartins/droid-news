package io.droidwebscraping.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import io.droidwebscraping.dtos.NewsDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public final class ServiceScrapingMinisterioEducacao {
  
  private static final String URL_MINISTERIO_ESPORTE = 
  "https://www.gov.br/esporte/pt-br/noticias-e-conteudos/esporte";


  public NewsDTO obtainNews() {

    this.getLinksFromToday().forEach(link -> System.out.println(link));

    return NewsDTO.builder().build();
  }



  private List<String> getLinksFromToday() {

    List<String> linksFromToday = new ArrayList<>();
    LocalDate today = LocalDate.now();

    Document document = this.connectMinisterioEsporte();
    Elements links = document.select("a[href]");

    for (Element link: links) {
      String linkAbsoluto = link.attr("abs:href");

      if (linkAbsoluto.startsWith(URL_MINISTERIO_ESPORTE)) {
        try {
          Document linkDoc = Jsoup.connect(linkAbsoluto)
          .header("Accept", "text/html")
          .get();

          Element dataElement = linkDoc.selectFirst(".documentPublished .value");

          if (dataElement != null) {
            String publicationDateTimeStr = dataElement.text();
            String datePart = publicationDateTimeStr.split(" ")[0];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate publicationDate = LocalDate.parse(datePart, formatter);

            if (publicationDate.isEqual(today)) {
              linksFromToday.add(linkAbsoluto);
            }
          }

        } catch (Exception ioe) {
          log.error("Error trying to connect to the Ministry of Sport website -> {}", ioe.getMessage());
        }
      }
    }

    return linksFromToday;
  }

  private Document connectMinisterioEsporte() {
    Document document = null;

    try {
      document = Jsoup.connect(URL_MINISTERIO_ESPORTE).get();

    } catch (IOException ioe) {
      log.error("Error trying to connect to the Ministry of Sport website -> {}", ioe.getMessage());
    }

    return document;
  }
}

