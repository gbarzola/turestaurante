
class RestaurantsController < ApplicationController
	before_action :authenticate_user!, except: [:index, :show]
	
	# @urlstring_to_post = 'http://jfloresninaco-001-site2.etempurl.com/mensajeria/Api/Restaurante/'
	
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
		
		respond_to do |format|
	      if @restaurant.save
	        format.html { redirect_to @restaurant, notice: 'Restaurant was successfully created.' }
	        format.json { render :json => @restaurant.to_json(:only => [:razon_social, :ruc, :categoria], :methods => [:avatar_url]) }
	    	# @result = HTTParty.post(@urlstring_to_post.to_str, 
    		# :body => {  :titulo => 'Titulo', 
      #      			:contenido => 'Se creo un restaurant'}.to_json,
    		# :headers => { 'Content-Type' => 'application/json' } )
	      
	      else
	        format.html { render :new }
	        format.json { render json: @restaurant.errors, status: :unprocessable_entity }
	      end
    	end
		
	end

	def edit
		@restaurant = Restaurant.find(params[:id])
	end

	def update
		@restaurant = Restaurant.find(params[:id])
		
		respond_to do |format|
	      if @restaurant.update(restaurant_params)
	        format.html { redirect_to @restaurant, notice: 'Plato was successfully updated.' }
	        format.json { render :json => @restaurant.to_json(:only => [:razon_social, :ruc, :categoria], :methods => [:avatar_url]) }
	      else
	        format.html { render :edit }
	        format.json { render json: @restaurant.errors, status: :unprocessable_entity }
	      end
    	end
	end

	def destroy
		@restaurant = Restaurant.find(params[:id])
		@restaurant.destroy

		redirect_to restaurants_path
	end

	private

	def restaurant_params
		params.require(:restaurant).permit(:razon_social, :ruc, :categoria, :avatar)
	end
end
