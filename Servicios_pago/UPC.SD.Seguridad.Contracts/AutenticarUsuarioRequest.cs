using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using UPC.SD.BaseEntidad.Contracts;

namespace UPC.SD.Seguridad.Contracts
{
    [DataContract]
    public class AutenticarUsuarioRequest
    {
        [DataMember]
        public DateTime FechaSolicitud { get; set; }
        [DataMember]
        public Usuario Restuarantes { get; set; }
    }
}
