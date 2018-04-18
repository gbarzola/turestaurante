using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using UPC.SD.BaseEntidad.Contracts;

namespace UPC.SD.PagoServicio.Contracts
{
    [DataContract]
    public class PagarServicioRequest
    {
        [DataMember]
        public DateTime FechaSolicitud { get; set; }
        [DataMember]
        public string NumeroDNI { get; set; }

        [DataMember]
        public string NombreUsuario { get; set; }

        [DataMember]
        public string NumeroTarjeta { get; set; }

        [DataMember]
        public string ConceptoPago { get; set; }

        [DataMember]
        public decimal MontoPagar { get; set; }

        [DataMember]
        public TipoMoneda TipoMoneda { get; set; }


        [DataMember]
        public FormaPago FormaPago { get; set; }
    }

}
