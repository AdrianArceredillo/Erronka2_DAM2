using Microsoft.AspNetCore.Mvc;
using WebErronka.Models;
using WebErronka.Services;
using WebErronka.ViewModels;

namespace WebErronka.Controllers
{

    public class BalorazioaController : Controller
    {
        private readonly IBalorazioaService _balorazioaService;
        public async Task<IActionResult> Index()
        {
            IList<Balorazioa> balorazioList = new List<Balorazioa>();
            balorazioList = await _balorazioaService.GetBalorazioak();

            //Ardo bakoitzaren datuak hartu eta ViewModel bezala sortu
            IList<BalorazioaViewModel> balorazioaVMlist = new List<BalorazioaViewModel>();
            foreach (var x in balorazioList)
            {
                var balorazioa = await _balorazioaService.GetBalorazioa(x.Id);
                BalorazioaViewModel balorazioaViewModel = new BalorazioaViewModel()
                {
                    Id = balorazioa.Id,
                    Erabiltzailea = balorazioa.Erabiltzailea,
                    Kopurua = balorazioa.Kopurua,
                    Data = balorazioa.Data,

                };
                balorazioaVMlist.Add(balorazioaViewModel);
            }
            var modelberria = new BalorazioaViewModel(); //Bistaratuko dugun ViewModel osoa

            return View(modelberria);

            //}
        }
    }
}
