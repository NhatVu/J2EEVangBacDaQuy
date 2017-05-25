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
				<div class="row">
					<div class="col-sm-8">
						<h1 style="font-size:24px; padding-left: 60%;">Hot News</h1>
					</div>
					<div class="col-sm-3 pull-right" style="margin: 20px;">
						<form action="/eds/Search" method="get">
							<div class="input-group">
								<input type="text" name="query" class="form-control"
									placeholder="Search..."> <span class="input-group-btn">
									<button type="submit" id="search-btn" class="btn btn-flat">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div>
						</form>
					</div>
				</div>
				<hr style="margin-bottom: 0px;" />
			</section>
			<section class="content">
				<!-- filter -->
				<div class="form-inline show-news-filter">
					<div class="form-group">
						<label for="focusedInput">Source</label> <select
							class="form-control" name="source"
							onchange="handleSelectChange(config)">
							<option value="all">All</option>
							<option value="twitter">Twitter</option>
							<option value="facebook">Facebook</option>
							<option value="news">News</option>
						</select> 
					</div>
					<div class="form-group" style="display: none;">
						<label for="inputPassword">Category</label> <select
							class="form-control" name="category"
							onchange="handleSelectChange(config)">
							<option value="all">Any</option>
							<option value="Accident">Accident</option>
							<option value="Acts of Violence or War">Acts of Violence
								or War</option>
							<option value="Bizarre News and World Records">Bizarre
								News and World Records</option>
							<option value="Celebrity and Human Interest News">Celebrity
								and Human Interest News</option>
							<option value="Election">Election</option>
							<option value="Financial">Financial</option>
							<option value="Legal and Criminal Case">Legal and
								Criminal Cases</option>
							<option value="Natural Disaster">Natural Disaster</option>
							<option value="New Law">New Law</option>
							<option value="Political Meeting">Political Meeting</option>
							<option value="Scandal and Hearing">Scandals/Hearings</option>
							<option value="Science and Discovery">Science and
								Discovery</option>
							<option value="Sport">Sport</option>
							<option value="General">General</option>
						</select>
					</div>
					<div class="form-group">
						<label for="inputSuccess2">Date</label>
						<div class='input-group date' id='startDate' style="width: 70%">
							<input type='text' class="form-control" name="fromDate"
								id="selectedDate" /> <span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
					<!--  <div class="form-group">
						<label for="inputSuccess2">Time</label> <select
							class="form-control" name="">
							<option value="">DESC</option>
							<option value="">ACS</option>
						</select>
					</div> -->
					<div class="form-group">
						<label for="inputWarning2">Probability</label> <select
							class="form-control" name="probabilityForYes"
							onchange="handleSelectChange(config)">
							<option value="decs">DESC</option>
							<option value="asc">ASC</option>
						</select>
					</div>
				</div>

				<!-- 				<table class="table table-striped " -->
				<!-- 					style="margin-top: 10px;"> -->


				<!-- 				</table> -->
				<div class="scroll">
					<table class="table table-striped show-hot-news"
						style="margin-top: 10px;">
						<thead id="header-table">
							<tr>
								<th class="text-center">#</th>
								<th class="table-content-width">Content</th>
								<!-- 							<th>Category</th> -->
								<th>Label</th>
								<th>Probability</th>
								<th>Post Date</th>
								<th>Source</th>
								<th>Editor's Feedback</th>
							</tr>
						</thead>
						<tbody id="body-table">
						</tbody>
					</table>
				</div>
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>


	</div>
	<!-- ./wrapper -->

	<!-- Custom js file -->
	<script src="/eds/js/show-hot-news.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$(".main-sidebar .editor-treeview").addClass("active");
			$(".main-sidebar .admin-treeview").removeClass("active");
			$("#selectedDate").val(moment().format("DD-MM-YYYY"))

			//reload data after 20s
						setInterval(function() {
							console.log("call")
							reloadHotNews(config)
						}, config.timeOut * 1000)
						loadHotNews(config);
		})

		//var today = new Date(date.getFullYear(), date.getMonth(), date.getDate());
		$("#startDate").datepicker({
			forceParse: false,
			format : 'dd-mm-yyyy',
			endDate : '+0d',
			todayHighlight : true,
			"setDate" : new Date(),
			autoclose : true,
			onSelect: $.noop
		})

		// call ajax to fill table 
		var config = {}
		config.contextPath = "${pageContext.request.contextPath}";
		config.offset = 0
		config.sortBy = "probabilityForYes"
		config.desc = "TRUE"
		config.NO = 0;
		config.isLoad = true
		config.selectedDate = moment().format("DD-MM-YYYY")
		config.source = "all"
		config.category = "all"
		config.timeOut = 30 // unit seconds
		// load addition 10 rows when scrollTop < 100
			var topHeader = $("#header-table");
		  var topHeight = topHeader.offset().top;
		  console.log(topHeight);
		  var widthHeader = topHeader.innerWidth();
		  console.log(widthHeader);
		  $(window).scroll(function() {			
			  var scrollHeight = $(document).height();			
			  var scrollPosition = $(window).height() + $(window).scrollTop();			
			  if ((scrollHeight - scrollPosition) < 30 && config.isLoad == true) {				
				  // when scroll to bottom of the page				
				  config.isLoad = false				
				  config.offset += 1				
				  console.log("offset, ", config.offset)				
				  // load				
				  loadHotNews(config)			
				  }		
			});

		// onStartDay changae
// 		$('#startDate').datepicker().on('changeDate', function(ev) {
// 			config.selectedDate = $('#selectedDate').val();
// 			// empty table			
// 			$(".show-hot-news tbody").empty();
// 			config.offset = 0
// 			config.NO = 0;
// 			config.isLoad = true
// 			loadHotNews(config)
// 		});
		var send = true;
		$('#startDate').change(function() { 
			if(send){
				config.selectedDate = $('#selectedDate').val();
				// empty table			
				$(".show-hot-news tbody").empty();
				config.offset = 0
				config.NO = 0;
				config.isLoad = true
				loadHotNews(config)
				send = false;
			}
			setTimeout(function(){send = true}, 200)
		});
	</script>
	<script>
	$( document ).ready(function() {
			var topHeader = $("#header-table");
		  var topHeight = topHeader.offset().top;
		  console.log(topHeight);
		  var widthHeader = topHeader.innerWidth();
		  console.log(widthHeader);
		  $(window).scroll(function(e){
		   var top = (window.pageYOffset || document.scrollTop)  - (document.clientTop || 0);
		   if(top >= topHeight-30 && top != NaN) {
			   topHeader.css({"position":"fixed", "top": "0px","width":widthHeader});
			   var trh =  $("#header-table tr th");
			   var trb = $("#body-table tr:nth-child(1) td");
				for(var i = 0; i< trh.size(); i++){
					var th = trh[i];
					var td = trb[i];
					td.style.width = th.style.width;
				}
				$("#startDate").hide();
		   }
		   else {
			   topHeader.css({"position":"relative", "top": topHeight});
			   $("#startDate").show();
		   }
		  });
	});
	
	</script>
	<script>
		var tr =  $("#header-table tr th");
		for(var i = 0; i< tr.size(); i++){
			var th = tr[i];
			console.log(th.offsetWidth);
			th.style.width= th.offsetWidth +'px';
		}
	</script>
</body>

<!-- Modal show trend -->
<div id="modalShowTrend" class="modal modal-wide fade ">
	<div class="modal-dialog" style="width: 100%">
		<div class="modal-content">
			<div class="modal-body">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<div class="chart" id="chart-favorite-retweet"></div>

			</div>
		</div>
	</div>
</div>
<!-- .Modal show trend -->

<script>
	$(document).ready(function() {
	
// 	var data = [],
// 	    data1 = [],
// 	    data2 = [],
// 	    title = '',
// 	    titleData = '',
// 	    titleData1 = '',
// 	    titleData2 = '';
// 	data1 = {
// 	    'date': ['2017-04-14', '2017-04-15', '2017-04-16', '2017-04-17', '2017-04-18', '2017-04-19', '2017-04-20'],
// 	    'count': [3695136, 3888332, 3753607, 4096702, 4121268, 5539514, 2758759],
// 	    'length': 7
// 	};
// 	data2 = {
// 	    'date': ['2017-04-14', '2017-04-15', '2017-04-16', '2017-04-17', '2017-04-18', '2017-04-19', '2017-04-20'],
// 	    'count': [2849854, 2006583, 2020894, 2180229, 2370174, 5119898, 1307348],
// 	    'length': 7
// 	};
// 	title = 'Favorite & Retweet';
// 	titleData1 = 'Favority';
// 	titleData2 = 'Retweet';
// 	renderTwoChart('#chart-favorite-retweet', data1, data2, title, titleData1, titleData2);
// 	var width = $(".modal-dialog").width();
// 	console.log("widht" + (width * $(window).width()));
// 	$(".highcharts-container ").width(width * $(window).width()/100);
	});
	</script>
</html>



