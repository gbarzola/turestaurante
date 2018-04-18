using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{
    [DataContract]
    public class PagoServicio
    {
        [DataMember]
        public int CodigoPago { get; set; }
        [DataMember]
        public Usuario Usuario { get; set; }
        [DataMember]
        public DateTime FechaPago { get; set; }
        [DataMember]
        public string NumeroPago { get; set; }
        [DataMember]
        public Decimal MontoPago { get; set; }
        [DataMember]
        public string ConceptoPago { get; set; }
    }
}