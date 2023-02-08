using Newtonsoft.Json;
using WebErronka.Models;

namespace WebErronka.Services
{
    public class PartidaService : IPartidaService
    {
        private Uri rutaTodos = new Uri("https://localhost:44367/api/Ardoa/");
        public async Task<IList<LangilePartida>> GetLangilea(int partidaId)
        {
            List<LangilePartida> langileaList = new List<LangilePartida>();
            Uri apiUri = new Uri(rutaTodos, "Partida/" + partidaId.ToString() + "/Langilea");
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(apiUri))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    langileaList = JsonConvert.DeserializeObject<List<LangilePartida>>(apiResponse);
                }
            }
            return langileaList;
        }
        public async Task<List<Partida>> GetPartidak()
        {
            List<Partida> partidaList = new List<Partida>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partidaList = JsonConvert.DeserializeObject<List<Partida>>(apiResponse);
                }
            }
            return partidaList;
        }
        public async Task<Partida> GetPartida(int id)
        {
            Partida ardoa = new Partida();
            Uri rutaArdoBat = new Uri(rutaTodos, id.ToString());
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaArdoBat))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    ardoa = JsonConvert.DeserializeObject<Partida>(apiResponse);
                }
            }
            return ardoa;
        }
    }

}

