<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <s:if test="#session.role == 'ADMIN'">
            	<li class="treeview admin-treeview">
                <a href="#">
                    <i class="fa fa-user" aria-hidden="true"></i> <span>Admin</span>
                    <span class="pull-right-container">
			      <i class="fa fa-angle-left pull-right"></i>
			    </span>
			                </a>
			                <ul class="treeview-menu">
			                    <li><a href="/VangBacDaQuy/admin/quanlysanpham"><i class="fa fa-circle-o"></i>Quản lý sản phẩm</a></li>
			                    <li><a href="/VangBacDaQuy/admin/quanlydichvu"><i class="fa fa-circle-o"></i>Quản lý dịch vụ</a></li>
			                    <li><a href="/VangBacDaQuy/admin/quanlybanhang"><i class="fa fa-circle-o"></i>Quản lý bán hàng</a></li>
			                    <li><a href="/VangBacDaQuy/admin/GoCrawlTweet"><i class="fa fa-circle-o"></i>Crawl Twitter</a></li>
			                    <li><a href="/VangBacDaQuy/admin/GoPrepareData"><i class="fa fa-circle-o"></i>Prepare Data</a></li>
			                    <li><a href="/VangBacDaQuy/admin/GoPreprocessData"><i class="fa fa-circle-o"></i>Preprocess Data</a></li>
			                    <li><a href="/VangBacDaQuy/admin/GoTrainModel"><i class="fa fa-circle-o"></i>Train Model</a></li>
			                    <li><a href="/VangBacDaQuy/admin/GoPredictHotNews"><i class="fa fa-circle-o"></i>Predict Hot News</a></li>
			                </ul>
			            </li>
            </s:if>
            <li class="treeview editor-treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>Editor</span>
                    <span class="pull-right-container">
      <i class="fa fa-angle-left pull-right"></i>
    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/VangBacDaQuy/editor/HotStream"><i class="fa fa-circle-o"></i>Top Stories</a></li>
                    <li><a href="/VangBacDaQuy/editor/ShowHotNews"><i class="fa fa-circle-o"></i>Hot News</a></li>
                     <li><a href="/VangBacDaQuy/editor/Statistics"><i class="fa fa-circle-o"></i>Statistic</a></li>
                </ul>
            </li>
			<!-- System setting -->
<!-- 			<li class="treeview configuration-treeview"><a href="#"> <i -->
<%-- 					class="fa fa-cogs"></i> <span>Configuration System</span> <span --%>
<%-- 					class="pull-right-container"> <i --%>
<!-- 						class="fa fa-angle-left pull-right"></i> -->
<%-- 				</span> --%>
<!-- 			</a> -->
<!-- 				<ul class="treeview-menu"> -->
<!-- 					<li><a href="/VangBacDaQuy/admin/TrackingTweet"><i -->
<!-- 							class="fa fa-circle-o"></i>Tracking Tweet</a></li> -->
<!-- 				</ul> -->
			</li>
		</ul>
    </section>
    <!-- /.sidebar -->
</aside>
