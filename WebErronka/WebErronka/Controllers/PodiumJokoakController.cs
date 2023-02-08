using Microsoft.AspNetCore.Mvc;
using WebErronka.Models;
using WebErronka.Services;
using WebErronka.ViewModels;

namespace WebErronka.Controllers
{
    public class PodiumJokoakController : Controller
    {
        private readonly IPartidaService _partidaService;
        public async Task<IActionResult> IndexAsync(int jokoaId)
        {
            IList<Partida> balorazioList = new List<Partida>();
            var partidaList = await _partidaService.GetPartidakJokuarekiko(jokoaId);

            //Partida bakoitzaren datuak hartu
            IList<PodiumJokoakViewModel> podiumVMlist = new List<PodiumJokoakViewModel>();

            for (int i = 0; i < 5; i++)
            {
                try
                {

                    PodiumJokoakViewModel podiumViewModel = new PodiumJokoakViewModel()
                    {
                        jokalaria = balorazioList[i].langilea,
                        puntuazioa = balorazioList[i].puntuazioa,
                        taldea = balorazioList[i].taldea,

                    };
                    podiumVMlist.Add(podiumViewModel);
                }
                catch (Exception e)
                {

                }

            }
            var modelberria = new PodiumJokoakViewModel(); //Bistaratuko dugun ViewModel osoa

            return View(modelberria);

        }
    }
}
