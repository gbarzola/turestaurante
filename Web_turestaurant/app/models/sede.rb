class Sede < ActiveRecord::Base
  belongs_to :restaurant
  has_many :platos
end
