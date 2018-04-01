class SedesController < ApplicationController
	def create
		@restaurant = Restaurant.find(params[:restaurant_id])
		@sede = @restaurant.sedes.create(params[:sede].permit(:direccion, :cantidad_de_mesas, :latitud, :longitud))

		redirect_to restaurant_path(@restaurant)
	end

	def destroy
		@restaurant = Restaurant.find(params[:restaurant_id])
		@sede = @restaurant.sedes.find(params[:id])
		@sede.destroy

		redirect_to restaurant_path(@restaurant)
	end
end
