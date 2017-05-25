<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admicro | Dashboard</title>
</head>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<jsp:include page="../../../layout/Header.jsp" flush="true"></jsp:include>
		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="../../../layout/LeftSideBar.jsp" flush="true"></jsp:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1 class="text-center">Statistics</h1>
				<hr class="statictis-hr" />
			</section>

			<!-- Main content -->
			<section class="content" style="padding-top: 5px;">
				<div class="row">

					<div class="form-group form-inline">
						<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
							<div class="form-group statistics-source">
								<select class="form-control" name="source" id="source"
									onchange="handleSelectChange(config)">
									<option value="none">--Source--</option>
									<option value="all" selected>All</option>
									<option value="twitter">Twitter</option>
									<option value="facebook">Facebook</option>
									<option value="news">News</option>
								</select>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<hr class="statictis-hr" />
					<div class="col-md-6 col-sm-12 border-right">
						<h4>Hot News by Category</h4>
						<div class="row">
							<div class="col-md-6 col-sm-6 ">
								<div class="form-group full-width">
									<div class='input-group date full-width' id='fromDate'>
										<input type='text' class="form-control" id="fromDateInput"
											placeholder="From date" /> <span class="input-group-addon">
											<span class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>

							<div class="col-md-6 col-sm-6">
								<div class="form-group full-width" style="margin-right: 1px;">
									<div class='input-group date full-width' id='toDate'>
										<input type='text' class="form-control" id="toDateInput"
											placeholder="To date" /> <span class="input-group-addon">
											<span class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
						</div>
						<div id="hotNormalNewsChartContainer">
							<div id="hotNormalNewsChart"></div>
						</div>
						<br />
					</div>
					<div class="col-md-6 col-sm-12">
						<h4 id="topNKeywordsTitle">Top N keywords</h4>
						<div class="row">
							<div class="col-md-6">
								<select class="form-control" name="dateRange" id="dateRange"
									onchange="handleDateRangeChange(config)">
									<option value="none">--Choose date range--</option>
									<option value="1">Past 24 Hours</option>
									<option value="7" selected>Past 1 week</option>
									<option value="30">Past 1 month</option>
									<option value="365">Past 1 year</option>
								</select>
							</div>
							<div class="col-md-6">
								<form class="inline form-inline"
									onSubmit="topNKeywordFormSubmit(config)">
									<div class="input-group pull-right">
										<input class="form-control" type="text" id="topNKeywordsInput"
											value="10" placeholder="Number of top keywords" /> <span
											class="input-group-addon"> <i class="fa fa-search"></i>
										</span>
									</div>
								</form>
							</div>

						</div>

						<div class="topNKeywordsChartContainer">
							<div id="topNKeywordsChart"></div>
						</div>
					</div>
				</div>
				<hr />

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>

	</div>
	<!-- news related top n keywords modal -->
	<div id="modalNewsRelatedTopNKeywords" class="modal modal-wide fade ">
		<div class="modal-dialog" style="width: 100%">
			<div class="modal-content">
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<div class="scroll">
						<h3 class="text-center">Related News with specified term</h3>
						<table class="table table-striped show-related-news"
							style="margin-top: 10px;">
							<thead id="header-table">
								<tr>
									<th class="text-center">#</th>
									<th class="table-content-width">Content</th>
									<!-- 												<th>Category</th> -->
									<th>Label</th>
									<th>Probability</th>
									<th>Post Date</th>
									<th>Source</th>
								</tr>
							</thead>
							<tbody id="body-table" style="overflow-y: auto;">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ./wrapper -->

	<!-- Custom js file -->
	<!-- 	highcharts -->

	<script src="/eds/js/statistics.js"></script>

	<script type="text/javascript">
		$("#fromDate").datepicker({
			forceParse: false,
			format : 'dd-mm-yyyy',
			endDate : '+0d',
			autoclose : true,
			todayHighlight : true

		})
		$("#toDate").datepicker({
			forceParse: false,
			format : 'dd-mm-yyyy',
			endDate : '+0d',
			autoclose : true,
			todayHighlight : true
		})

		var config = {}
		config.NO = 0;
		config.isLoad = true
		config.term = ""
		config.offset = 1;

		// call ajax to fill table
		$(document).ready(
				function() {
					// fake config 	config.fromDate = "1-1-2017" 	config.toDate = "20-3-2017"
					$(".main-sidebar .editor-treeview").addClass("active");
					$(".main-sidebar .admin-treeview").removeClass("active");
					config.source = "none"
					config.contextPath = "${pageContext.request.contextPath}";
					
					config.source = $("#source").val()
					// default value for from date and to date
					$("#fromDateInput").val(
							moment().subtract(7, "days").format("DD-MM-YYYY"))
					$("#toDateInput").val(moment().format("DD-MM-YYYY"))
					config.fromDate = $("#fromDateInput").val()
					config.toDate = $("#toDateInput").val()

					// default value for top n keyword
					config.n = $("#topNKeywordsInput").val();
				    $("#topNKeywordsTitle").html("Top " + config.n + " keywords")

					config.dateRange = $("#dateRange").val()
					// load chart when document ready
					drawHotNormalNewsChart(config)
				    drawTopNKeywordsChart(config);

				})
		var send = true;
		$('#fromDate').on('change', function(ev) {
			if(send){
				config.fromDate = $("#fromDateInput").val()
				drawHotNormalNewsChart(config);
				send = false;
			}
			setTimeout(function(){send = true}, 200);
		})

		$('#toDate').on('change', function(ev) {
			if(send){
				config.toDate = $("#toDateInput").val()
				drawHotNormalNewsChart(config);
				send = false;
			}
			setTimeout(function(){send = true}, 200);
		})

		$("#modalNewsRelatedTopNKeywords").scroll(
				function() {

					var scrollHeight = $(document).height();
					var scrollPosition = $(window).height()
							+ $("#modalNewsRelatedTopNKeywords").scrollTop();
					if ((scrollHeight - scrollPosition) < 30
							&& config.isLoad == true
							&& $('#modalNewsRelatedTopNKeywords')
									.hasClass('in')) {
						// when scroll to bottom of the page
						config.isLoad = false
						config.offset += 1
						console.log("offset, ", config.offset)
						// load
						loadRelatedNewsWithTopNKeywords(config)
					}
				});
	</script>
</body>
</html>
