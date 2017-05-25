/**
 * 
 */
// var hotNormalNewsChart = null;
var topNKeywordsChart = null;
Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function(color) {
    return {
        radialGradient: {
            cx: 0.5,
            cy: 0.3,
            r: 0.5
        },
        stops: [
            [
                0, color
            ],
            [1, Highcharts.Color(color).brighten(-0.2).get('rgb')] // darken
        ]
    };
});
function pieChartJson(data) {
    var chart = {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false
    };
    var title = {
        text: ""
    };
    var tooltip = {
        pointFormat: '<b>{point.percentage:.1f}%</b>'
    };
    var plotOptions = {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name} </b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                },
                style: {
                    width: '100px'
                }
            }
        }
    };
    var series = [
        {
            type: 'pie',
            // name: 'Browser share',
            data: data.map((value) => {
                return {name: value.keyword, y: value.count}
            })
        }
    ];
    // Radialize the colors

    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.series = series;
    json.plotOptions = plotOptions;

    return json;
}
function drawHotNormalNewsChart(config) {
    // data = [{label : "Accident", "hot" : 12, "normal" : 4}]
    var url = config.contextPath + "/editor/StatisticsService?type=hotNormalNews&fromDate=" + config.fromDate + "&toDate=" + config.toDate + "&source=" + config.source
    $.ajax({
        url: url,
        type: "get",
        dataType: "json",
        success: function(data, textStatus, jqXHR) {
            // since we are using jQuery, you don't need to parse response
        	var chart = $("#hotNormalNewsChart")
        	if(data.error == true){
        		alert(data.message)
        		if (chart.highcharts())
                    chart.highcharts().series[0].setData([])
        	}
        	else{
        		
            config.isLoad = true;
//            if (data == "") {
//                if (chart.highcharts())
//                    chart.highcharts().series[0].setData([])
//                return
//            }

            // data = JSON.parse(data)
            data = data.data;
            data = data.map((value) => {
                return {keyword: value.category, count: value.hot}
            })
            if (chart.highcharts()) {
                data = data.map((value) => {
                    return {name: value.keyword, y: value.count}
                })
                chart.highcharts().series[0].setData(data)
            } else
                chart.highcharts(pieChartJson(data))
        	}
        }
    });
}

// pie chart
function randomScalingFactor() {
    return Math.round(Math.random() * 100);
};
function randomColorFactor() {
    return Math.round(Math.random() * 255);
};
function randomColor(opacity) {
    return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',' + (opacity || '.3') + ')';
};

// draw top N keyword chart
function drawTopNKeywordsChart(config) {
    // data = [{label : "Accident", "hot" : 12, "normal" : 4}]
    var url = config.contextPath + "/editor/StatisticsService?type=topNKeywords&source=" + config.source + "&n=" + config.n + "&dateRange=" + config.dateRange
    $.ajax({
        url: url,
        type: "get",
        dataType: "json",
        success: function(data, textStatus, jqXHR) {
            // since we are using jQuery, you don't need to parse response
        	var chart = $("#topNKeywordsChart")
        	if(data.error == true){
        		alert(data.message)
        		if (chart.highcharts())
                    chart.highcharts().series[0].setData([])
        	}
        	else {
            config.isLoad = true;
//            if (data == "") {
//                if (chart.highcharts())
//                    chart.highcharts().series[0].setData([])
//                return
//            }
            // data = JSON.parse(data);
            data = data.data;
            if (chart.highcharts()) {
                data = data.map((value) => {
                    return {name: value.keyword, y: value.count}
                })
                chart.highcharts().series[0].setData(data)
            } else {
                var configChart = pieChartJson(data);
                configChart.series[0].point = {};
                configChart.series[0].point = {
                    events: {
                        click: function(event) {
                            config.term = this.name
                            loadRelatedNewsWithTopNKeywords(config)
                        }
                    }
                }
                chart.highcharts(configChart)
            }
        	}
        }
    })
}

// / select source event
function handleSelectChange(config) {
    // select source
    config.source = event.target.value;
    drawHotNormalNewsChart(config);
    drawTopNKeywordsChart(config);
}
/*
 * TOP N keywords
 */
// handle top N keyword form submit
function topNKeywordFormSubmit(config) {
    event.preventDefault()
    var n = $("#topNKeywordsInput").val();
    if (isNaN(Number(n))) {
        alert("You must enter number");
        return
    }
    $("#topNKeywordsTitle").html("Top " + n + " keywords")
    config.n = n
    drawTopNKeywordsChart(config);
}

// handle date range change
function handleDateRangeChange(config) {
    config.dateRange = event.target.value;
    drawTopNKeywordsChart(config);
}

function loadRelatedNewsWithTopNKeywords(config) {
    var url = config.contextPath + "/editor/StatisticsService/RelatedNews?source=" + config.source + "&offset=" + config.offset + "&dateRange=" + config.dateRange + "&term=" + config.term;
    $.ajax({
        url: url,
        type: "get",
        dataType: "json",
        success: function(data, textStatus, jqXHR) {
            // since we are using jQuery, you don't need to parse response
        	if(data.error == true)
        		alert(data.message)
        	else{
        		
            config.isLoad = true;
            drawTable(data.data, config);
        	}
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(thrownError);
        }
    })
    $("#modalNewsRelatedTopNKeywords").modal("show")
}

function drawTable(data, config) {
    for (var i = 0; i < data.length; i++) {
        drawRow(data[i], config.NO);
        config.NO += 1
    }
}

function drawRow(rowData, numberOder) {
    var row = $("<tr />")
    $(".show-related-news tbody").append(row); // this will append tr element
												// to
    // table... keep its reference for a
    // while since we will add cels into
    // it
    row.append($("<td class='text-center'>" + (numberOder + 1) + "</td>"));
    row.append($("<td><a target='_blank' href='https://twitter.com/statuses/" + rowData.tweetID + "'>" + rowData.tweetContent + "</a></td>"));
// row.append($("<td>" + rowData.category + "</td>"));
    row.append($("<td><label class='label label-danger'>Nóng</lable></td>"));
    row.append($("<td>" + rowData.probabilityForYes.toFixed(2) + "</td>"));
    row.append($("<td>" + rowData.postDate + "</td>"));
    row.append($("<td>" + rowData.source + "</td>"));
}

$('#modalNewsRelatedTopNKeywords').on('hidden.bs.modal', function() {
    // do something…
    config.NO = 0;
    $(".show-related-news tbody").empty()
})
