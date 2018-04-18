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
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de interfaz "IService1" en el código y en el archivo de configuración a la vez.
    [ServiceContract(Namespace = "http://upc.sd.turestaurante/Appi/" , Name ="GestionRestaurante")]
 
    public interface IGestionRestaurante
    {
        [OperationContract]
        RegistrarRestaruanteResponse RegistrarRestaurante(RegistrarRestaruanteRequest request);

        [OperationContract]
        RegistrarSuscriptorResponse RegistrarSuscritor(RegistrarSuscriptorRequest request);

    }


}
