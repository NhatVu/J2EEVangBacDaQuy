/**
 * This js file use for show hot news jsp file
 */
function nFormatter(t) {
    if (t >= 1000000000) {
        return (t / 1000000000).toFixed(1).replace(/\.0$/, '') + 'G'
    };
    if (t >= 1000000) {
        return (t / 1000000).toFixed(1).replace(/\.0$/, '') + 'M'
    };
    if (t >= 1000) {
        return (t / 1000).toFixed(1).replace(/\.0$/, '') + 'K'
    };
    return Math.round(t)
};

function renderChart(t, a, e, n) {
    $(t).highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: e
        },
        xAxis: {
            categories: a['date']
        },
        yAxis: {
            title: {
                text: 'Number'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: !0,
                    formatter: function() {
                        return nFormatter(this.y)
                    }
                },
                enableMouseTracking: !0
            }
        },
        series: [
            {
                name: n,
                data: a['count']
            }
        ]
    })
};

function renderTwoChart(t, a, e, n, i, r) {
    $(t).highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: n
        },
        xAxis: {
            categories: a['date']
        },
        yAxis: {
            title: {
                text: 'Number'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: !0,
                    formatter: function() {
                        return nFormatter(this.y)
                    }
                },
                enableMouseTracking: !0
            }
        },
        series: [
            {
                name: i,
                data: a['count'],
                color: '#e0245e'
            }, {
                name: r,
                data: e['count'],
                color: '#17bf63'
            }
        ]
    })
};

function loadHotNews(config) {
    $.ajax({
        url: config.contextPath + '/editor/ShowHotNewsService?offset=' + config.offset + '&sortBy=' + config.sortBy + "&desc=" + config.desc + "&date=" + config.selectedDate + "&source=" + config.source + '&category=' + config.category,
        type: "get",
        dataType: "json",
        success: function(data, textStatus, jqXHR) {
            // since we are using jQuery, you don't need to parse response
        	if(data.error == false){
        		
            config.isLoad = true;
            drawTable(data.data, config);
        	}else{
        		alert(data.message);
        	}
        }
    });
}

function drawTable(data, config) {
    for (var i = 0; i < data.length; i++) {
        drawRow(data[i], config.NO);
        config.NO += 1
    }
}

function drawRow(rowData, numberOder) {
    var row = $("<tr />")
    $(".show-hot-news tbody").append(row); // this will append tr element to
    // table... keep its reference for a
    // while since we will add cels into
    // it
    row.append($("<td class='text-center'>" + (numberOder + 1) + "<br/> <label id='viewTrend-" + rowData.tweetID + "' + class='label label-info' style='cursor: pointer' >View Trend</label> </td>"));
    row.append($("<td><a target='_blank' href='https://twitter.com/statuses/" + rowData.tweetID + "'>" + rowData.tweetContent + "</a></td>"));
//    row.append($("<td>" + rowData.category + "</td>"));
    row.append($("<td><label class='label label-danger'>Nóng</lable></td>"));
    row.append($("<td>" + rowData.probabilityForYes.toFixed(2) + "</td>"));
    row.append($("<td>" + rowData.postDate + "</td>"));
    row.append($("<td>" + rowData.source + "</td>"));

    var combo = $("<select class='form-control' ></select>")
    combo.append("<option  value='2'> Nóng </option>");
    combo.append("<option  value='1'> Không </option>");
    combo.append("<option  value='0'> Không liên quan</option>");

    combo.bind('change', rowData, function(event) {
        handleFeedbackChange(event)
    })
    var viewTrendId = $("#viewTrend-" + rowData.tweetID);
    viewTrendId.bind('click', rowData, function(event) {
        viewTrend(event);
    })
    row.append($('<td></td>').append(combo));
    if (rowData.feedback == "Có")
        $("option[value='2']", combo).attr("selected", "selected")
    else if (rowData.feedback == "Không")
        $("option[value='1']", combo).attr("selected", "selected")
     else if (rowData.feedback == "Không liên quan")
        $("option[value='0']", combo).attr("selected", "selected")
}

function handleSelectChange(config) {
    // clear table
    $(".show-hot-news tbody").empty();
    config.offset = 0
    config.NO = 0;
    config.isLoad = true

    var elementName = event.target.name;
    var elementValue = event.target.value;

    switch (elementName) {
        case "probabilityForYes":
            if (event.target.value == "desc")
                config.desc = "TRUE"
            else
                config.desc = "FALSE"
            break;
        case "category":
            config.category = elementValue
            break;
        case "source":
            config.source = elementValue
            break;
    }

    loadHotNews(config);
}

// change feedback
function handleFeedbackChange(event) {
    //updateFeedback
    $.ajax({
        url: config.contextPath + "/editor/ShowHotNewsService/UpdateFeedback?tweetID=" + event.data.tweetID + "&feedback=" + event.target.value,
        type: "get",
        dataType: "json",
        success: function(data, textStatus, jqXHR) {},
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(thrownError);
        }
    });
}

function reloadHotNews(config) {
    // clear table
    $(".show-hot-news tbody").empty();

    config.offset = 0
    config.NO = 0;
    config.isLoad = true
    loadHotNews(config);
}

function viewTrend(event) {
    title = 'Favorite & Retweet';
    titleData1 = 'Favority';
    titleData2 = 'Retweet';
    $.ajax({
        url: '/eds/editor/viewTrend?TweetId=' + event.data.tweetID,
        type: 'GET',
        async: false,
        success: function(data) {
            if (data.error == false) {
                renderTwoChart('#chart-favorite-retweet', data.data[0], data.data[1], title, titleData1, titleData2);
            }
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(thrownError);
        }
    });
    $("#modalShowTrend").modal('show');
}
