using Erronka2.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace Erronka2.Services
{
    public class PartidaService : IPartidaService
    {
        private Uri rutaTodos = new Uri("https://192.168.:44367/api/partidak/");

        public Task<Partida> GetPartida(int id)
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
