var ctx = document.getElementById('temp-chart');
var temperature = [];
temperature.length = 100;
temperature.fill(" ");

Chart.defaults.global.legend.display = false;
var temp_chart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: temperature,
        datasets: [{
            data: temperature,
            borderWidth: 1
        }]
    }
});

new EventSource('/temperature').onmessage = function (evt) {
    temperature.push(evt.data);
    temperature.shift();
    temp_chart.update();
};