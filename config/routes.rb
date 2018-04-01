Rails.application.routes.draw do

  devise_for :users
  resources :restaurants do
  	resources :sedes
  end

  root "restaurants#index"

  get '/about', to: 'pages#about'

end
