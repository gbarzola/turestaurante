json.extract! plato, :id, :nombre_plato, :precio_plato, :categoria_plato, :descripcion_plato, :cantidad_porciones, :created_at, :updated_at
json.url plato_url(plato, format: :json)
