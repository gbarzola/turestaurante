using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{
    [DataContract]
    public class Usuario
    {
        [DataMember]
        public int CodigoUsuario { get; set; }
        [DataMember]
        public string NombreUsuario { get; set; }
        [DataMember]
        public string CorreoUsuario { get; set; }
        [DataMember]
        public string Password { get; set; }
        [DataMember]
        public string NumeroDNI { get; set; }


    }
}
