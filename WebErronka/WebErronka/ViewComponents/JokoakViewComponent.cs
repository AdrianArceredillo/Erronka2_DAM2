using Microsoft.AspNetCore.Mvc;
using WebErronka.Services;

namespace WebErronka.ViewComponents
{
    public class JokoakViewComponent : ViewComponent
    {
        private readonly IJokoaService _jokoaService;
        public JokoakViewComponent(IJokoaService jokoaService)
        {
            _jokoaService = jokoaService;
        }
        public async Task<IViewComponentResult> InvokeAsync(int id)
        {
            return View(await _jokoaService.GetJokoa(id));
        }
    }
}
