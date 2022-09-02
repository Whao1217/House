package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtil;
import entity.house;
import entity.housejingli;
import entity.customer;
public class Dao {
    //
    
        
	 public static boolean fangchanjingjiren(String id,String pwd) {
         boolean f = false;
         String sql = "select * from fangchanjingjiren where AgentID = '" + id + "' and password = '"+ pwd +"'";
         //
         Connection conn = DBUtil.getConn();
         Statement state = null;
         ResultSet rs = null;       
         try {
             state = conn.createStatement();
             rs = state.executeQuery(sql);
             if (rs.next()) {
                 f = true;
             }
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             DBUtil.close(rs, state, conn);
         }
         return f;
     } 
	 public static boolean guke(String id,String pwd) {
         boolean f = false;
         String sql = "select * from guke where UserID = '" + id + "' and password = '"+ pwd +"'";
         //
         Connection conn = DBUtil.getConn();
         Statement state = null;
         ResultSet rs = null;       
         try {
             state = conn.createStatement();
             rs = state.executeQuery(sql);
             if (rs.next()) {
                 f = true;
             }
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             DBUtil.close(rs, state, conn);
         }
         return f;
     }
	 
	 
        public static boolean admin(String id,String pwd) {
            boolean f = false;
            String sql = "select * from admin where id = '" + id + "' and password = '"+ pwd +"'";
            //
            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;       
            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                if (rs.next()) {
                    f = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
            return f;
        }
        
        
        public static boolean addfangchan(fangchan fangchan)
    	{
    		
    	        String sql = "insert into fangchan(RoomType,Address,Year,Area,Sales,Status,AgentID,UserID) values('" + fangchan.getRoomtype() + "','" +  fangchan.getAddress() + "','" + fangchan.getYear() + "','" + fangchan.getArea() + "','" + fangchan.getSales() + "','" + fangchan.getStatus() + "','" + fangchan.getAgentid() + "','" + fangchan.getUserid() + "')";
    	        //创建数据库链接
    	        Connection conn = DBUtil.getConn();
    	        Statement state = null;
    	        boolean f = false;
    	        int a = 0;
    	        
    	        try {
    	            state = conn.createStatement();
    	            a = state.executeUpdate(sql);
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        } finally {
    	            //关闭连接
    	            DBUtil.close(state, conn);
    	        }
    	        if (a > 0) {
    	            f = true;
    	        }
    	        return f;
    	}
        
        public static boolean addfangchanjingji(fangchanjingjiren fangchanjingji)
    	{
    		
    	        String sql = "insert into fangchanjingjiren(AgentID,AgentName,AgentAddress,Phone) values('" + fangchanjingji.getAgentID() + "','" +  fangchanjingji.getAgentName() + "','" + fangchanjingji.getAgentAddress() + "','" + fangchanjingji.getPhone() +  "')";
    	        //创建数据库链接
    	        Connection conn = DBUtil.getConn();
    	        Statement state = null;
    	        boolean f = false;
    	        int a = 0;
    	        
    	        try {
    	            state = conn.createStatement();
    	            a = state.executeUpdate(sql);
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        } finally {
    	            //关闭连接
    	            DBUtil.close(state, conn);
    	        }
    	        if (a > 0) {
    	            f = true;
    	        }
    	        return f;
    	}
        public static boolean addguke(guke guke)
    	{
    		
    	        String sql = "insert into guke(UserID,UserName,sex,IdNumber,Phone,User,password,zhuangtai) values('" + guke.getUserid() + "','" +  guke.getUsername() + "','" + guke.getSex() + "','" + guke.getIdnumber() + "','" + guke.getPhone() + "','" + guke.getUser() + "','" + guke.getPassword() + "','" + guke.getZhuangtai() +  "')";
    	        //创建数据库链接
    	        Connection conn = DBUtil.getConn();
    	        Statement state = null;
    	        boolean f = false;
    	        int a = 0;
    	        
    	        try {
    	            state = conn.createStatement();
    	            a = state.executeUpdate(sql);
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        } finally {
    	            //关闭连接
    	            DBUtil.close(state, conn);
    	        }
    	        if (a > 0) {
    	            f = true;
    	        }
    	        return f;
    	}
        
        public static List<guke> gukelist() {
	        String sql = "select * from guke";
	        List<guke> list = new ArrayList<>();
	        Connection conn = DBUtil.getConn();
	        Statement state = null;
	        ResultSet rs = null;

	        try {
	            state = conn.createStatement();
	            rs = state.executeQuery(sql);
	            guke bean = null;
	            while (rs.next()) {
	            	String UserID = rs.getString("UserID");
	            	String UserName = rs.getString("UserName");
	                String sex = rs.getString("sex");
	                String IdNumber = rs.getString("IdNumber");
	                String Phone = rs.getString("Phone");
	                String User = rs.getString("User");
	                String zhuangtai = rs.getString("zhuangtai");
	                String password = rs.getString("password");
	                bean = new guke(UserID,UserName,sex,IdNumber,Phone,User,password);
	                bean.setZhuangtai(zhuangtai);
	                list.add(bean);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.close(rs, state, conn);
	        }
	        
	        return list;
	    }
        public static boolean tongguoshenhe(String UserID) {
	        String sql = "update guke set zhuangtai='" + "过审" + "' where UserID='" + UserID + "'";
	        Connection conn = DBUtil.getConn();
	        Statement state = null;
	        boolean f = false;
	        int a = 0;

	        try {
	            state = conn.createStatement();
	            a = state.executeUpdate(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.close(state, conn);
	        }
	        
	        if (a > 0) {
	            f = true;
	        }
	        return f;
	    }
        
        public static boolean tingshou(String HouseID) {
	        String sql = "update fangchan set Status='" + "停售" + "' where HouseID='" + HouseID + "'";
	        Connection conn = DBUtil.getConn();
	        Statement state = null;
	        boolean f = false;
	        int a = 0;

	        try {
	            state = conn.createStatement();
	            a = state.executeUpdate(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.close(state, conn);
	        }
	        
	        if (a > 0) {
	            f = true;
	        }
	        return f;
	    }
        public static boolean fangchanshenhe(String HouseID,String AgentID) {
	        String sql = "update fangchan set Status='" + "待售" +"', AgentID='" + AgentID +  "' where HouseID='" + HouseID + "'";
	        Connection conn = DBUtil.getConn();
	        Statement state = null;
	        boolean f = false;
	        int a = 0;

	        try {
	            state = conn.createStatement();
	            a = state.executeUpdate(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.close(state, conn);
	        }
	        
	        if (a > 0) {
	            f = true;
	        }
	        return f;
	    }
        public static List<fangchan> fangchanlist() {
	        String sql = "select * from fangchan";
	        List<fangchan> list = new ArrayList<>();
	        Connection conn = DBUtil.getConn();
	        Statement state = null;
	        ResultSet rs = null;

	        try {
	            state = conn.createStatement();
	            rs = state.executeQuery(sql);
	            fangchan bean = null;
	            while (rs.next()) {
	            	String HouseID = rs.getString("HouseID");
	            	String RoomType = rs.getString("RoomType");
	                String Address = rs.getString("Address");
	                String Year = rs.getString("Year");
	                String Area = rs.getString("Area");
	                String Sales = rs.getString("Sales");
	                String Status = rs.getString("Status");
	                String AgentID = rs.getString("AgentID");
	                String UserID = rs.getString("UserID");
	                bean = new fangchan(RoomType,Address,Year,Area,Sales,Status,AgentID,UserID);
	                bean.setHouseid(HouseID);
	                list.add(bean);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.close(rs, state, conn);
	        }
	        
	        return list;
	    }
}