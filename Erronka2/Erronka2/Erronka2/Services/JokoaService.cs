using Erronka2.Models;
using Newtonsoft.Json;

namespace Erronka2.Services
{
    public class JokoaService :IJokoaService
    {
        private Uri rutaTodos = new Uri("http://192.168.65.91:8080/api/jokoak/");

        public async Task<Jokoa> GetJokoa(int id)
        {
            Jokoa jokoa = new Jokoa();
            Uri jokoBat = new Uri(rutaTodos + id.ToString());

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

        public async Task<List<Jokoa>> GetJokoak()  //zerrenda
        {
            List<Jokoa> jokoaList = new List<Jokoa>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    jokoaList = JsonConvert.DeserializeObject<List<Jokoa>>(apiResponse);
                }
            }
            return jokoaList;
        }
    }
}

