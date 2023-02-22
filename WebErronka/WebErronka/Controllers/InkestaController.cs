using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace WebErronka.Controllers
{
    [Authorize]
    public class InkestaController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
