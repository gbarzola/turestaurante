using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace UPC.SD.Base.Contracts
{
    [DataContract]
    public class FiltroInput
    {
        [DataMember]
        public int registro_inicio {get;set;}
        [DataMember]
        public int regsitro_fin { get; set; }
      
  
    }
}
