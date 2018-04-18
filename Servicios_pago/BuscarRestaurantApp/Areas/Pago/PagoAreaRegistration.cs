using System.Web.Mvc;

namespace BuscarRestaurantApp.Areas.Pago
{
    public class PagoAreaRegistration : AreaRegistration
    {
        public override string AreaName
        {
            get
            {
                return "Pago";
            }
        }

        public override void RegisterArea(AreaRegistrationContext context)
        {
            context.MapRoute(
                "Pago_default",
                "Pago/{controller}/{action}/{id}",
                new { action = "Index", id = UrlParameter.Optional }
            );
        }
    }
}
