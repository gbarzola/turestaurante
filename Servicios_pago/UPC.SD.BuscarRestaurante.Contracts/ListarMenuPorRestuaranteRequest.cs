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
    public class ListarMenuPorRestuaranteRequest
    {
        [DataMember]
        public DateTime FechaSolicitud { get; set; }
        [DataMember]
        public Restaurante Restuarantes { get; set; }
    }
}
