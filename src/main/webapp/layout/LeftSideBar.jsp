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
			                    <li><a href="/VangBacDaQuy/admin/quanlyhanggiacong"><i class="fa fa-circle-o"></i>Quản lý hàng gia công</a></li>
			                    <li><a href="/VangBacDaQuy/admin/quanlybanhang"><i class="fa fa-circle-o"></i>Lập phiếu bán hàng</a></li>
			                    <li><a href="/VangBacDaQuy/admin/quanlymuahang"><i class="fa fa-circle-o"></i>Lập phiếu mua hàng</a></li>
			                    <li><a href="/VangBacDaQuy/admin/lapphieudichvu"><i class="fa fa-circle-o"></i>Lập phiếu dịch vụ</a></li>
			                    <li><a href="/VangBacDaQuy/admin/lapphieuhanggiacong"><i class="fa fa-circle-o"></i>Lập phiếu hàng gia công</a></li>
  			                    <li><a href="/VangBacDaQuy/admin/lichsumuahang"><i class="fa fa-circle-o"></i>Lịch sử mua hàng</a></li>

			                </ul>
			            </li>
            </s:if>
            <li class="treeview editor-treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>Client</span>
                    <span class="pull-right-container">
      <i class="fa fa-angle-left pull-right"></i>
    </span>
                </a>
                <ul class="treeview-menu">
             
                </ul>
            </li>
			</li>
		</ul>
    </section>
    <!-- /.sidebar -->
</aside>
