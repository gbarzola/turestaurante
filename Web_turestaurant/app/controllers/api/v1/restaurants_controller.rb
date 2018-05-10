class Api::V1::RestaurantsController < ApplicationController
    
    skip_before_action :verify_authenticity_token
    
    def index
        restaurants = Restaurant.order("created_at DESC")
        render json: {status: 'Exitoso', message: 'Lista de Restaurants', data: restaurants}, status: :ok

    end
    
    def show
        restaurant = Restaurant.find(params[:id])
        render json: {status: 'Exitoso', message: 'Restaurants cargados', data: restaurant}, status: :ok
    end
    
    def create
        restaurant = Restaurant.new(restaurant_params)
        
        if restaurant.save
            render json: {status: 'Exitoso', message: 'Restaurant creado', data: restaurant}, status: :ok
            
        else
            render json: {status: 'Error', message: 'No se grabo restaurant', data: restaurant.errors}, status: :unprocessable_entity
        end

    end
    
    def destroy
        restaurant = Restaurant.find(params[:id])
        restaurant.destroy
        render json: {status: 'Exitoso', message: 'Restaurant borrado', data: restaurant}, status: :ok
    end
    
    def update
        restaurant = Restaurant.find(params[:id])
        
        if restaurant.update_attributes(restaurant_params)
            render json: {status: 'Exitoso', message: 'Restaurant actualizado', data: restaurant}, status: :ok
        else
            render json: {status: 'Error', message: 'No se actualizo restaurant', data: restaurant.errors}, status: :unprocessable_entity
        end
    end
    
    private
    
    def restaurant_params
        params.permit(:id, :razon_social, :ruc, :categoria, :avatar)
    end
    
end