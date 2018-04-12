class Api::V1::SedesController < ApplicationController
    def index
        restaurant = Restaurant.find(params[:restaurant_id])
		sede = restaurant.sedes.order("created_at DESC")
        render json: {status: 'Exitoso', message: 'Lista de sedes', data: sede}, status: :ok
    end
    
    def show
        restaurant = Restaurant.find(params[:restaurant_id])
        sede = restaurant.sedes.find(params[:id])

        render json: {status: 'Exitoso', message: 'Sede encontrada', data: sede}, status: :ok
    end
    
    private
    
    def sede_params
        params.permit(:direccion, :cantidad_de_mesas, :latitud, :longitud)
    end
end