class AddSedeIdToPlatos < ActiveRecord::Migration[5.1]
  def change
    add_reference :platos, :sede, foreign_key: true
  end
end
