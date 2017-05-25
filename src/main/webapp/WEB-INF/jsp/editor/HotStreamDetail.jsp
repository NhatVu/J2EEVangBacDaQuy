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
			<section class="content-header">
				<h1 class="text-center">Top Stories (Live Hot News from Twitter)</h1>
				<hr>
			</section>
			<section class="content">
				<div class="row">
				<h4 style="background: #f8f8f8; padding: 15px 15px;"><strong>Lastest message</strong></h4>
					<div class="bs-callout bs-callout-danger"
						id="callout-glyphicons-dont-mix">
						<div class="nom" style="float: left; font-size: 25px;"><b style="font-size: 20px; padding 0px 10px;">135</b></div>
						<div class="content-tweet" style="float: left;">
							<div class="tweetContent" style="margin: 10px;"><label class="label label-primary" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">First story</label><strong> Mỹ, Hàn: Tên lửa Triều Tiên 'nổ ngay lập tức' khi
												phóng thử</strong></div>
												<div class="userName" style="margin: 10px;"><label class="label label-success" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">From user</label> @Cuongdev</div>
												<div class="first-tweet" style="margin: 10px;"><label class="label label-danger" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">First tweet:</label> Freb 3rd, 15: 36 <label class="label label-danger" style="padding: 4px 5px; margin-top: -4px;     margin-left: 30px; font-size: 13px; font-weight: normal;">Last tweet:</label>  Yesterday, 18:02
												</div>
						</div>
					</div>
				</div>

				<div class="row">
					<h4 style="background: #f8f8f8; padding: 15px 15px;"> 
						<strong>Activites</strong>
					</h4>
					<div class="graph-activity">
						<div class="col-sm-12 mgt-10 border-bottom pdb-10">
							<h5 class="col-sm-1">Activity in </h5>
							<div class="pull-left right">
								<div id="datepicker-range" class="pull-right form-control">
									<span class="glyphicon glyphicon-calendar"></span>&nbsp;<span
										class="show-date">18/04/2017 - 24/04/2017</span> <b
										class="caret"></b>
								</div>
							</div>
							<h5 class="col-sm-3">(Time displayed in JST 24h) </h5>
						</div>
						<div class="chart" id="chart-group-post"></div>
					</div>
				</div>

				<div class="row">
					<div class="related-message">
						<div class="bs-callout bs-callout-info" id="callout-glyphicons-dont-mix">
							<div class="media" style="float: left;"> <div class="media-left"> <a href="#"> <img alt="64x64" class="media-object" data-src="holder.js/64x64" style="width: 64px; height: 64px;" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvNjR4NjQKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNWJhMDZmNmM1ZCB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE1YmEwNmY2YzVkIj48cmVjdCB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxNCIgeT0iMzYuNSI+NjR4NjQ8L3RleHQ+PC9nPjwvZz48L3N2Zz4=" data-holder-rendered="true"> </a> </div> </div>
							<div class="content-tweet" style="float: left;">
								<div class="tweetContent" style="margin: 10px;"><label class="label label-primary" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">First story</label><strong> Mỹ, Hàn: Tên lửa Triều Tiên 'nổ ngay lập tức' khi
							phóng thử</strong></div>
							<div class="userName" style="margin: 10px;"><label class="label label-success" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">From user</label> @Cuongdev</div>
							<div class="first-tweet" style="margin: 10px;"><label class="label label-danger" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">First tweet:</label> Freb 3rd, 15: 36 <label class="label label-danger" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">Last tweet:</label>  Yesterday, 18:02</div>
						</div>
					</div>
					</div>
				</div>
				</div>
			</section>
		</div>



		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>
		<style>
 			#contentTable {
				/* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#cf0404+0,ff3019+99,ff3019+100&1+0,0+100 */
				background: -moz-linear-gradient(top,  rgba(207,4,4,1) 0%, rgba(255,48,25,0.01) 99%, rgba(255,48,25,0) 100%); /* FF3.6-15 */
				background: -webkit-linear-gradient(top,  rgba(207,4,4,1) 0%,rgba(255,48,25,0.01) 99%,rgba(255,48,25,0) 100%); /* Chrome10-25,Safari5.1-6 */
				background: linear-gradient(to bottom,  rgba(207,4,4,1) 0%,rgba(255,48,25,0.01) 99%,rgba(255,48,25,0) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
				filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#cf0404', endColorstr='#00ff3019',GradientType=0 ); /* IE6-9 */
    width: 95%;
	 
	 			} 
	.read-more-content {
		margin-top: 25px;
		margin-bottom: 5px;
	}
	.bs-callout-danger {
    border-left-color: #ce4844;
}
.bs-callout-info{
	border: 1px solid #1b809e !important;
	    border-left-color: #1b809e !important;
	    background: #f8f8f8 !important;

}
.bs-callout {
    padding: 20px;
    margin: 20px 0;
    border: 1px solid #f9b000;
    border-left-width: 5px;
    border-radius: 3px;
    background: bisque;
    display: inline-block;
    width: 100%;
}
						.daterangepicker.ltr .ranges {
							width: 250px;
						}
						
						.daterangepicker .input-mini {
							padding: 5px !important;
							width: 100px;
							line-height: 25px !important;
							height: 25px !important;
						}
						
						.daterangepicker .date-sp {
							font-size: 16px;
						}
</style>
<style type="text/css">.daterangepicker.ltr .ranges {width: 250px;}
.daterangepicker .input-mini {padding: 5px !important; width: 100px; line-height: 25px !important; height: 25px !important;}
.daterangepicker .date-sp {font-size: 16px;}</style>
		<script type="text/javascript">
			$("#btnCrawl").click(function() {
				$.LoadingOverlay("show");
				$('#contentTable').DataTable({
					destroy : true,
					"ajax" : "crawlLink?url=" + $("#txtUrl").val().trim(),
					"columns" : [ {
						"data" : "site"
					}, {
						"data" : "url"
					}, {
						"data" : "title"
					}, {
						"data" : "content"
					}, {
						"data" : "postDate"
					} ]
				});
				$.LoadingOverlay("hide");
			});
		</script>
		
		<script>
	$(document).ready(function() {
			$(".main-sidebar .editor-treeview").addClass("active");
			$(".main-sidebar .admin-treeview").removeClass("active");
		 $('#datepicker-range').daterangepicker({
		        locale: {
		            format: 'DD/MM/YYYY',
		            applyLabel: 'Apply',
		            cancelLabel: 'Cancel'
		        },
		        startDate: '14/04/2017',
		        endDate: '20/04/2017',
		        maxDate: '20/04/2017',
		        template: '<div class="daterangepicker dropdown-menu"><div class="calendar left"><div class="calendar-table"></div></div><div class="calendar right"><div class="calendar-table"></div></div><div class="ranges"><div class="col-sm-12"><div class="row daterangepicker_input"><div class="input-group"><input class="input-small form-control" type="text" name="daterangepicker_start" value="" /><span class="input-group-addon">to</span><input class="input-small form-control" type="text" name="daterangepicker_end" value="" /></div></div></div><div class="col-sm-12 daterangepicker_compare pdl-0 pdt-5"><input type="checkbox" id="daterangepicker-compare-to" /> <label for="daterangepicker-compare-to">Compare to</label></div><div class="col-sm-12 pdb-10 hide"><div class="row daterangepicker_compare_input"><div class="input-group"><input class="input-small form-control" type="text" name="daterangepicker_compare_start" value="" /><span class="input-group-addon">to</span><input class="input-small form-control" type="text" name="daterangepicker_compare_end" value="" /></div></div></div><div class="col-sm-12 range_inputs pdl-0 pdt-10 border-top"><button class="applyBtn" disabled="disabled" type="button"></button> <button class="cancelBtn" type="button"></button></div></div></div>',
		    }, function(t, a, e) {
		        var n = '';
		        commons.set(n + 'from_date', t.format('YYYY-MM-DD'), 30);
		        commons.set(n + 'to_date', a.format('YYYY-MM-DD'), 30);
		        $('#datepicker-range .show-date').html(t.format('DD/MM/YYYY') + ' - ' + a.format('DD/MM/YYYY'));
		        if (typeof(commons.datepicker.callback) == 'function') {
		            commons.datepicker.callback(t, a)
		        }
		    })
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
	</div>
</body>
