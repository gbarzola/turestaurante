using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;

namespace UPC.SD.Base.Contracts
{
    [DataContract]
    public class FiltroOutPut
    {
        [DataMember]
        public int total_registro {get;set;}
   
  
    }
}
