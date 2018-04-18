using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;

namespace UPC.SD.UtlitarioCommon
{
    public static class OperacionConfiguracion
    {
        public static string operacion_pago_servicio
        {

            get
            {
                return ConfigurationManager.AppSettings["operacion_pago_servicio"].ToString();

            }
        }
        public static string operacion_pago_servicio_mensaje
        {

            get
            {
                return ConfigurationManager.AppSettings["operacion_pago_servicio_mensaje"].ToString();

            }
        }

        public static string tipo_operacion_pago_servicio
        {

            get
            {
                return ConfigurationManager.AppSettings["tipo_operacion_pago_servicio"].ToString();

            }
        }
    }
    public  class Estado
    {
        public static string OK
        {

            get
            {
                return "0";

            }
        }
        public static int ErrorFuncional
        {

            get
            {
                return 1;

            }
        }
        public static int ErrorTecnico
        {

            get
            {
                return -1;

            }
        }

    }

    public  class EstadoOperacion : Estado
    {
     

    }
    public  class EstadoError : Estado
    {


    }



    public class EstadoEnum {


        public enum EstadoOperacion {

            OK=0,
            ErrorFuncional = 1,
            ErrorTecnico = -1,


        }

        public enum EstadoError
        {

            OK = 0,
            ErrorFuncional = 1,
            ErrorTecnico = -1,
           

        }

    }
}
