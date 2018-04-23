class CreatePlatos < ActiveRecord::Migration[5.1]
  def change
    create_table :platos do |t|
      t.string :nombre_plato
      t.float :precio_plato
      t.string :categoria_plato
      t.text :descripcion_plato
      t.integer :cantidad_porciones

      t.timestamps
    end
  end
end
