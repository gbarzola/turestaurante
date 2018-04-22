using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{
    [DataContract]
    public class Reserva
    {
        [DataMember]
        public int CodigoReserva { get; set; }
        [DataMember]
        public Usuario Usuario { get; set; }
        [DataMember]
        public List<Restaurante> Restaurante { get; set; }

    }
}
