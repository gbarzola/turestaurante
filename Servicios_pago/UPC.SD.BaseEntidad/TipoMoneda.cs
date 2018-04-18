using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{
    [DataContract]
    public class TipoMoneda
    {
        [DataMember]
        public bool EsSoles { get; set; }
        [DataMember]
        public bool EsDolar { get; set; }
    }
}
