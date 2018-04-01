function drawheart() {
    document.getElementById("heartvalue").innerHTML = valuedata[valuedata.length - 1];
    console.log(valuedata[valuedata.length - 1]);
    var data = [];
    var dataSeries = {type: "line",
        showInLegend: true,
        legendText: getuser,
        lineColor: "#243f6f",
    };
    var dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        console.log(resultdate + " " + timedata[i]);
        dataPoints.push({
            x: new Date(resultdate + " " + timedata[i]),
            y: parseInt(valuedata[i]),
        });
    }
    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    var chart = new CanvasJS.Chart(chartContainer1,
            {
                zoomEnabled: true,
                backgroundColor: "transparent",
                title: {
                    text: "心率資料圖"
                },
                axisX: {
                    labelFontColor: "black",
                    lineColor: "black",
                    gridColor: "black",
                    labelAngle: 60,
                    valueFormatString: "DD-MM-YYYY HH:mm:ss",
                    intervalType: "minute",
                    interval: 1
                },
                axisY: {
                    labelFontColor: "black",
                    lineColor: "#e2e2e2",
                    gridColor: "black",
                    includeZero: false
                },
                data: data  // random generator below

            });
    chart.render();
}
function drawgame() {
    console.log("success");
    var data = [];
    var dataSeries = {type: "line",
        showInLegend: true,
        legendText: getuser,
        lineColor: "#243f6f",
    };
    var dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        console.log(timedata[i])
        dataPoints.push({
            x: new Date(timedata[i]),
            y: parseFloat(valuedata[i]),
        });
    }
    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    var chart = new CanvasJS.Chart(chartContainer6,
            {
                zoomEnabled: true,
                backgroundColor: "transparent",
                title: {
                    text: "遊戲分數"
                },
                axisX: {
                    labelFontColor: "black",
                    lineColor: "black",
                    gridColor: "black",
                    labelAngle: 60,
                    valueFormatString: "DD-MM-YYYY HH:mm:ss",
                    intervalType: "minute",
                    interval: 1
                },
                axisY: {
                    labelFontColor: "black",
                    lineColor: "#e2e2e2",
                    gridColor: "black",
                },
                data: data  // random generator below

            });
    chart.render();
    
}
function drawcon() {
    console.log("success");
    var data = [];
    var dataSeries = {type: "line",
        showInLegend: true,
        legendText: getuser,
        lineColor: "#243f6f",
    };
    var dataPoints = [];
    for (var i = 0; i < contimedata.length; i++) {
        console.log(contimedata[i])
        dataPoints.push({
            x: new Date(contimedata[i]),
            y: parseInt(convaluedata[i]),
        });
    }
    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    var chart = new CanvasJS.Chart(chartContainer7,
            {
                zoomEnabled: true,
                backgroundColor: "transparent",
                title: {
                    text: "司機狀態"
                },
                toolTip: {
                    contentFormatter: function (e) {
                        var content = "";
                        for (var i = 0; i < e.entries.length; i++) {
                            content = CanvasJS.formatDate(e.entries[i].dataPoint.x, "HH:mm:ss MM-DD");
                        }
                        return content;
                    }
                },
                axisX: {
                    labelFontColor: "black",
                    lineColor: "black",
                    gridColor: "black",
                    labelAngle: 60,
                    valueFormatString: "DD-MM-YYYY HH:mm:ss",

                },
                axisY: {
                    labelFormatter: function (e) {
                        if (e.value == 1) {
                            return "禁止開車";
                        } else if (e.value == 2) {
                            return "保持警戒";
                        } else if (e.value == 3) {
                            return "狀況良好";
                        } else if (e.value == 4) {
                            return " ";
                        } else {
                            return "司機狀態";
                        }

                    },
                    labelFontColor: "black",
                    lineColor: "#e2e2e2",
                    gridColor: "black",
                },
                data: data  // random generator below

            });
    chart.render();
    GetStatusList();
    GetWork();
}
function drawAC() {
    document.getElementById("activityvalue").innerHTML = efficiency[0];

    CanvasJS.addColorSet("greenShades",
            [//colorSet Array

                "#243f6f",
            ]);
    var durationvalue;
    var data = [];
    var dataSeries = {type: "column",
        legendText: "Steps",
        showInLegend: true, };
    var dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        dataPoints.push({
            label: timedata[i],
            y: parseInt(valuedata[i]),
        });

    }
    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    console.log(data);
    var chart = new CanvasJS.Chart("chartContainer5",
            {
                colorSet: "greenShades",
                backgroundColor: "transparent",
                zoomEnabled: true,
                title: {
                    text: "活動步數圖",
                },
                animationEnabled: true,
                axisX: {
                    labelAngle: 60,
                    valueFormatString: "DD-MM-YYYY HH:mm:ss",
                    intervalType: "minute",
                    interval: 1,
                },
                axisY: {
                    includeZero: false
                },
                data: data  // random generator below

            });
    chart.render();
}

function drawSleep() {
    document.getElementById("sleepvalue").innerHTML = efficiency[0];
    console.log(valuedata[valuedata.length - 1]);
    var data = [];
    var dataSeries = {type: "line",
        showInLegend: true,
        legendText: getuser,
        lineColor: "#243f6f",
    };
    var dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {

        dataPoints.push({
            x: new Date(timedata[i]),
            y: parseInt(valuedata[i]),
        });
    }
    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    var chart = new CanvasJS.Chart(chartContainer2,
            {
                zoomEnabled: true,
                backgroundColor: "transparent",
                title: {
                    text: "睡眠狀態追蹤圖"
                },
                axisX: {
                    labelFontColor: "black",
                    lineColor: "black",
                    gridColor: "black",
                    labelAngle: 60,
                    valueFormatString: "DD-MM-YYYY HH:mm:ss",
                    intervalType: "minute",
                    interval: 1
                },
                axisY: {
                    labelFormatter: function (e) {
                        if (e.value == 1) {
                            return "睡著";
                        } else if (e.value == 2) {
                            return "翻身";
                        } else if (e.value == 3) {
                            return "醒來";
                        } else if (e.value == 4) {
                            return " ";
                        } else {
                            return "睡眠狀態";
                        }

                    },
                    labelFontColor: "black",
                    lineColor: "#e2e2e2",
                    gridColor: "black",
                    includeZero: false
                },
                data: data  // random generator below

            });
    chart.render();
    flag = true;
}
function draw2heart() {
    document.getElementById(lastestdata).innerHTML = valuedata[valuedata.length - 1];
    console.log(valuedata[valuedata.length - 1]);
    var data = [];
    var dataSeries = {type: "line",
        showInLegend: true,
        legendText: getuser,
        lineColor: "#243f6f",
    };
    var dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        dataPoints.push({
            x: new Date(resultdate[i] + " " + timedata[i]),
            y: parseInt(valuedata[i]),
        });
    }

    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    var chart = new CanvasJS.Chart(chartContainer1,
            {
                zoomEnabled: true,
                backgroundColor: "transparent",
                title: {
                    text: "心率資料圖"
                },
                axisX: {
                    labelFontColor: "black",
                    lineColor: "black",
                    gridColor: "black",
                    labelAngle: 60,
                    valueFormatString: "YYYY-MM-DD HH:mm:ss",
                    intervalType: "minute",
                    interval: 1
                },
                axisY: {

                    labelFontColor: "black",
                    lineColor: "#e2e2e2",
                    gridColor: "black",
                    includeZero: true
                },
                data: data  // random generator below

            });
    chart.render();

}
function draw2sleep() {
    document.getElementById(lastestdata).innerHTML = efficiency[0];
    console.log(valuedata[valuedata.length - 1]);
    var data = [];
    var dataSeries = {type: "line",
        showInLegend: true,
        legendText: getuser,
        lineColor: "#243f6f",
    };
    var dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        dataPoints.push({
            x: new Date(timedata[i]),
            y: parseInt(valuedata[i]),
        });
    }

    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    var chart = new CanvasJS.Chart(chartContainer2,
            {
                zoomEnabled: true,
                backgroundColor: "transparent",
                title: {
                    text: "睡眠狀態追蹤圖"
                },
                axisX: {
                    labelFontColor: "black",
                    lineColor: "black",
                    gridColor: "black",
                    labelAngle: 60,
                    valueFormatString: "YYYY-MM-DD HH:mm:ss",
                    intervalType: "minute",
                    interval: 1
                },
                axisY: {
                    labelFormatter: function (e) {
                        if (e.value == 1) {
                            return "睡著";
                        } else if (e.value == 2) {
                            return "翻身";
                        } else if (e.value == 3) {
                            return "醒來";
                        } else if (e.value == 4) {
                            return " ";
                        } else {
                            return "睡眠狀態";
                        }

                    },
                    labelFontColor: "black",
                    lineColor: "#e2e2e2",
                    gridColor: "black",
                    includeZero: true
                },
                data: data  // random generator below

            });
    chart.render();

}

function drawtime() {
    CanvasJS.addColorSet("greenShades",
            [//colorSet Array

                "#243f6f",
            ]);
    var durationvalue;
    var data = [];
    var dataSeries = {type: "column",
        legendText: "Times",
        showInLegend: true, };
    var dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        if (timedata[i] == "restlessCount" || timedata[i] == "awakeCount") {
            dataPoints.push({
                label: timedata[i].toString(),
                y: parseInt(valuedata[i]),
            });
        }

    }
    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    var chart = new CanvasJS.Chart("chartContainer3",
            {
                colorSet: "greenShades",
                backgroundColor: "transparent",
                zoomEnabled: true,
                title: {
                    text: "Times",
                },
                animationEnabled: true,
                axisX: {
                    labelAngle: 60,
                },
                axisY: {
                    includeZero: false
                },
                data: data  // random generator below

            });
    chart.render();
}
function draw2times() {
    var data = [];
    var dataSeries = {type: "line",
        showInLegend: true,
        legendText: "restlessCount",
        lineColor: "#243f6f",
    };
    var dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        if (timedata[i] == "restlessCount") {
            dataPoints.push({
                x: new Date(resultdate[i]),
                y: parseInt(valuedata[i]),
            });
        }
    }
    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    var dataSeries2 = {type: "line",
        showInLegend: true,
        legendText: "awakeCount",
    };
    dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        if (timedata[i] == "awakeCount") {
            dataPoints.push({
                x: new Date(resultdate[i]),
                y: parseInt(valuedata[i]),
            });
        }
    }
    dataSeries2.dataPoints = dataPoints;
    data.push(dataSeries2);
    var chart = new CanvasJS.Chart(chartContainer3,
            {
                zoomEnabled: true,
                backgroundColor: "transparent",
                title: {
                    text: "Times"
                },
                axisX: {
                    labelFontColor: "black",
                    lineColor: "black",
                    gridColor: "black",
                    labelAngle: 60,
                    valueFormatString: "YYYY-MM-DD HH:mm:ss",
                    intervalType: "minute",
                    interval: 1
                },
                axisY: {

                    labelFontColor: "black",
                    lineColor: "#e2e2e2",
                    gridColor: "black",
                    includeZero: true
                },

                data: data  // random generator below

            });
    chart.render();

}

function draw2minutes() {
    var data = [];
    var dataSeries = {type: "line",
        showInLegend: true,
        legendText: "minutesAsleep",
        lineColor: "#243f6f",
    };
    var dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        if (timedata[i] == "minutesAsleep") {
            dataPoints.push({
                x: new Date(resultdate[i]),
                y: parseInt(valuedata[i]),
            });
        }
    }
    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    var dataSeries2 = {type: "line",
        showInLegend: true,
        legendText: "minutesAwake",
    };
    dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        if (timedata[i] == "minutesAwake") {
            dataPoints.push({
                x: new Date(resultdate[i]),
                y: parseInt(valuedata[i]),
            });
        }
    }
    dataSeries2.dataPoints = dataPoints;
    data.push(dataSeries2);
    var chart = new CanvasJS.Chart(chartContainer4,
            {
                zoomEnabled: true,
                backgroundColor: "transparent",
                title: {
                    text: "Minutes"
                },
                axisX: {
                    labelFontColor: "black",
                    lineColor: "black",
                    gridColor: "black",
                    labelAngle: 60,
                    valueFormatString: "YYYY-MM-DD HH:mm:ss",
                    intervalType: "minute",
                    interval: 1
                },
                axisY: {

                    labelFontColor: "black",
                    lineColor: "#e2e2e2",
                    gridColor: "black",
                    includeZero: true
                },

                data: data  // random generator below

            });
    chart.render();

}
function drawminutes() {
    CanvasJS.addColorSet("greenShades",
            [//colorSet Array

                "#243f6f",
            ]);
    var durationvalue;
    var data = [];
    var dataSeries = {type: "column",
        legendText: "Minutes",
        showInLegend: true, };
    var dataPoints = [];
    for (var i = 0; i < timedata.length; i++) {
        if (timedata[i] == "minutesAsleep" || timedata[i] == "minutesAwake") {
            dataPoints.push({
                label: timedata[i].toString(),
                y: parseInt(valuedata[i]),
            });
        }

    }
    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);
    var chart = new CanvasJS.Chart("chartContainer4",
            {
                colorSet: "greenShades",
                backgroundColor: "transparent",
                zoomEnabled: true,
                title: {
                    text: "Minutes"
                },
                animationEnabled: true,
                axisX: {
                    labelAngle: 60,
                },
                axisY: {
                    includeZero: false
                },
                data: data  // random generator below

            });
    chart.render();
}