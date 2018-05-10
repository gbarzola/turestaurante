class AddAvatarToRestaurants < ActiveRecord::Migration[5.1]
  def up
    add_attachment :restaurants, :avatar
  end
 
  def down
    remove_attachment :restaurants, :avatar
  end
end
