using Newtonsoft.Json;
using WebErronka.Models;

namespace WebErronka.Services
{

    public class JokoaService : IJokoaService
    {
        private Uri rutaJokoa = new Uri("https://localhost:44367/api/jokoak/");
        public async Task<Jokoa> GetJokoa(int id)
        {
            Jokoa jokoa = new Jokoa();
            Uri jokoBat = new Uri(rutaJokoa, "jokoa/" + id.ToString());
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(jokoBat))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    jokoa = JsonConvert.DeserializeObject<Jokoa>(apiResponse);
                }
            }
            return jokoa;
        }


        public async Task<String> GetJokoaIzena(int id)
        {
            string jokoaIzena;
            Jokoa jokoa = new Jokoa();
            Uri jokoBat = new Uri(rutaJokoa, "jokoa/" + id.ToString());
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(jokoBat))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    jokoa = JsonConvert.DeserializeObject<Jokoa>(apiResponse);
                    jokoaIzena = jokoa.jokoa;
                }
            }
            return jokoaIzena;
        }
    }
}
