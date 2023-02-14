﻿using Erronka2.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace Erronka2.Services
{
    public class LangileaService : ILangileaService
    {
        private Uri rutaTodos = new Uri("http://192.168.65.91:8080/api/langileak/");

        public Task<Langilea> GetLangilea(string user)
        {
            throw new NotImplementedException();
        }

        public async Task<List<Langilea>> GetLangileak()  //zerrenda
        {
            List<Langilea> langileaList = new List<Langilea>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    langileaList = JsonConvert.DeserializeObject<List<Langilea>>(apiResponse);
                }
            }
            return langileaList;
        }
    }
}