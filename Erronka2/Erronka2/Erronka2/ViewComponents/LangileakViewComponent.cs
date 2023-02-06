using Microsoft.AspNetCore.Mvc;
using Erronka2.Services;

namespace Erronka2.ViewComponents
{
    public class LangileakViewComponent : ViewComponent
    {
        private readonly ILangileaService _langileaService;
        public LangileakViewComponent(ILangileaService langileaService)
        {
            _langileaService = langileaService;
        }
        public async Task<IViewComponentResult> InvokeAsync(int id)
        {
            return View(await _langileaService.Getemail(string email));
        }
    }
}
