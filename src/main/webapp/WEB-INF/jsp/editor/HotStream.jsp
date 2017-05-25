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
<%-- 				<h1 class="text-center">Top Stories <span style="font-size: 20px;">(Live Hot News from Twitter)</span></h1> --%>
				<h5 class="text-center"><label class="label label-default">Showing popular message within 1 day</label></h5>
				<hr>
			</section>
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box" style="border: none !important;">
							<div class="box-body">
								<table id="contentTable"
									class="table table-bordered table-striped">
									<thead>
										<tr>
											<th style="width: 10px;" class="text-center">NOM</th>
											<th style="width: 10px;" class="text-center">Information</th>
										</tr>
									</thead>
									<tbody>
										<tr role="row" class="odd" >
											<td class="text-center" style="vertical-align: middle;">
												<b style="font-size: 20px; padding 0px 10px;">135</b>
<!-- 												<label class="label label-danger">First tweet:</label> -->
											</td>
											<td style="width: 100%;">
												<div class="tweetContent" style="margin: 10px;"><label class="label label-primary" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">First story</label> <strong> Mỹ, Hàn: Tên lửa Triều Tiên 'nổ ngay lập tức' khi
												phóng thử </strong></div>
												<div class="userName" style="margin: 10px;"><label class="label label-success" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">From user</label> @Cuongdev</div>
												<div class="first-tweet" style="margin: 10px;"><label class="label label-danger" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">First tweet:</label> Freb 3rd, 15: 36 <label class="label label-danger" style="padding: 4px 5px; margin-top: -4px;     margin-left: 30px; font-size: 13px; font-weight: normal;">Last tweet:</label>  Yesterday, 18:02

												<a href="HotStreamDetail"><span class="glyphicon glyphicon-menu-right" style="margin-left: 20px;" aria-hidden="true"></span> <span class="readmore-text">Read More</span> </a>

												</div>
												
											</td>
										</tr><tr role="row" class="odd" >
											<td class="text-center" style="vertical-align: middle;">
												<b style="font-size: 20px; padding 0px 10px;">135</b>
<!-- 												<label class="label label-danger">First tweet:</label> -->
											</td>
											<td style="width: 100%;">
												<div class="tweetContent" style="margin: 10px;"><label class="label label-primary" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">First story</label> <strong> Mỹ, Hàn: Tên lửa Triều Tiên 'nổ ngay lập tức' khi
												phóng thử </strong></div>
												<div class="userName" style="margin: 10px;"><label class="label label-success" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">From user</label> @Cuongdev</div>
												<div class="first-tweet" style="margin: 10px;"><label class="label label-danger" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">First tweet:</label> Freb 3rd, 15: 36 <label class="label label-danger" style="padding: 4px 5px; margin-top: -4px;     margin-left: 30px; font-size: 13px; font-weight: normal;">Last tweet:</label>  Yesterday, 18:02

												<a href="HotStreamDetail"><span class="glyphicon glyphicon-menu-right" style="margin-left: 20px;" aria-hidden="true"></span> <span class="readmore-text">Read More</span> </a>

												</div>
												
											</td>
										</tr>
										<tr role="row" class="odd" >
											<td class="text-center" style="vertical-align: middle;">
												<b style="font-size: 20px; padding 0px 10px;">135</b>
<!-- 												<label class="label label-danger">First tweet:</label> -->
											</td>
											<td style="width: 100%;">
												<div class="tweetContent" style="margin: 10px;"><label class="label label-primary" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">First story</label> <strong> Mỹ, Hàn: Tên lửa Triều Tiên 'nổ ngay lập tức' khi
												phóng thử </strong></div>
												<div class="userName" style="margin: 10px;"><label class="label label-success" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">From user</label> @Cuongdev</div>
												<div class="first-tweet" style="margin: 10px;"><label class="label label-danger" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">First tweet:</label> Freb 3rd, 15: 36 <label class="label label-danger" style="padding: 4px 5px; margin-top: -4px;     margin-left: 30px; font-size: 13px; font-weight: normal;">Last tweet:</label>  Yesterday, 18:02

												<a href="HotStreamDetail"><span class="glyphicon glyphicon-menu-right" style="margin-left: 20px;" aria-hidden="true"></span> <span class="readmore-text">Read More</span> </a>

												</div>
												
											</td>
										</tr>
									<tr role="row" class="odd" >
											<td class="text-center" style="vertical-align: middle;">
												<b style="font-size: 20px; padding 0px 10px;">135</b>
<!-- 												<label class="label label-danger">First tweet:</label> -->
											</td>
											<td style="width: 100%;">
												<div class="tweetContent" style="margin: 10px;"><label class="label label-primary" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">First story</label> <strong> Mỹ, Hàn: Tên lửa Triều Tiên 'nổ ngay lập tức' khi
												phóng thử </strong></div>
												<div class="userName" style="margin: 10px;"><label class="label label-success" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">From user</label> @Cuongdev</div>
												<div class="first-tweet" style="margin: 10px;"><label class="label label-danger" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">First tweet:</label> Freb 3rd, 15: 36 <label class="label label-danger" style="padding: 4px 5px; margin-top: -4px;     margin-left: 30px; font-size: 13px; font-weight: normal;">Last tweet:</label>  Yesterday, 18:02

												<a href="HotStreamDetail"><span class="glyphicon glyphicon-menu-right" style="margin-left: 20px;" aria-hidden="true"></span> <span class="readmore-text">Read More</span> </a>

												</div>
												
											</td>
										</tr>
										<tr role="row" class="odd" >
											<td class="text-center" style="vertical-align: middle;">
												<b style="font-size: 20px; padding 0px 10px;">135</b>
<!-- 												<label class="label label-danger">First tweet:</label> -->
											</td>
											<td style="width: 100%;">
												<div class="tweetContent" style="margin: 10px;"><label class="label label-primary" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">First story</label> <strong> Mỹ, Hàn: Tên lửa Triều Tiên 'nổ ngay lập tức' khi
												phóng thử </strong></div>
												<div class="userName" style="margin: 10px;"><label class="label label-success" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">From user</label> @Cuongdev</div>
												<div class="first-tweet" style="margin: 10px;"><label class="label label-danger" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">First tweet:</label> Freb 3rd, 15: 36 <label class="label label-danger" style="padding: 4px 5px; margin-top: -4px;     margin-left: 30px; font-size: 13px; font-weight: normal;">Last tweet:</label>  Yesterday, 18:02

												<a href="HotStreamDetail"><span class="glyphicon glyphicon-menu-right" style="margin-left: 20px;" aria-hidden="true"></span> <span class="readmore-text">Read More</span> </a>

												</div>
												
											</td>
										</tr>
										<tr role="row" class="odd" >
											<td class="text-center" style="vertical-align: middle;">
												<b style="font-size: 20px; padding 0px 10px;">135</b>
<!-- 												<label class="label label-danger">First tweet:</label> -->
											</td>
											<td style="width: 100%;">
												<div class="tweetContent" style="margin: 10px;"><label class="label label-primary" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">First story</label> <strong> Mỹ, Hàn: Tên lửa Triều Tiên 'nổ ngay lập tức' khi
												phóng thử </strong></div>
												<div class="userName" style="margin: 10px;"><label class="label label-success" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">From user</label> @Cuongdev</div>
												<div class="first-tweet" style="margin: 10px;"><label class="label label-danger" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">First tweet:</label> Freb 3rd, 15: 36 <label class="label label-danger" style="padding: 4px 5px; margin-top: -4px;     margin-left: 30px; font-size: 13px; font-weight: normal;">Last tweet:</label>  Yesterday, 18:02

												<a href="HotStreamDetail"><span class="glyphicon glyphicon-menu-right" style="margin-left: 20px;" aria-hidden="true"></span> <span class="readmore-text">Read More</span> </a>

												</div>
												
											</td>
										</tr>
										<tr role="row" class="odd" >
											<td class="text-center" style="vertical-align: middle;">
												<b style="font-size: 20px; padding 0px 10px;">135</b>
<!-- 												<label class="label label-danger">First tweet:</label> -->
											</td>
											<td style="width: 100%;">
												<div class="tweetContent" style="margin: 10px;"><label class="label label-primary" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">First story</label> <strong> Mỹ, Hàn: Tên lửa Triều Tiên 'nổ ngay lập tức' khi
												phóng thử </strong></div>
												<div class="userName" style="margin: 10px;"><label class="label label-success" style="padding: 4px 8px; margin-top: -4px; font-size: 13px; font-weight: normal;">From user</label> @Cuongdev</div>
												<div class="first-tweet" style="margin: 10px;"><label class="label label-danger" style="padding: 4px 5px; margin-top: -4px; font-size: 13px; font-weight: normal;">First tweet:</label> Freb 3rd, 15: 36 <label class="label label-danger" style="padding: 4px 5px; margin-top: -4px;     margin-left: 30px; font-size: 13px; font-weight: normal;">Last tweet:</label>  Yesterday, 18:02

												<a href="HotStreamDetail"><span class="glyphicon glyphicon-menu-right" style="margin-left: 20px;" aria-hidden="true"></span> <span class="readmore-text">Read More</span> </a>

												</div>
												
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
			</section>
		</div>



		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>
			<style>
/*  			#contentTable { */
/* 				/* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#cf0404+0,ff3019+99,ff3019+100&1+0,0+100 */ */
/* 				background: -moz-linear-gradient(top,  rgba(207,4,4,1) 0%, rgba(255,48,25,0.01) 99%, rgba(255,48,25,0) 100%); /* FF3.6-15 */ */
/* 				background: -webkit-linear-gradient(top,  rgba(207,4,4,1) 0%,rgba(255,48,25,0.01) 99%,rgba(255,48,25,0) 100%); /* Chrome10-25,Safari5.1-6 */ */
/* 				background: linear-gradient(to bottom,  rgba(207,4,4,1) 0%,rgba(255,48,25,0.01) 99%,rgba(255,48,25,0) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */ */
/* 				filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#cf0404', endColorstr='#00ff3019',GradientType=0 ); /* IE6-9 */ */
	 
/* 	 			}  */
	.read-more-content {
		margin-top: 25px;
		margin-bottom: 5px;
	}
</style>
		<script type="text/javascript">
		$(document).ready(function() {
			$(".main-sidebar .editor-treeview").addClass("active");
			$(".main-sidebar .admin-treeview").removeClass("active");
		});
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
			alternate('contentTable');
		});
/****************************************************************************************/
function alternate(id){
	if(document.getElementById){						//check that browser has capabilities
		var table = document.getElementById(id);		//get just the selected table not all of them
		var rows = table.getElementsByTagName("tr");	//get all table rows
	var tmp = generateColor('#ffffff','#cc0000',rows.length);
	var temp = generateColor('#ff1a1a','#ffffff',rows.length);
		for(i = 1 ; i < rows.length-1; i++){				//alternate styles			
			doGradient(rows[i], tmp[i-1], temp[i-1]);
		}
		doGradient(rows[rows.length-1], tmp[rows.length-1], temp[rows.length-1]);
	}
}
/****************************************************************************************/
function doGradient(row, tmp, temp){
	
	row.getElementsByTagName("td")[0].style.backgroundColor = "#" + tmp;
	row.getElementsByTagName("td")[0].style.color = "#" + temp;
	row.getElementsByTagName("td")[0].style.textShadow = "1px 1px 0px #000";
		
}
function hex (c) {
  var s = "0123456789abcdef";
  var i = parseInt (c);
  if (i == 0 || isNaN (c))
    return "00";
  i = Math.round (Math.min (Math.max (0, i), 255));
  return s.charAt ((i - i % 16) / 16) + s.charAt (i % 16);
}

/* Convert an RGB triplet to a hex string */
function convertToHex (rgb) {
  return hex(rgb[0]) + hex(rgb[1]) + hex(rgb[2]);
}

/* Remove '#' in color hex string */
function trim (s) { return (s.charAt(0) == '#') ? s.substring(1, 7) : s }

/* Convert a hex string to an RGB triplet */
function convertToRGB (hex) {
  var color = [];
  color[0] = parseInt ((trim(hex)).substring (0, 2), 16);
  color[1] = parseInt ((trim(hex)).substring (2, 4), 16);
  color[2] = parseInt ((trim(hex)).substring (4, 6), 16);
  return color;
}

function generateColor(colorStart,colorEnd,colorCount){
	// The beginning of your gradient
	var start = convertToRGB (colorStart);    

	// The end of your gradient
	var end   = convertToRGB (colorEnd);    

	// The number of colors to compute
	var len = colorCount;

	//Alpha blending amount
	var alpha = 0.0;

	var saida = [];
	saida.push(convertToHex(end));
	for (i = 1; i < len; i++) {
		var c = [];
		alpha += (1.0/len);
		
		c[0] = start[0] * alpha + (1 - alpha) * end[0];
		c[1] = start[1] * alpha + (1 - alpha) * end[1];
		c[2] = start[2] * alpha + (1 - alpha) * end[2];

		saida.push(convertToHex (c));
		
	}
	
	return saida;
	
}

// Exemplo de como usar



</script>

	</div>
</body>
