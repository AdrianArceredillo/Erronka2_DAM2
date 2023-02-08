using Microsoft.AspNetCore.Mvc;
using WebErronka.Models;
using WebErronka.Services;
using WebErronka.ViewModels;

namespace WebErronka.Controllers
{
    public class PodiumGeneralController : Controller
    {
        private readonly IPartidaService _partidaService;
        public async Task<IActionResult> IndexAsync()
        {
            IList<Partida> balorazioList = new List<Partida>();
            var partidaList = await _partidaService.GetPartidak();

            //Partida bakoitzaren datuak hartu
            IList<PodiumJokoakViewModel> podiumVMlist = new List<PodiumJokoakViewModel>();
            foreach (var x in balorazioList)
            {

                PodiumJokoakViewModel podiumViewModel = new PodiumJokoakViewModel()
                {
                    jokalaria = x.langilea,
                    puntuazioa = x.puntuazioa,
                    taldea = x.taldea,

                };
                podiumVMlist.Add(podiumViewModel);
            }
            var modelberria = new PodiumJokoakViewModel(); //Bistaratuko dugun ViewModel osoa

            return View(modelberria);

        }
    }
}
