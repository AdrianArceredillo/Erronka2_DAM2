using Microsoft.AspNetCore.Mvc;
using WebErronka.Services;
using WebErronka.ViewModels;

namespace WebErronka.Controllers
{
    public class PodiumGeneralController : Controller
    {
        private readonly IPartidaService _partidaService;
        public async Task<IActionResult> IndexAsync()
        {

            var partidaList = await _partidaService.GetPartidak();

            //Partida bakoitzaren datuak hartu
            IList<PodiumGeneralaViewModel> podiumVMlist = new List<PodiumGeneralaViewModel>();
            foreach (var x in partidaList)
            {

                PodiumGeneralaViewModel podiumGeneralaViewModel = new PodiumGeneralaViewModel()
                {
                    jokoa = x.jokoa,
                    jokalaria = x.langilea,
                    puntuazioa = x.puntuazioa,
                    taldea = x.taldea,

                };
                podiumVMlist.Add(podiumGeneralaViewModel);
            }
            var modelberria = new PodiumJokoakViewModel(); //Bistaratuko dugun ViewModel osoa

            return View(modelberria);

        }
    }
}
