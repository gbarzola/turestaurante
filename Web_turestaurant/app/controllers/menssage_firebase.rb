class MessageFirebase
    
    attr_reader :titulo, :contenido
    
    def initialize(msg)
        client = Savon.client(wsdl: 'http://jfloresninaco-001-site2.etempurl.com/mensajeriasoap/Mensajeria.svc?wsdl')
        mensaje = {"Contenido" => msg}
        respuesta = client.call(:enviar_mensaje, message: mensaje)
        if respuesta.success?
            data = respuesta.to_array(:enviar_mensajeResponse, :MensajeRequest, :MensajeResponse).first
            if data
                @titulo = data[:titulo]
                @mensaje = data[:mensaje]
            end
        end
    end
end