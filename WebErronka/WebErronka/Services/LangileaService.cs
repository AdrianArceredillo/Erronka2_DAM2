using Newtonsoft.Json;
using WebErronka.Models;

namespace WebErronka.Services
{
    public class LangileaService : ILangileaService
    {

        private Uri rutaLangilea = new Uri("https://localhost:44367/api/Langilea/");
        public async Task<IList<Langilea>> GetLangileak()
        {

            List<Langilea> langileaList = new List<Langilea>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaLangilea))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    langileaList = JsonConvert.DeserializeObject<List<Langilea>>(apiResponse);
                }
            }
            return langileaList;
        }


    }
}
