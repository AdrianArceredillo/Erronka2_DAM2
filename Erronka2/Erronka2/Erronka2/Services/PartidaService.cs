using Erronka2.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace Erronka2.Services
{
    public class PartidaService : IPartidaService
    {
        private Uri rutaTodos = new Uri("https://localhost:44367/api/Partida/");

        public Task<Partida> GetPartida(int id)
        {
            throw new NotImplementedException();
        }

        public async Task<List<Partida>> GetPartidak()  //zerrenda
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
    }
    
}
