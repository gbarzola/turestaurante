using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{
    [DataContract]
    public class FormaPago
    {
        [DataMember]
        public bool EsDebito { get; set; }
        [DataMember]
        public bool EsCredito { get; set; }
    }
}
