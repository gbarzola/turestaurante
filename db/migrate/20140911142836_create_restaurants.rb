class CreateRestaurants < ActiveRecord::Migration[4.2]
  def change
    create_table :restaurants do |t|
      t.string :razon_social
      t.integer :ruc, :limit => 15
      t.string :categoria

      t.timestamps
    end
  end
end
