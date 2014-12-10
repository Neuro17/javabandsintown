package http;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import requests.Paramaters;

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
	
	protected BandsintownConnector setArtistID(String id) {
		log.trace("Entering setArtistID");
		uriBld.setParameter(Paramaters.getArtistId(), id);
		log.trace("Exiting setArtistID");
		return this;
	}
	
	protected BandsintownConnector asJson(){
		log.trace("Entering asJson");
		uriBld.setParameter(Paramaters.getFormat(), "json");
		log.trace("Exiting asJson");
		return this;
	}
	
	protected BandsintownConnector asXML(){
		log.trace("Entering asXML");
		uriBld.setParameter(Paramaters.getFormat(), "XML");
		log.trace("Exiting asXML");
		return this;
	}
	
	private BandsintownConnector setAppId() {
		log.trace("Entering setAppId");
		uriBld.setParameter(Paramaters.getAppId(), BandsintownConfig.getApiKey());
		log.trace("Exiting setAppId");
		return this;
	}
	
	private BandsintownConnector setApiVersion(){
		log.trace("Entering setApiVersion");
		uriBld.setParameter(Paramaters.getApiVersion(), BandsintownConfig.getApiVersion());
		log.trace("Exiting setApiVersion");
		return this;
	}
	
	protected void build(){
		log.trace("Entering build");
		setAppId();
		setApiVersion();
		try {
			uri = uriBld.build();
			log.debug(uri);
		} catch (URISyntaxException e) {
			log.error(e.getMessage());
		}
		log.trace("Exiting build");
	}
}
