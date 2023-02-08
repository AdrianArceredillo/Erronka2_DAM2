using WebErronka.Models;

namespace WebErronka.Services
{
    public interface IBalorazioaService
    {
        Task<Balorazioa> GetBalorazioa(int id);
        Task<IList<Balorazioa>> GetBalorazioak();
    }
}
