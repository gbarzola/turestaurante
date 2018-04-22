using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.Base.Contracts
{
    [DataContract]
    public class Error
    {
        [DataMember]

        public int error_numero {get;set;}
        [DataMember]
        public int severidad { get; set; }
        [DataMember]
        public string descripcion { get; set; }
    }
}
