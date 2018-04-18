using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using UPC.SD.Base.Contracts;
using UPC.SD.BaseEntidad.Contracts;
using UPC.SD.PagoServicio.Contracts;
using UPC.SD.UtlitarioCommon;

namespace UPC.SD.PagoServicio.BL
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "Service1" en el código y en el archivo de configuración a la vez.

    public class PagoServicio : IPagoServicio
    {
        public PagarServicioResponse PagarServicio(PagarServicioRequest request) {


            var Result = new PagarServicioResponse();
            Result.Operacion = new Operacion();
            Result.Operacion.codigo_operacion = OperacionConfiguracion.operacion_pago_servicio;
            Result.Operacion.estado_operacion =EstadoOperacion.OK;
            Result.Operacion.mensaje_operacion = OperacionConfiguracion.operacion_pago_servicio_mensaje;
            Result.Operacion.tipo_operacion = OperacionConfiguracion.tipo_operacion_pago_servicio;
            Result.Operacion.fecha_operacion = DateTime.Now;
           Result.Operacion.ErrorManager = new Error();
            Result.Operacion.ErrorManager.error_numero =Convert.ToInt32( EstadoError.OK);
            Result.Usuario = new Usuario();
            Result.Usuario.NumeroDNI = request.NumeroDNI;
            Result.Usuario.NombreUsuario = "Jhovny Flores Ninaco";
            Result.Usuario.CodigoUsuario = 1111111;
            Result.CuentaUsuario = new CuentaUsuario();
            Result.CuentaUsuario.CodigoCuenta = 123123;
            Result.CuentaUsuario.CodigoUsuario = 1111111;
            Result.CuentaUsuario.NumeroCuenta = "234-2323-232";
            Result.CuentaUsuario.Saldo = 4500;


            return Result;
        }

    }
}
