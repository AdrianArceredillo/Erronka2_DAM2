using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using WebErronka.Models;
using WebErronka.Services;
using WebErronka.ViewModels;

namespace WebErronka.Controllers
{
    [Authorize]
    public class BalorazioaController : Controller
    {
        private readonly IBalorazioaService _balorazioaService;
        public BalorazioaController(IBalorazioaService balorazioaService)
        {
            _balorazioaService = balorazioaService;
        }

        public async Task<IActionResult> BalorazioakInprimatu(string jokoa)
        {
            IList<Balorazioa> balorazioList = new List<Balorazioa>();
            balorazioList = await _balorazioaService.GetBalorazioakJokoarekiko(jokoa);

            //Ardo bakoitzaren datuak hartu eta ViewModel bezala sortu
            IList<BalorazioaViewModel> balorazioaVMlist = new List<BalorazioaViewModel>();
            foreach (var x in balorazioList)
            {
                BalorazioaViewModel balorazioaViewModel = new BalorazioaViewModel()
                {

                    Erabiltzailea = x.Erabiltzailea,
                    Kopurua = x.Kopurua,
                    Data = x.Data,

                };
                balorazioaVMlist.Add(balorazioaViewModel);
            }

            return View(balorazioaVMlist);

            //}
        }
        public IActionResult Create(string jokoa)
        {
            Balorazioa balorazioa = new Balorazioa();
            balorazioa.jokoa = jokoa;
            return View(balorazioa);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id, jokoa, Erabiltzailea, Testua, Kopurua, Data")] Balorazioa balorazioa)
        {
            if (ModelState.IsValid)
            {
                balorazioa.Data = DateTime.Today;
                balorazioa.Erabiltzailea = HttpContext.User.Identity.Name;
                _balorazioaService.BalorazioaGehitu(balorazioa);
                return RedirectToAction("Index", "Home");
            }
            return View(balorazioa);
        }
    }
}
