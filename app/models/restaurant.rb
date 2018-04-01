class Restaurant < ActiveRecord::Base
	has_many :sedes, dependent: :destroy
	validates :razon_social, presence: true, length: {minimum: 5}
	validates :ruc,  presence: true
end
