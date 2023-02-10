using Microsoft.AspNetCore.Mvc;

namespace Erronka2.Models
{
    public class Partida
    {
        public int partidaId { get; set; }
        public string langilea { get; set; }
        public string jokoa { get; set; }
        public int puntuazioa { get; set; }
        public int taldea { get; set; }
        public DateTime data { get; set; }
       
    }
}
