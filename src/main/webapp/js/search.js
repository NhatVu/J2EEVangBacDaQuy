/**
 * 
 */

function searchNews(config) {
	// SearchService?offset=0&query=nhận%20định&searchFromDate=1-1-2016&searchToDate=23-2-2017
	var url = config.contextPath + '/SearchService?source=' + config.source + '&offset=' + config.offset
			+ '&sortBy=' + config.sortBy + "&decs=" + config.decs
			+ "&searchFromDate=" + config.searchFromDate + "&searchToDate="
			+ config.searchToDate + "&query="
			+ encodeURIComponent(config.query)
	url = decodeURIComponent(url)
	$.ajax({
		url : url,
		type : "get",
		dataType : "json",
		success : function(data, textStatus, jqXHR) {
			// since we are using jQuery, you don't need to parse response
			config.isLoad = true;
			drawTable(data, config);
		}
	});
}

function drawTable(data, config) {
	for (var i = 0; i < data.length; i++) {
		drawRow(data[i], config.NO);
		config.NO += 1
	}
}

function drawRow(liData, numberOder) {
	var li = $("<li />")
	$(".search-result").append(li);

	li.append($("<p><a target='_blank' href='https://twitter.com/statuses/"
			+ liData.tweetID + "'><b>" + liData.tweetContent + "</b></a></p>"))
	li.append($("<p> Nguồn: " + liData.source + ", Thể loại: "
			+ liData.category + ", Thời gian: " + liData.postDate
			+ ", <span class='hightlight'>Nhãn hot news: " + liData.breakingLabel
			+ ", Độ hot: " + liData.probabilityForYes + "</span></p>"));
	li.append($("<hr class='hr-black'>"));

}

function handleSelectChange(config) {
	// clear table
	$(".search-result ").empty();
	config.offset = 0

	var elementName = event.target.name;
	var elementValue = event.target.value;
	switch (elementName) {
	case "source":
		config.source = elementValue
		break;
	case "category":
		config.category = elementValue
		break;
	case "dateRange":
		getDateFromDateRange(elementValue, config)
		break;
	// case "sortBy":
	// if (elementValue == "yes")
	// config.sortBy = "probabilityForYes"
	// else
	// config.sortBy = "probabilityForNo"
	// break;
	case "probabilityForYes":
		if (elementValue == "desc")
			config.decs = "TRUE"
		else
			config.decs = "FALSE"
		break;

	}

	config.NO = 0;
	config.isLoad = true
	console.log("config: ", config)
	searchNews(config);
}

function getDateFromDateRange(value, config) {
	switch (value) {
	case "all":
		config.searchToDate = moment().format("DD-MM-YYYY")
		config.searchFromDate = "1-1-1970"
		break;
	case "past24hours":
		config.searchToDate = moment().format("DD-MM-YYYY")
		config.searchFromDate = moment().subtract(1, "days").format(
				"DD-MM-YYYY")
		break;
	case "past7days":
		config.searchToDate = moment().format("DD-MM-YYYY")
		config.searchFromDate = moment().subtract(7, "days").format(
				"DD-MM-YYYY")
		break;
	case "past30days":
		config.searchToDate = moment().format("DD-MM-YYYY")
		config.searchFromDate = moment().subtract(30, "days").format(
				"DD-MM-YYYY")
		break;
	case "past12months":
		config.searchToDate = moment().format("DD-MM-YYYY")
		config.searchFromDate = moment().subtract(1, "years").format(
				"DD-MM-YYYY")
		break;
	}
}

function onSubmitHandle() {
	event.preventDefault();
	$(".search-result ").empty();
	config.offset = 0
	config.isLoad = true
	config.query = $("#query").val();
	searchNews(config)
}

function getUrlParameter()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}