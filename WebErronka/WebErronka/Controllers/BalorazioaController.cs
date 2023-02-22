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

        public async Task<IActionResult> BalorazioakInprimatu(string jokoIzena)
        {
            IList<Balorazioa> balorazioList = new List<Balorazioa>();
            balorazioList = await _balorazioaService.GetBalorazioakJokoarekiko(jokoIzena);

            //Ardo bakoitzaren datuak hartu eta ViewModel bezala sortu
            IList<BalorazioaViewModel> balorazioaVMlist = new List<BalorazioaViewModel>();
            foreach (var x in balorazioList)
            {
                BalorazioaViewModel balorazioaViewModel = new BalorazioaViewModel()
                {
                    jokoa = x.jokoa,
                    erabiltzailea = x.erabiltzailea,
                    testua = x.testua,
                    kopurua = x.kopurua,
                    data = x.data,

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
        public IActionResult Create(Balorazioa balorazioa)
        {
            if (ModelState.IsValid)
            {
                // Populate the Erabiltzailea and Data properties
                balorazioa.erabiltzailea = HttpContext.User.Identity.Name;
                balorazioa.data = DateTime.Now;
                _balorazioaService.BalorazioaGehitu(balorazioa);

                return RedirectToAction("Index", "Home");
            }
            else
            {
                // There are validation errors in the form data, so redisplay the form with error messages
                return View(balorazioa);
            }
        }
    }
}
