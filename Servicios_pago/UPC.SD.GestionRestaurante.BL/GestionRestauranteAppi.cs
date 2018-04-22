using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using UPC.SD.BaseEntidad.Contracts;
using UPC.SD.GestionRestaurante.Contracts;

namespace UPC.SD.GestionRestaurante.BL
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "Service1" en el código y en el archivo de configuración a la vez.
    [ServiceBehavior]
    public class GestionRestauranteAppi : IGestionRestauranteAppi
    {
        public RegistrarRestaruanteResponse RegistrarRestaurante(RegistrarRestaruanteRequest request) {

            RegistrarRestaruanteResponse resutl = new RegistrarRestaruanteResponse();
            resutl.Operacion = new Base.Contracts.Operacion();
            resutl.Operacion.codigo_operacion = "001";
            resutl.Operacion.mensaje_operacion = "La conexon con la base de dattos esta pendiente";
            resutl.Operacion.ErrorManager = new Base.Contracts.Error();
            resutl.Operacion.ErrorManager.error_numero = 0;
            resutl.Restuarantes = new Restaurante();

            return resutl;
        }
      public  RegistrarSuscriptorResponse RegistrarSuscritor(RegistrarSuscriptorRequest request) {

            RegistrarSuscriptorResponse resutl = new RegistrarSuscriptorResponse();
            resutl.Operacion = new Base.Contracts.Operacion();
            resutl.Operacion.codigo_operacion = "002";
            resutl.Operacion.mensaje_operacion = "La conexon con la base de datoss esta pendiente";
            resutl.Operacion.ErrorManager = new Base.Contracts.Error();
            resutl.Operacion.ErrorManager.error_numero = 0;

            resutl.Suscriptor = new Suscriptor();

            return resutl;

        }

    }
}
