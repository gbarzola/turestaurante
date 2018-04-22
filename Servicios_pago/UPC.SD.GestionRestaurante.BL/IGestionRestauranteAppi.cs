using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using UPC.SD.BaseEntidad.Contracts;
using UPC.SD.GestionRestaurante.Contracts;


namespace UPC.SD.GestionRestaurante.BL
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de interfaz "IService1" en el código y en el archivo de configuración a la vez.
    [ServiceContract]
 
    public interface IGestionRestauranteAppi
    {
        [OperationContract]
        [WebInvoke(Method = "POST",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Wrapped,
        UriTemplate = "RegistrarRestaurante")]
        RegistrarRestaruanteResponse RegistrarRestaurante(RegistrarRestaruanteRequest request);

        [OperationContract]
        [WebInvoke(Method = "POST",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Wrapped,
        UriTemplate = "RegistrarSuscritor")]
        RegistrarSuscriptorResponse RegistrarSuscritor(RegistrarSuscriptorRequest request);

    }


}
