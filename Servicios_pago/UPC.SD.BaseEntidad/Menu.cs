using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{
    [DataContract]
    public class Menu
    {
        [DataMember]
        public string codigoMenu {get; set;}
        [DataMember]
        public string NombreMenu { get; set; }
        [DataMember]
        public string CodigoRestaurante { get; set; }
        
        [DataMember]
        public CategoriaComida CategoriaComida { get; set; }
        [DataMember]
        public int Precio { get; set; }
    }
}
