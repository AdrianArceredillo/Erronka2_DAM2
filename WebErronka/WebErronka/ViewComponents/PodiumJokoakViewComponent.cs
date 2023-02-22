using Microsoft.AspNetCore.Mvc;
using WebErronka.Services;

namespace WebErronka.ViewComponents
{
    public class PodiumJokoakViewComponent : ViewComponent
    {
        private readonly IPartidaService _partidaService;
        public PodiumJokoakViewComponent(IPartidaService partidaService)
        {
            _partidaService = partidaService;
        }
        public async Task<IViewComponentResult> InvokeAsync(string jokoIzena)
        {
            return View(await _partidaService.GetPartidakJokuarekiko(jokoIzena));
        }
    }
}