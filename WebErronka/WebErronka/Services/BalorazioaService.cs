using Newtonsoft.Json;
using WebErronka.Models;

namespace WebErronka.Services
{
    public class BalorazioaService : IBalorazioaService
    {
        private Uri rutaBalorazioa = new Uri("https://localhost:44367/api/balorazioak/");
        public async Task<IList<Balorazioa>> GetBalorazioak()
        {

            List<Balorazioa> balorazioList = new List<Balorazioa>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaBalorazioa))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    balorazioList = JsonConvert.DeserializeObject<List<Balorazioa>>(apiResponse);
                }
            }
            return balorazioList;
        }

        public async Task<Balorazioa> GetBalorazioa(int id)
        {
            Balorazioa balorazioa = new Balorazioa();
            Uri balorazioBat = new Uri(rutaBalorazioa, id.ToString());
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(balorazioBat))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    balorazioa = JsonConvert.DeserializeObject<Balorazioa>(apiResponse);
                }
            }
            return balorazioa;
        }
    }
}
