using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Dream.WebApi.Entities;
using Dream.WebApi.Services;
using Dream.WebApi.ViewModels;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace Dream.WebApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AccountController : ControllerBase
    {
        private readonly EFContext _context;
        private readonly UserManager<DbUser> _userManager;
        private readonly SignInManager<DbUser> _signInManager;
        private readonly IJwtTokenService _IJwtTokenService;

        public AccountController(EFContext context,
           UserManager<DbUser> userManager,
           SignInManager<DbUser> signInManager,
           IJwtTokenService IJwtTokenService)
        {
            _userManager = userManager;
            _context = context;
            _signInManager = signInManager;
            _IJwtTokenService = IJwtTokenService;
        }
        [HttpPost("login")]
        public async Task<IActionResult> Login([FromBody]UserViewModel userViewModel)
        {
            if (!ModelState.IsValid)
            {
                //var errrors = CustomValidator.GetErrorsByModel(ModelState);
                return BadRequest("Bad Model");
            }

            var user = _context.Users.FirstOrDefault(u => u.Email == userViewModel.Email);
            if (user == null)
            {
                return BadRequest(new { invalid = "Даний користувач не знайденний" });
            }

            var result = _signInManager
                .PasswordSignInAsync(user, userViewModel.Password, false, false).Result;

            if (!result.Succeeded)
            {
                return BadRequest(new { invalid = "Невірно введений пароль" });
            }

            await _signInManager.SignInAsync(user, isPersistent: false);

            return Ok(
                 new
                 {
                     token = _IJwtTokenService.CreateToken(user)
                 });
        }
    }
}