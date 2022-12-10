// create the map
var iframe = window.frames['my-iframe'];
iframe = new ol.Map({
    target: 'map',
    layers: [
        new ol.layer.Tile({
            source: new ol.source.OSM()
        })
    ],
    view: new ol.View({
        center: [0, 0],
        zoom: 2
    })
});

// create the line and add it to the map
var line = new ol.geom.LineString([[-122.4194, 37.7749], [-74.0060, 40.7128]]);
var vector = new ol.layer.Vector({
    source: new ol.source.Vector({
        features: [new ol.Feature(line)]
    }),
    style: new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: '#0000ff',
            width: 2
        })
    })
});
iframe.addLayer(vector);
