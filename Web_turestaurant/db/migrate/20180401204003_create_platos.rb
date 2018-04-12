class CreatePlatos < ActiveRecord::Migration[5.1]
  def change
    create_table :platos do |t|
      t.string :titulo
      t.text :descripcion
      t.integer :precio
      t.integer :stock_de_porciones
      t.string :estado
      
      t.timestamps
    end
  end
end
