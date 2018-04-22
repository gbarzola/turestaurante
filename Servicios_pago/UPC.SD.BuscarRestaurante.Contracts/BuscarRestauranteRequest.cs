using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using UPC.SD.BaseEntidad.Contracts;

namespace UPC.SD.BuscarRestaurante.Contracts
{
    [DataContract]
    public class BuscarRestauranteRequest
    {
        [DataMember]
        public DateTime FechaSolicitud { get; set; }
        [DataMember]
        public int Latitud { get; set; }
        [DataMember]
        public int Longitud { get; set; }
        [DataMember]
        public List<CategoriaComida> CategoriaComida { get; set; }
    }
}
