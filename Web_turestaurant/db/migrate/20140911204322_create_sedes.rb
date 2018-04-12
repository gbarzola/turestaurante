class CreateSedes < ActiveRecord::Migration[4.2]
  def change
    create_table :sedes do |t|
      t.string :direccion
      t.integer :cantidad_de_mesas
      t.string :latitud
      t.string :longitud

      t.timestamps
    end
  end
end
