var ctx = document.getElementById('temp-chart');
var temperature = [];
temperature.length = 100;
temperature.fill(" ");

//Chart.defaults.global.legend.display = false;
Chart.defaults.global.defaultFontColor = 'aqua';
var temp_chart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: temperature,
        datasets: [{
            data: temperature,
            label: " ",
            borderWidth: 1,
            borderColor: "aqua",
            backgroundColor: "transparent",
            borderWidth: 3,
            pointRadius: 0,
        }],
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true,
                    suggestedMax: 100,
                }
            }]
        },
        legend: {
            labels: {
                fontColor: 'aqua'
            }
        }
    }
});

new EventSource('/temperature').onmessage = function (evt) {
    temperature.push(evt.data);
    temperature.shift();
    temp_chart.data.datasets[0].label = evt.data+"°C"
    temp_chart.update();
};