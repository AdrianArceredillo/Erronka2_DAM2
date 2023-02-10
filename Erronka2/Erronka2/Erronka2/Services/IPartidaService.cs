using Erronka2.Models;

namespace Erronka2.Services
{
    public interface IPartidaService
    {
        Task<List<Partida>> GetPartidak();
        Task<Partida> GetPartida(int id);

    }
}
