using Erronka2.Models;

namespace Erronka2.Services
{
    public interface ILangileaService
    {

        Task<List<Langilea>> GetLangileak();
        Task<Langilea> GetLangilea(string user);


    }
}
