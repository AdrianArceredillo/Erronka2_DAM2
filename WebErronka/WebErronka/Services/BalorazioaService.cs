using Newtonsoft.Json;
using System.Text;
using WebErronka.Models;

namespace WebErronka.Services
{
    public class BalorazioaService : IBalorazioaService
    {
        private Uri rutaTodos = new Uri("http://192.168.65.91:8080/api/balorazioak/");
        private Uri rutaBalorazioa = new Uri("http://192.168.65.91:8080/api/balorazioak/");
        private Uri rutaPostBalorazioa = new Uri("http://192.168.65.91:8080/api/balorazioaGehitu/");
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

        public async Task<IList<Balorazioa>> GetBalorazioakJokoarekiko(string jokoIzena)
        {
            List<Balorazioa> balorazioList = new List<Balorazioa>();
            Uri balorazioAkJokoarekiko = new Uri(rutaBalorazioa + jokoIzena);
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(balorazioAkJokoarekiko))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    balorazioList = JsonConvert.DeserializeObject<List<Balorazioa>>(apiResponse);
                }
            }
            return balorazioList;
        }

        public async Task BalorazioaGehitu(Balorazioa balorazioa)
        {
            using (var httpClient = new HttpClient())
            {
                StringContent content = new StringContent(JsonConvert.SerializeObject(balorazioa), Encoding.UTF8, "application/json");

                var response = await httpClient.PostAsync(rutaPostBalorazioa, content);
                string responseContent = await response.Content.ReadAsStringAsync();
                response.EnsureSuccessStatusCode();
            }
        }
    }
}
