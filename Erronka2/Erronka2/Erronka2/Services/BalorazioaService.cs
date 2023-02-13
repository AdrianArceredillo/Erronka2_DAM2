using Erronka2.Models;
using Erronka2.Services;
using Newtonsoft.Json;
using System.Text;

namespace Erronka2.Services
{
    public class BalorazioaService : IBalorazioaService
    {
        private Uri rutaTodos = new Uri("https://192.168.65.22:8080/api/balorazioak/");
        public async Task<IList<Balorazioa>> GetBalorazioak()
        {
            List<Balorazioa> balorazioaList = new List<Balorazioa>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    balorazioaList = JsonConvert.DeserializeObject<List<Balorazioa>>(apiResponse);
                }
            }
            return balorazioaList;
        }
        public async Task BalorazioaGehitu(Balorazioa balorazioa)
        {
            using (var httpClient = new HttpClient())
            {
                StringContent content = new StringContent(JsonConvert.SerializeObject(balorazioa), Encoding.UTF8, "application/json");
                var response = await httpClient.PostAsync(rutaTodos, content);
                response.EnsureSuccessStatusCode();
            }
        }
    }
}