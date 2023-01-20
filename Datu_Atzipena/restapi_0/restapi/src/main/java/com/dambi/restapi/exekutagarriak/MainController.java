package com.dambi.restapi.exekutagarriak;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dambi.restapi.LangileaRepository;
import com.dambi.restapi.PartidaRepository;
import com.dambi.restapi.pojoak.*;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)

public class MainController {
    @Autowired // This means to get the bean called partidaRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private PartidaRepository partidaRepository;

    @Autowired
    private LangileaRepository langileaRepository;

    @PostMapping(path = "/add_Partida") // Map ONLY POST Requests
    public @ResponseBody String addNewPartida(
            @RequestParam String user,
            @RequestParam int puntuazioa,
            @RequestParam String data) throws ParseException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Partida p = new Partida();
        p.setUser(user);
        p.setPuntuazioa(puntuazioa);
        p.setData(data);

        partidaRepository.save(p);
        return "Saved";
    }

    @GetMapping(path = "/all_Partida")
    public @ResponseBody Iterable<Partida> getAllPartida() {

        // HttpGet request_PartidaGuztiak = new
        // HttpGet("http://localhost:8080/demo/all_Partida");
        // a.infoObjetos(request_PartidaGuztiak, "P");

        return partidaRepository.findAll();

    }

    @GetMapping(path = "/PartidaBat")
    public @ResponseBody Optional<Partida> getPartidaBat(int partidaId) {

        // HttpGet request_PartidaBat = new
        // HttpGet("http://localhost:8080/demo/PartidaBat?partidaId=0");
        // a.infoObjetos(request_PartidaBat, "P");

        return partidaRepository.findById(partidaId);
    }

    // ------------------------------------------------------------------------------
    // --------------- LANGILEA ----------------------------------------------------
    // ------------------------------------------------------------------------------

    @PostMapping(path = "/add_Langilea") // Map ONLY POST Requests
    public @ResponseBody String addNewLangilea(
            @RequestParam String email,
            @RequestParam String izena,
            @RequestParam String user,
            @RequestParam String jaiotzadata,
            @RequestParam int taldea) throws ParseException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Langilea l = new Langilea();
        l.setEmail(email);
        l.setIzena(izena);
        l.setUser(user);
        l.setJaiotzaData(jaiotzadata);
        l.setTaldea(taldea);

        langileaRepository.save(l);
        return "Saved";

    }

    @GetMapping(path = "/all_Langilea")
    public @ResponseBody Iterable<Langilea> getAllLangilea() {

        // HttpGet request_LangileaGuztiak = new
        // HttpGet("http://localhost:8080/demo/all_Langilea");
        // a.infoObjetos(request_LangileaGuztiak, "L");

        return langileaRepository.findAll();

    }

    @GetMapping(path = "/LangileaBat")
    public @ResponseBody Optional<Langilea> getLangileaBat(String langileaEmail) {

        // HttpGet request_LangileBat = new
        // HttpGet("http://localhost:8080/demo/LangileaBat?langileaEmail=aaa");
        // a.infoObjetos(request_LangileBat, "L");
        // a.request_Langileak = request_LangileBat;

        // a.main(null);

        return langileaRepository.findById(langileaEmail);
    }

    // elegir a qué RestAPI nos queremos conectar
    @GetMapping(path = "/AukeratuRestapia")
    public @ResponseBody String getLangileakAlain(String ip) {

        // final String uri = "http://192.168.65.6:8080/demo/all_Partida";
        final String uri = "http://" + ip + ":8080/demo/all_Langilea";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class) +
                "\n";

        return result;
    }

}

// INFO:

// 1.-
// https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/
// 2.-
// https://zetcode.com/java/getpostrequest/