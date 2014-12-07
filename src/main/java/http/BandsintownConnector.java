package http;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import requests.Paramaters;
import search.Get;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import config.BandsintownConfig;


public abstract class BandsintownConnector extends HttpConnectorImpl {
	private static final Logger log = LogManager.getLogger(BandsintownConnector.class);
	protected Gson gson = new GsonBuilder().setPrettyPrinting().create();
	protected URI uri;
	protected Integer page;
	protected int pages;
	
	protected Integer getPage() {
		return page;
	}

	protected void setPage(int page) {
		this.page = page;
	}
	
	public boolean hasNextPage() {
		return page < pages;
	}

	protected int getPages() {
		return pages;
	}

	protected void setPages(int pages) {
		this.pages = pages;
	}
	
	protected URI getUri() {
		return uri;
	}

	protected void setUri(URI uri) {
		this.uri = uri;
	}
	
	protected void buildURI(){
		log.trace("Building URI");
		
		uriBld.setScheme(BandsintownConfig.getScheme()).setHost(BandsintownConfig.getHost());
		
		try {
			log.debug("Built base url: " + uriBld.build());
		} catch (URISyntaxException e) {
			log.error(e.getMessage());
		}
		
		log.trace("Succesfully built URI"); 
	}
	
	public BandsintownConnector setArtistID(String id) {
		uriBld.setParameter(Paramaters.getArtistId(), id);
		return this;
	}
	
	public BandsintownConnector asJson(){
		uriBld.setParameter(Paramaters.getFormat(), "json");
		return this;
	}
	
	public BandsintownConnector asXML(){
		uriBld.setParameter(Paramaters.getFormat(), "XML");
		return this;
	}
	
	public BandsintownConnector setAppId() {
		uriBld.setParameter(Paramaters.getAppId(), BandsintownConfig.getApiKey());
		return this;
	}
	
	public abstract void build();
}
