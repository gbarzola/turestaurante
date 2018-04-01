document.addEventListener("turbolinks:load", function() {
  var map = L.map("map").setView([-12.0623, -77.0373], 15);
  
  L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
  }).addTo(map);
  
  var theMarker = {};
  
  map.on("contextmenu", function (event) {
    console.log("user right-clicked on map coordinates: " + event.latlng.toString());
    
    document.getElementById("sede_latitud").value = event.latlng.lat.toString();
    document.getElementById("sede_longitud").value = event.latlng.lng.toString();
    if (theMarker != undefined) {
        map.removeLayer(theMarker);
    };
    theMarker = L.marker(event.latlng).addTo(map);
  });
  
});