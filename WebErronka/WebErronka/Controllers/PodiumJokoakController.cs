﻿using Microsoft.AspNetCore.Mvc;
using WebErronka.Models;
using WebErronka.Services;
using WebErronka.ViewModels;

namespace WebErronka.Controllers
{
    public class PodiumJokoakController : Controller
    {
        private readonly IPartidaService _partidaService;
        public async Task<IActionResult> IndexAsync(string jokoIzena)
        {
            List<Partida> partidaList = new List<Partida>();
            partidaList = await _partidaService.GetPartidakJokuarekiko(jokoIzena);


            //Partida bakoitzaren datuak hartu
            IList<PodiumJokoakViewModel> podiumVMlist = new List<PodiumJokoakViewModel>();

            for (int i = 0; i < 5; i++)
            {
                try
                {
                    PodiumJokoakViewModel podiumViewModel = new PodiumJokoakViewModel()
                    {
                        jokalaria = partidaList[i].langilea,
                        puntuazioa = partidaList[i].puntuazioa,
                        taldea = partidaList[i].taldea,

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
