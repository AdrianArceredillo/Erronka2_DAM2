using Erronka2.Services;
using Microsoft.AspNetCore.Mvc;

namespace Erronka2.ViewComponents
{
    public class PartidakViewComponent : ViewComponent
    {
    
        private readonly IPartidaService _partidaService; //Inyeccion de dependencias
        public PartidakViewComponent(IPartidaService partidaService)
        {
            _partidaService = partidaService;
        }
        public async Task<IViewComponentResult> InvokeAsync(int id)
        {
            return View(await _partidaService.GetPartidak());
        }
    }
}