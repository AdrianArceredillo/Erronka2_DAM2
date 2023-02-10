using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Erronka2.Models;
using Erronka2.Services;

namespace Erronka2.Controllers
{
    [Authorize]
    public class BalorazioaController : Controller
    {
        private readonly IBalorazioaService _balorazioaService;

        public BalorazioaController(IBalorazioaService balorazioaService)
        {
            _balorazioaService = balorazioaService;
        }

        // GET: Balorazioak
        public async Task<IActionResult> Index(int id, string izena)
        {
            ViewBag.izena = izena;
            return View(await _balorazioaService.GetBalorazioak());
        }

        // GET: Balorazioa/Create
        public IActionResult Create(int langileaId)
        {
            Balorazioa balorazioa = new Balorazioa();
            balorazioa.langileaId = langileaId;
            return View(balorazioa);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id, LangileaId, Erabiltzailea, Testua, Kopurua, Data")] Balorazioa balorazioa)
        {
            if (ModelState.IsValid)
            {
                balorazioa.data = DateTime.Today;
                balorazioa.erabiltzailea = HttpContext.User.Identity.Name;
                _balorazioaService.BalorazioaGehitu(balorazioa);
                return RedirectToAction("Index", "Home");
            }
            return View(balorazioa);
        }
    }
}
