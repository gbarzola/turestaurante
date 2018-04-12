class AddRestaurantIdToSede < ActiveRecord::Migration[5.1]
  def change
    add_column :sedes, :restaurant_id, :integer
  end
end
