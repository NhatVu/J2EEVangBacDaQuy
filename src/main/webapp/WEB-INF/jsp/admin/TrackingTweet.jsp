<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<jsp:include page="../../../layout/Header.jsp" flush="true"></jsp:include>
		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="../../../layout/LeftSideBar.jsp" flush="true"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="min-height: 916px;">
			<section class="content">
				<section class="content-header">
					<h1 class="text-center">Tracking Tweets</h1>
					<hr />
				</section>
				<div class="container">
					<div class="row" style="margin-top: 10px;">
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							<h4 style="margin-bottom: 25px !important;">
								Tracking status <span id="status" class="label label-success">Đang hoạt động!</span>
							</h4>

						</div>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							<input type="checkbox" checked data-toggle="toggle">
						</div>
					</div>
					<div class="row" style="margin-top: 10px; margin-left: 20px;">
						<div class="col-xs-11">
							<div class="chart" id="chart-group-post"></div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>
	</div>

	<script>
	$(document).ready(function() {

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
	        series: [{
	            name: n,
	            data: a['count']
	        }]
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
	        series: [{
	            name: i,
	            data: a['count'],
	            color: '#e0245e'
	        }, {
	            name: r,
	            data: e['count'],
	    	    color: '#17bf63'
	        }]
	    })
	};
	var data = [],
	    data1 = [],
	    data2 = [],
	    title = '',
	    titleData = '',
	    titleData1 = '',
	    titleData2 = '';
	data1 = {
	    'date': ['2017-04-14', '2017-04-15', '2017-04-16', '2017-04-17', '2017-04-18', '2017-04-19', '2017-04-20'],
	    'count': [3695136, 3888332, 3753607, 4096702, 4121268, 5539514, 2758759],
	    'length': 7
	};
	data2 = {
	    'date': ['2017-04-14', '2017-04-15', '2017-04-16', '2017-04-17', '2017-04-18', '2017-04-19', '2017-04-20'],
	    'count': [2849854, 2006583, 2020894, 2180229, 2370174, 5119898, 1307348],
	    'length': 7
	};
	title = 'Favorite & Retweet';
	titleData1 = 'Favority';
	titleData2 = 'Retweet';
	renderTwoChart('#chart-group-post', data1, data2, title, titleData1, titleData2);
	});
	</script>
</body>
