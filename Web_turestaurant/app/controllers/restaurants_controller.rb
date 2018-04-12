class RestaurantsController < ApplicationController
	before_action :authenticate_user!, except: [:index, :show]

	def index
		@restaurants = Restaurant.all.order('created_at DESC')
	end

	def new
		@restaurant = Restaurant.new
	end

	def show
		@restaurant = Restaurant.find(params[:id])
	end

	def create
		@restaurant = Restaurant.new(restaurant_params)

		if @restaurant.save
			redirect_to @restaurant
		else
			render 'new'
		end
	end

	def edit
		@restaurant = Restaurant.find(params[:id])
	end

	def update
		@restaurant = Restaurant.find(params[:id])

		if @restaurant.update(params[:restaurant].permit(:razon_social, :ruc, :categoria))
			redirect_to @restaurant
		else
			render 'edit'
		end
	end

	def destroy
		@restaurant = Restaurant.find(params[:id])
		@restaurant.destroy

		redirect_to restaurants_path
	end

	private

	def restaurant_params
		params.require(:restaurant).permit(:razon_social, :ruc, :categoria)
	end
end
