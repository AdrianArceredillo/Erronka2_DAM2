using Erronka2.Models;
using Microsoft.AspNetCore.Mvc;

namespace Erronka2.Services
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly ILangileaService _langileaService;
        public HomeController(ILogger<HomeController> logger, ILangileaService langileaService)
        {
            _logger = logger; _langileaService = langileaService; }
        public async Task<IActionResult> Index()
        { List<Langilea> langileList = new List<Langilea>();
            langileList = await _langileaService.Langileak(); 
            return View(langileList.Where(a => a.Eskaintza == true)); }
    }
}
