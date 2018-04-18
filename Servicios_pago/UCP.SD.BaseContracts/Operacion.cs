using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.Base.Contracts
{
    [DataContract]
    public class Operacion
    {
        [DataMember]
        public string codigo_operacion {get;set;}
        [DataMember]
        public string estado_operacion { get; set; }
        [DataMember]
        public string tipo_operacion { get; set; }
        [DataMember]
        public string mensaje_operacion { get; set; }
        [DataMember]
        public DateTime fecha_operacion { get; set; }

        [DataMember]
        public Error ErrorManager { get; set; }

    }
}
