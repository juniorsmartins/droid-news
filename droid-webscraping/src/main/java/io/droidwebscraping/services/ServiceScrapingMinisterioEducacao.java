package io.droidwebscraping.services;

import java.io.IOException;

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
    
    Document document = this.connectMinisterioEsporte();

    Elements links = document.select("a[href]");

    for (Element link : links) {
      String linkAbsolut = link.attr("abs:href");
      System.out.println(linkAbsolut);
    }

    return NewsDTO.builder().build();
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

