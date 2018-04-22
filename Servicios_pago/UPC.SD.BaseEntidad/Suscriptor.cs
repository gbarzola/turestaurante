using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{
    [DataContract]
    public class Suscriptor
    {
        [DataMember]
        public string CodigoSuscriptor { get; set; }
        [DataMember]
        public string Nombre { get; set; }
        [DataMember]
        public string Password { get; set; }

        [DataMember]
        public List<Restaurante> ListaRestaurante { get; set; }
    }
}
