using Erronka2.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace Erronka2.Services
{
    public class LangileaService
    {
        private Uri rutaTodos = new Uri("https://localhost/api/Langilea/");
        public async Task<IList<LangilePartida>> Getemail(string email)
        { List<LangilePartida> langilePartidaList = new List<LangilePartida>();
            Uri rutaPartidak = new Uri(rutaTodos, "email/" + ToString());
            using (var httpClient = new HttpClient()) 
            { 
                using (var response = await httpClient.GetAsync(rutaPartidak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    langilePartidaList = JsonConvert.DeserializeObject<List<LangilePartida>>(apiResponse); 
                } 
            } 
            return langilePartidaList;
        }
    }
}
