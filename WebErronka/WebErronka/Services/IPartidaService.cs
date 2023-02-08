using WebErronka.Models;

namespace WebErronka.Services
{
    public interface IPartidaService
    {
        Task<IList<LangilePartida>> GetLangilea(int partidaId);
        Task<List<Partida>> GetPartidak();
        Task<Partida> GetPartida(int id);



    }
}
