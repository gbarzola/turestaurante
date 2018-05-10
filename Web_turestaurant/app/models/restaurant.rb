class Restaurant < ActiveRecord::Base
	has_many :sedes, dependent: :destroy
	
	validates :razon_social, presence: true, length: {minimum: 5}
	validates :ruc,  presence: true
	
	has_attached_file :avatar, styles: { medium: "300x300", thumb: "100x100" }
	validates_attachment_content_type :avatar, content_type: /\Aimage\/.*\Z/
	
	def avatar_url
        avatar.url(:medium)
    end
    
end
