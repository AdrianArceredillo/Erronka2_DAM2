using Erronka2.Models;
using Microsoft.AspNetCore.Mvc;

namespace Erronka2.Services
{
    public interface ILangileaService
    {
        Task<IList<LangilePartida>> Getemail(string email);
        
    }
}
