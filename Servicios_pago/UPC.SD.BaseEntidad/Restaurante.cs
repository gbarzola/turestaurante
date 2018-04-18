using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{
    [DataContract]
    public class Restaurante
    {
        [DataMember]
        public string codigoRestaurante {get; set;}
        [DataMember]
        public string NombreRestaurante { get; set; }
        [DataMember]
        public string Latitud { get; set; }
        [DataMember]
        public string Longitud { get; set; }
        [DataMember]
        public int CodigoSuscriptor { get; set; }

        [DataMember]
        public string CantidadMesas { get; set; }

        [DataMember]
        public List<Menu> ListMenu { get; set; }
        [DataMember]
        public List<CategoriaComida> ListCategoriaComida { get; set; }
    }
}
