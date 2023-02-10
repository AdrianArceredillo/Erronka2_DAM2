using System.ComponentModel.DataAnnotations;

namespace Erronka2.Models
{
    public class Jokoa
    {
        [Key]
        public int id { get; set; }
        public string jokoa { get; set; }
        public virtual IList<Langilea> Langileak { get; set; }
    }
}
