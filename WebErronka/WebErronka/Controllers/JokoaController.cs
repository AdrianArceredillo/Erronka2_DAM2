using Microsoft.AspNetCore.Mvc;
using WebErronka.Models;
using WebErronka.Services;

namespace WebErronka.Controllers
{
    public class JokoaController : Controller
    {
        private readonly IJokoaService jokoaService;
        public async Task<IActionResult> IndexAsync(int jokoaId)
        {

            Jokoa jokoa = new Jokoa();
            jokoa = await jokoaService.GetJokoa(jokoaId);

            return View(jokoa);

            //}

        }
    }
}
