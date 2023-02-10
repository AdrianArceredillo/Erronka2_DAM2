namespace Erronka2.Models
{
    public class Balorazioa
    {
        public int id { get; set; }
        public string jokoa { get; set; }
        public int langileaId { get; set; }
        public string? erabiltzailea { get; set; }
        public string testua { get; set; }
        public int kopurua { get; set; }
        public DateTime data { get; set; }
    }
}