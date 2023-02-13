using Erronka2.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace Erronka2.Services
{
    public class PartidaService : IPartidaService
    {
        private Uri rutaTodos = new Uri("http://localhost/api/partidak/");

        public Task<Partida> GetPartida(int partidaId)
        {
            throw new NotImplementedException();
        }

        public async Task<List<Partida>> GetPartidak()  //zerrenda
        {
            List<Partida> partidakList = new List<Partida>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partidakList = JsonConvert.DeserializeObject<List<Partida>>(apiResponse);
                }
            }
            return partidakList;
        }
    }
    
}
