using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using Erronka2.Models;
using Erronka2.Services;

namespace Erronka2.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly ILangileaService _langileaService;

        public HomeController(ILogger<HomeController> logger, ILangileaService langileaService)
        {
            _logger = logger; 
            _langileaService = langileaService; 
        }
        public async Task<IActionResult> Index()
        { 
            List<Langilea> langileList = new List<Langilea>();
            langileList = await _langileaService.GetLangileak(); 
            return View(langileList); 
        }
        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
