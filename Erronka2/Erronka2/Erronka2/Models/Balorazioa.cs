namespace Erronka2.Models
{
    public class Balorazioa
    {
        public int Id { get; set; }
        public int LangileaId { get; set; }
        public string? Erabiltzailea { get; set; }
        public string Testua { get; set; }
        public int Kopurua { get; set; }
        public DateTime Data { get; set; }
    }
}