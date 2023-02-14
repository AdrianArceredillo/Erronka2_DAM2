using Erronka2.Models;
using Erronka2.Services;
using Microsoft.AspNetCore.Mvc;

namespace Erronka2.Controllers
{
    public class JokoaController : Controller
    {
        private readonly IJokoaService _jokoaaService;


        // GET: Balorazioak
        public async Task<IActionResult> Index(int jokoaId)
        {
            Jokoa jokoa = new Jokoa();
            jokoa = await _jokoaaService.GetJokoa(jokoaId);
            return View(jokoa);
        }
    }
}
