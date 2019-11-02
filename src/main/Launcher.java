package main;

import static spark.Spark.*;
import java.util.*;
import com.google.gson.Gson;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Launcher {

	public static void main(String[] args) {
		staticFiles.location("/public");
		port(5011);
		
		HashMap<String, Object> polja = new HashMap<>();
		
		get("/home", (request, response)->{
			polja.put("pesme", Data.readFromJson("pesme.json"));
			return new ModelAndView(polja,"index.hbs");
		}, new HandlebarsTemplateEngine());
		
		post("/api/search",(request,response)->{
			response.type("text/text");
			String tekstPretrage=request.queryParams("tekstPretrage");
			ArrayList<Pesma> pesme=new ArrayList<>();
			for(Pesma element:Data.readFromJson("pesme.json")){
			
				if(element.getIme().toLowerCase().equals(tekstPretrage.toLowerCase())){
					pesme.add(element);
				}
			}
			Gson gson = new Gson();
			return gson.toJson(pesme);
		});
		
		get("/songs/form/add",(request,response)->{
			return new ModelAndView(polja,"dodajPesmu.hbs");
		},new HandlebarsTemplateEngine());
		
		get("/songs/add",(request,response)->{
			ArrayList<Pesma> tmp=Data.readFromJson("pesme.json");
			int id=tmp.size()+1;
			String naziv=request.queryParams("naziv");
			String izvodjac=request.queryParams("izvodjac");
			String album=request.queryParams("album");
			int trajanje=Integer.parseInt(request.queryParams("trajanje"));
			
			tmp.add(new Pesma(id,izvodjac,naziv,album, trajanje));
			Data.writeToJSON(tmp, "pesme.json");
			polja.put("pesme", tmp);
			return new ModelAndView(polja,"index.hbs");
		},new HandlebarsTemplateEngine());
		
	
	}

	

}
