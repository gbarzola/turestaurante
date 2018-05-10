# Place all the behaviors and hooks related to the matching controller here.
# All this logic will automatically be available in application.js.
# You can use CoffeeScript in this file: http://coffeescript.org/

jQuery ->
    sedes = $('#plato_sede_id').html()
    console.log(sedes)
    
    # $('#plato_restaurant_id').change ->
    # restaurant = $('#plato_restaurant_id :selected').text()
    # options = $(sedes).filter("optgroup[label='#{restaurant}']").html()
    # if options
    #     $('plato_sede_id').html(options)
    # else
    #     $('plato_sede_id').empty()        
    