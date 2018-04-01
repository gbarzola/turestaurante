class CreateMenus < ActiveRecord::Migration[5.1]
  def change
    create_table :menus do |t|
      t.string :titulo
      t.text :descripcion
      t.integer :precio
      t.integer :cantidad_de_porciones

      t.timestamps
    end
  end
end
