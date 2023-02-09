using WebErronka.Models;

namespace WebErronka.Services
{
    public interface IBalorazioaService
    {
        Task<IList<Balorazioa>> GetBalorazioakJokoarekiko(string jokoa);
        Task<IList<Balorazioa>> GetBalorazioak();
        Task BalorazioaGehitu(Balorazioa balorazioa);
    }
}
