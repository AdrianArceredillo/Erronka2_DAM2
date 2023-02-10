using Erronka2.Models;

namespace Erronka2.Services
{
    public interface IBalorazioaService
    {
        Task<IList<Balorazioa>> GetBalorazioak();
        Task BalorazioaGehitu(Balorazioa balorazioa);
    }
}