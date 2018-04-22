using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using UPC.SD.PagoServicio.Contracts;

namespace UPC.SD.PagoServicio.BL
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de interfaz "IService1" en el código y en el archivo de configuración a la vez.
    [ServiceContract(Namespace = "http://upc.sd.pagos.com", Name = "PagoServicio")]

    public interface IPagoServicio
    {
        [OperationContract]
        PagarServicioResponse PagarServicio(PagarServicioRequest request);

    }


}
