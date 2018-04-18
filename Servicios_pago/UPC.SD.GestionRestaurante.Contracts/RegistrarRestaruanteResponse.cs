using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

using UPC.SD.Base.Contracts;
using UPC.SD.BaseEntidad.Contracts;


namespace UPC.SD.GestionRestaurante.Contracts
{

    [DataContract]
    public class RegistrarRestaruanteResponse
    {
        [DataMember]
        public Operacion Operacion { get; set; }
        [DataMember]
        public Restaurante Restuarantes { get; set; }
        
    }
}
