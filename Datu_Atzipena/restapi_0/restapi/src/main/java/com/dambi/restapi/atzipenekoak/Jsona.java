// package com.dambi.restapi.atzipenekoak;

// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;

// import java.io.FileReader;

// import com.dambi.restapi.pojoak.Langilea;
// import com.dambi.restapi.pojoak.Langileak;
// import com.dambi.restapi.pojoak.Partida;
// import com.dambi.restapi.pojoak.Partidak;

// public class Jsona {

//     public Produktuak produktuak;
//     public String strFileOut;
//     private String strFileIn;

//     public Jsona(String strFileIn) {
//         this.strFileIn = strFileIn;
//     }

//     public Jsona(Produktuak produktuak, String strFileOut) {
//         this.produktuak = produktuak;
//         this.strFileOut = strFileOut;
//     }


//     public Produktuak irakurri() {
//         Produktuak produktuak = null;
//         try {
//             JsonReader reader = Json.createReader(new FileReader(strFileIn));
//             JsonStructure jsonst = reader.read();
//             JsonArray jsonarray = jsonst.asJsonArray();
//             produktuak = new Produktuak();
//             for (int i = 0; i < jsonarray.size(); i++) {
//                 //ID;IZENA;DESKRIPZIOA;PREZIOA;STOCKA;BOLUMENA;PISUA;BARRAKODEA;LEHENTASUNA
//                 JsonObject jsonobj = jsonarray.getJsonObject(i);
//                 Produktua produktua = new Produktua();
//                 produktua.setId(jsonobj.getInt("id"));
//                 produktua.setIzena(jsonobj.getString("izena"));
//                 produktua.setDeskripzioa(jsonobj.getString("deskripzioa"));
//                 produktua.setStocka(jsonobj.getInt("stocka"));
//                 produktua.setBolumena(jsonobj.getInt("bolumena"));
//                 produktua.setPrezioa(jsonobj.getInt("pisua"));
//                 produktua.setBarraKodea(jsonobj.getString("barraKodea"));
//                 produktua.setLehentasuna(jsonobj.getString("lehentasuna"));
//                 produktuak.add(produktua);
//             }
            
//         } catch (Exception e) {
//             System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan.");
//         }
//         return produktuak;
//     }


//     public void idatzi() {
//         //int produktuKopurua = 0;
//         JsonArray model = null;
//         JsonArrayBuilder jab = Json.createArrayBuilder();
//         for (Produktua p : this.produktuak.getProduktuak()) { //!!!
//             jab.add(Json.createObjectBuilder()
//                 //ID;IZENA;DESKRIPZIOA;PREZIOA;STOCKA;BOLUMENA;PISUA;BARRAKODEA;LEHENTASUNA
//                     .add("id", p.getId())
//                     .add("izena", p.getIzena())
//                     .add("deskripzioa", p.getDeskripzioa())
//                     .add("prezioa", p.getPrezioa())
//                     .add("stocka", p.getStocka())
//                     .add("bolumena", p.getBolumena())
//                     .add("pisua", p.getPisua())
//                     .add("barraKodea", p.getBarraKodea())
//                     .add("lehentasuna", p.getLehentasuna())
//                     .build());
//             //produktuKopurua++;
//         }
//         model=jab.build();

//         try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(this.strFileOut))) {
//             jsonWriter.writeArray(model);
//         } catch (FileNotFoundException fnfe) {
//             System.out.println("Fitxategia sortzerakoan arazoak.");
//         }

//     }
// }