using Erronka2.Models;

namespace Erronka2.Services
{
    public interface IJokoaService
    {
        Task<Jokoa> GetJokoa(int id);

        Task<List<Jokoa>> GetJokoak();
    }
}
