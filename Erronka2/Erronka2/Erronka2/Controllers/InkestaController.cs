using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace Erronka2.Controllers
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
