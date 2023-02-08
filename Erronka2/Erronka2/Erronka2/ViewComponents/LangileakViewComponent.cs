using Microsoft.AspNetCore.Mvc;
using Erronka2.Services;

namespace Erronka2.ViewComponents
{
    public class LangileakViewComponent : ViewComponent
    {
        private readonly ILangileaService _langileaService; //Inyeccion de dependencias
        public LangileakViewComponent(ILangileaService langileaService)
        {
            _langileaService = langileaService;
        }
        public async Task<IViewComponentResult> InvokeAsync(int id)
        {
            return View(await _langileaService.GetLangileak());
        }
    }
}
