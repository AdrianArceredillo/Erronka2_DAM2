using Microsoft.AspNetCore.Mvc;
using WebErronka.Services;

namespace WebErronka.ViewComponents
{
    public class JokoakViewComponent : ViewComponent
    {
        private readonly IJokoaService _jokoaService;
        public JokoakViewComponent(IJokoaService ardoaService)
        {
            _jokoaService = ardoaService;
        }
        public async Task<IViewComponentResult> InvokeAsync(int id)
        {
            ViewBag.jokoaId = id;
            return View(await _jokoaService.GetJokoaIzena(id));
        }
    }
}
