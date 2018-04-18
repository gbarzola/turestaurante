using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using UPC.SD.BaseEntidad.Contracts;

namespace UPC.SD.GestionRestaurante.Contracts
{

    [DataContract]
    public class RegistrarSuscriptorRequest
    {
        [DataMember]
        public DateTime FechaSolicitud { get; set; }
        [DataMember]
        public Suscriptor Suscriptor { get; set; }

    }
}
