class Api::V1::PlatosController < ApplicationController
    def index
        sede = Sede.find(params[:sede_id])
		plato = sede.platos.order("created_at DESC")
        render json: {status: 'Exitoso', message: 'Lista de platos', data: plato}, status: :ok
    end
    
    def show
        sede = Sede.find(params[:sede_id])
        plato = sede.platos.find(params[:id])

        render json: {status: 'Exitoso', message: 'Plato encontrado', data: plato}, status: :ok
    end
    
end