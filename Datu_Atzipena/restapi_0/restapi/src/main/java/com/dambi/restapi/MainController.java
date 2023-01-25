package com.dambi.restapi;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(data);
        Timestamp partida_Data = new Timestamp(date.getTime());
        p.setData(partida_Data);

        partidaRepository.save(p);
        return "Saved";
    }

    @GetMapping(path = "/all_Partida")
    public @ResponseBody Iterable<Partida> getAllPartida() {
        // This returns a JSON or XML with the users



        return partidaRepository.findAll();
    }

    @GetMapping(path = "/PartidaBat")
    public @ResponseBody Optional<Partida> getPartidaBat(int partidaId) {
        // This returns a JSON or XML with the users
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

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(jaiotzadata);
        Timestamp jaiotza_Data = new Timestamp(date.getTime());
        l.setJaiotzaData(jaiotza_Data);

        l.setTaldea(taldea);

        langileaRepository.save(l);
        return "Saved";
    }

    @GetMapping(path = "/all_Langilea")
    public @ResponseBody Iterable<Langilea> getAllLangilea() {
        // This returns a JSON or XML with the users
        return langileaRepository.findAll();
    }

    @GetMapping(path = "/all_Langileaid")
    public @ResponseBody Iterable<Langilea> getAllLangileaid() {

        return langileaRepository.findAll();
    }

    @GetMapping(path = "/LangileaBat")
    public @ResponseBody Optional<Langilea> getLangileaBat(String langileaEmail) {
        // This returns a JSON or XML with the users
        return langileaRepository.findById(langileaEmail);
    }

    @RestController
    @RequestMapping("/query")
    public class QueryController {
    
        private final JdbcTemplate jdbcTemplate;
    
        @Autowired
        public QueryController(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }
    
        @GetMapping
        public List<Map<String, Object>> executeQuery(@RequestParam("id") String id) {
            //String query = "SELECT * FROM partida WHERE id > " + id + "order by id asc";
            String query = id;

            return jdbcTemplate.queryForList(query);
        }
    }
}
