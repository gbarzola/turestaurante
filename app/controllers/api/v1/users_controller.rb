class Api::V1::UsersController < ApplicationController

    def index
        users = User.order("created_at DESC")
        render json: {status: 'Exitoso', message: 'Lista de usuarios', data: users}, status: :ok
    end

    def show
        user = User.find(params[:id])
        render json: {status: 'Exitoso', message: 'Usuario encontrado', data: user}, status: :ok
    end

end