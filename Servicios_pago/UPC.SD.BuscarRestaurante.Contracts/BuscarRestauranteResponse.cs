using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using UPC.SD.Base.Contracts;
using UPC.SD.BaseEntidad.Contracts;

namespace UPC.SD.BuscarRestaurante.Contracts
{
    [DataContract]
    public class BuscarRestauranteResponse
    {
        [DataMember]
        public Operacion Operacion { get; set; }
        [DataMember]
        public List<Restaurante> ListaRestuarantes { get; set; }
    }
}
