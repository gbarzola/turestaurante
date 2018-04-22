using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{
    [DataContract]
    public class MovimientoCuenta
    {
        [DataMember]
        public int CodigoMovimientoCuenta { get; set; }
        [DataMember]
        public string NumeroCuenta { get; set; }
        [DataMember]
        public string TipoMovimiento { get; set; }  // D=Deposito", "R=Retiro"}
        [DataMember]
        public decimal MontoMovimiento { get; set; }

    }
}
