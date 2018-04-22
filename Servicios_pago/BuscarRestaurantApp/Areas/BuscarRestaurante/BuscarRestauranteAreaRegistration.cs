using System.Web.Mvc;

namespace BuscarRestaurantApp.Areas.BuscarRestaurante
{
    public class BuscarRestauranteAreaRegistration : AreaRegistration
    {
        public override string AreaName
        {
            get
            {
                return "BuscarRestaurante";
            }
        }

        public override void RegisterArea(AreaRegistrationContext context)
        {
            context.MapRoute(
                "BuscarRestaurante_default",
                "BuscarRestaurante/{controller}/{action}/{id}",
                new { action = "Index", id = UrlParameter.Optional }
            );
        }
    }
}
