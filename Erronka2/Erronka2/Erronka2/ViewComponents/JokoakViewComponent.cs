using Erronka2.Services;
using Microsoft.AspNetCore.Mvc;

namespace Erronka2.ViewComponents
{
    public class JokoakViewComponent : ViewComponent
    {
        private readonly IJokoaService _jokoaService; //Inyeccion de dependencias
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
