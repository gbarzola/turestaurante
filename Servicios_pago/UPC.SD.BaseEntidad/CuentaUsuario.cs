using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{
    [DataContract]
    public class CuentaUsuario
    {
        [DataMember]
        public int CodigoCuenta { get; set; }
        [DataMember]
        public int CodigoUsuario { get; set; }
        [DataMember]
        public string NumeroCuenta { get; set; }
  
        [DataMember]
        public decimal Saldo { get; set; }

    }
}
