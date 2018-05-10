Rails.application.routes.draw do
  
  get 'mensajes/respuesta'

  post 'user_token' => 'user_token#create'
  resources :platos
  namespace :api do
    namespace :v1 do
      resources :users
      resources :restaurants do
        resources :sedes do   
          resources :platos
        end
      end
    end
  end
  
  devise_for :users
  resources :restaurants do
  	resources :sedes
  	resources :platos
  end

  root "restaurants#index"

  get '/about', to: 'pages#about'


end
