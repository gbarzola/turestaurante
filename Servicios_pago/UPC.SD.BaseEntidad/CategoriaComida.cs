using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.BaseEntidad.Contracts
{

    [DataContract]
    public class CategoriaComida
    {

        [DataMember]
        public string CodigoCategoriaComida {get; set;}
        [DataMember]
        public string NombreCategoriaComida { get; set; }


    }
}
