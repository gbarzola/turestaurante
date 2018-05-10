# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

Restaurant.create(razon_social: 'Central', ruc: 81831034, categoria: 'Amazonica')
Restaurant.create(razon_social: 'Circulo', ruc: 66831065, categoria: 'Amazonica')
Restaurant.create(razon_social: 'Tacacho', ruc: 81881023, categoria: 'Amazonica')
Restaurant.create(razon_social: 'Platano&Coco', ruc: 11131990, categoria: 'Amazonica')
Restaurant.create(razon_social: 'Surii', ruc: 81831077, categoria: 'Amazonica')
Restaurant.create(razon_social: 'Tacataca', ruc: 99831000, categoria: 'Amazonica')


user = User.new
user.email = 'persona@example.com'
user.password = '123456789'
user.password_confirmation = '123456789'
user.save!

user = User.new
user.email = 'persona1@example.com'
user.password = '123456789'
user.password_confirmation = '123456789'
user.save!

user = User.new
user.email = 'persona2@example.com'
user.password = '123456789'
user.password_confirmation = '123456789'
user.save!

user = User.new
user.email = 'persona3@example.com'
user.password = '123456789'
user.password_confirmation = '123456789'
user.save!

user = User.new
user.email = 'persona4@example.com'
user.password = '123456789'
user.password_confirmation = '123456789'
user.save!