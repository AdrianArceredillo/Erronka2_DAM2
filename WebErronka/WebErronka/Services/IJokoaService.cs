using WebErronka.Models;

namespace WebErronka.Services
{
    public interface IJokoaService
    {
        Task<Jokoa> GetJokoa(int id);
        Task<String> GetJokoaIzena(int id);
    }
}
