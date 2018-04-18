using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using UPC.SD.Base.Contracts;
using UPC.SD.BaseEntidad.Contracts;

namespace UPC.SD.PagoServicio.Contracts
{
    [DataContract]
    public class PagarServicioResponse
    {

        [DataMember]
        public Operacion Operacion { get; set; }

        [DataMember]
        public Usuario Usuario { get; set; }

        [DataMember]
        public CuentaUsuario CuentaUsuario { get; set; }

    }
}
