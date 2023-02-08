using Erronka2.Models;

namespace Erronka2.Services
{
    public interface IBalorazioaService
    {
        Task<IList<Balorazioa>> GetBalorazioak(int id);
        Task BalorazioaGehitu(Balorazioa balorazioa);
    }
}