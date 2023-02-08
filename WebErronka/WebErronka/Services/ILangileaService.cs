using WebErronka.Models;

namespace WebErronka.Services
{
    public interface ILangileaService
    {
        Task<IList<Langilea>> GetLangileak();
    }
}
