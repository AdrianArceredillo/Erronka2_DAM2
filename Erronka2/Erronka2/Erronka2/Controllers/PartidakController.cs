using Erronka2.Services;
using Microsoft.AspNetCore.Mvc;

namespace Erronka2.Controllers
{
    public class PartidakController : Controller
    {
   
        private readonly IPartidaService _partidaService;

        public PartidakController(IPartidaService partidaService)
        {
        _partidaService = partidaService;
        }

        // GET: Partidak
        public async Task<IActionResult> Index(int id, string izena)
        {
            ViewBag.izena = izena;
            return View(await _partidaService.GetPartidak());
        }
    }
}
