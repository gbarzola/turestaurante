class Api::V1::UsersController < ApplicationController
    
    skip_before_action :verify_authenticity_token
    
    def index
        users = User.order("created_at DESC")
        render json: {status: 'Exitoso', message: 'Lista de usuarios', data: users}, status: :ok
    end

    def show
        user = User.find(params[:id])
        render json: {status: 'Exitoso', message: 'Usuario encontrado', data: user}, status: :ok
    end
    
    def create
        user = User.new(user_params)
        
        if user.save
            render json: {status: 'Exitoso', message: 'User creado', data: user}, status: :ok
        else
            render json: {status: 'Error', message: 'No se grabo user', data: user.errors}, status: :unprocessable_entity
        end

    end
    
    def user_params
        params.permit(:email, :encrypted_password, :created_at)
    end
    

end