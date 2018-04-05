Rails.application.routes.draw do
  
  namespace :api do
    namespace :v1 do
      resources :restaurants do
      	resources :sedes
      	resources :platos
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
