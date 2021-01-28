package com.mad322;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mad322.*;


	@Path("/aws")
	public class Awscode {
		

		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		PreparedStatement preparedStatement = null;

		JSONObject mainObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject childObj = new JSONObject();
		 //update employee 1st query by Akshit
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
	    @Path("/updateEmp/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateEmployee(@PathParam("id")int id,Employee1 employee)
		{
			MysqlCon connection= new MysqlCon();
			con= connection.getConnection();
			Status status =Status.OK;
			try {
				String query ="UPDATE `midterm`.`employee` SET `EMP_ID` = ?, `END_DATE` = ?, `FIRST_NAME` = ?, `LAST_NAME` = ?,`START_DATE` = ?,`TITLE` = ?,`ASSIGNED_BRANCH_ID` = ?,`DEPT_ID` = ?,`SUPERIOR_EMP_ID` = ? WHERE `EMP_ID` = "+id;
			
				
				String query1="UPDATE `midterm`.`employee` SET `EMP_ID` = ?, `END_DATE` = ?, `FIRST_NAME` = ?, `LAST_NAME` = ?,`START_DATE` = ?,`TITLE` = ?,`ASSIGNED_BRANCH_ID` = ?,`DEPT_ID` = ?,`SUPERIOR_EMP_ID` = ? WHERE `EMP_ID` = "+id;

				preparedStatement = con.prepareStatement(query);
				
				preparedStatement.setInt(1,employee.geteMP_ID());
				preparedStatement.setString(2, employee.geteND_DATE());		
				preparedStatement.setString(3, employee.getfIRST_NAME());
				preparedStatement.setString(4, employee.getlAST_NAME());
				preparedStatement.setString(5, employee.getsTART_DATE());
				preparedStatement.setString(6, employee.gettITLE());
				preparedStatement.setInt(7,employee.getaSSIGNED_BRANCH_ID());
				preparedStatement.setInt(8, employee.getdEPT_ID());
				preparedStatement.setInt(9,employee.getsUPERIOR_EMP_ID());
				
				
	int rowCount = preparedStatement.executeUpdate();
	    		
	    		if (rowCount > 0) 
	    		{
	    		status=Status.OK;
	    		mainObj.accumulate("status", status);
	    		mainObj.accumulate("Message","Data successfully updated !");
	    		
	    		}
	    		else
	    		{
	    			status=Status.NOT_MODIFIED;
	    			mainObj.accumulate("status", status);
	    			mainObj.accumulate("Message","Something Went Wrong");
	    						
	    		}
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    		status=Status.NOT_MODIFIED;
	    		mainObj.accumulate("status", status);
	    		mainObj.accumulate("Message","Something Went Wrong");
	    	}
	    	
	    	return Response.status(status).entity(mainObj.toString()).build();
	    }
		
	 		
		//Akshit new 1
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
	    @Path("/updateAcc/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateAcc(@PathParam("id")int id,Account account)
		{
			MysqlCon connection= new MysqlCon();
			con= connection.getConnection();
			Status status =Status.OK;
			try {
				String query ="UPDATE `midterm`.`account` SET `account_id` = ?, `avail_balance` = ?, `close_date` = ?, `last_activity_date` = ?, `open_date` = ?,`pending_balance` = ?,`status` = ?,`cust_id` = ?,`open_branch_id`= ?,`open_emp_id` = ?,`product_cd` = ? WHERE `account_id` = "+id;
			
				
				//String query1="UPDATE `midterm`.`employee` SET `EMP_ID` = ?, `END_DATE` = ?, `FIRST_NAME` = ?, `LAST_NAME` = ?,`START_DATE` = ?,`TITLE` = ?,`ASSIGNED_BRANCH_ID` = ?,`DEPT_ID` = ?,`SUPERIOR_EMP_ID` = ? WHERE `EMP_ID` = "+id;

				preparedStatement = con.prepareStatement(query);
				
				preparedStatement.setInt(1,account.getAccount_id());
				preparedStatement.setFloat(2,account.getAvail_balance());		
				preparedStatement.setString(3, account.getClose_date());		
				preparedStatement.setString(4, account.getLast_activity_date());
				preparedStatement.setString(5, account.getOpen_date());
				preparedStatement.setFloat(6, account.getPending_balance());
				preparedStatement.setString(7, account.getStatus());
				preparedStatement.setInt(8,account.getCust_id());
				preparedStatement.setInt(9, account.getOpen_branch_id());
				preparedStatement.setInt(10,account.getOpen_emp_id());
				preparedStatement.setString(11,account.getProduct_cd());
		
				
				
	int rowCount = preparedStatement.executeUpdate();
	    		
	    		if (rowCount > 0) 
	    		{
	    		status=Status.OK;
	    		mainObj.accumulate("status", status);
	    		mainObj.accumulate("Message","Data successfully updated !");
	    		
	    		}
	    		else
	    		{
	    			status=Status.NOT_MODIFIED;
	    			mainObj.accumulate("status", status);
	    			mainObj.accumulate("Message","Something Went Wrong");
	    						
	    		}
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    		status=Status.NOT_MODIFIED;
	    		mainObj.accumulate("status", status);
	    		mainObj.accumulate("Message","Something Went Wrong");
	    	}
	    	
	    	return Response.status(status).entity(mainObj.toString()).build();
	    }
		
		
		
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
	    @Path("/updateBuss/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateBuss(@PathParam("id")int id,Business bus)
		{
			MysqlCon connection= new MysqlCon();
			con= connection.getConnection();
			Status status =Status.OK;
			try {
				String query ="UPDATE `midterm`.`business` SET `incorp_date` = ?, `name` = ?, `state_id` = ?, `cust_id` = ? WHERE `cust_id` = "+id;
			
				
				//String query1="UPDATE `midterm`.`employee` SET `EMP_ID` = ?, `END_DATE` = ?, `FIRST_NAME` = ?, `LAST_NAME` = ?,`START_DATE` = ?,`TITLE` = ?,`ASSIGNED_BRANCH_ID` = ?,`DEPT_ID` = ?,`SUPERIOR_EMP_ID` = ? WHERE `EMP_ID` = "+id;

				preparedStatement = con.prepareStatement(query);
				
				preparedStatement.setString(1,bus.getIncorp_date());
				preparedStatement.setString(2,bus.getName());		
				preparedStatement.setString(3, bus.getState_id());		
				preparedStatement.setInt(4, bus.getCust_id());
				
				
				
	int rowCount = preparedStatement.executeUpdate();
	    		
	    		if (rowCount > 0) 
	    		{
	    		status=Status.OK;
	    		mainObj.accumulate("status", status);
	    		mainObj.accumulate("Message","Data successfully updated !");
	    		
	    		}
	    		else
	    		{
	    			status=Status.NOT_MODIFIED;
	    			mainObj.accumulate("status", status);
	    			mainObj.accumulate("Message","Something Went Wrong");
	    						
	    		}
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    		status=Status.NOT_MODIFIED;
	    		mainObj.accumulate("status", status);
	    		mainObj.accumulate("Message","Something Went Wrong");
	    	}
	    	
	    	return Response.status(status).entity(mainObj.toString()).build();
	    }

		@GET
		@Path("/getInd/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getInd(@PathParam("id") String id) {
			MysqlCon connection = new MysqlCon();

			con = connection.getConnection();

			try {
				stmt = con.createStatement();

				rs = stmt.executeQuery("Select * from individual where CUST_ID ="+id);

				while (rs.next()) {
					childObj = new JSONObject();
					childObj.accumulate("BIRTH_DATE", rs.getString("BIRTH_DATE"));
					childObj.accumulate("FIRST_NAME", rs.getString("FIRST_NAME"));
					childObj.accumulate("LAST_NAME", rs.getString("LAST_NAME"));
					childObj.accumulate("CUST_ID", rs.getString("CUST_ID"));


					jsonArray.put(childObj);
				}

				mainObj.put("Individual", jsonArray);
			} catch (SQLException e) {
				System.out.println("SQL Exception : " + e.getMessage());
			} finally {
				try {
					con.close();
					stmt.close();
					rs.close();
				} catch (SQLException e) {
					System.out.println("Finally Block SQL Exception : " + e.getMessage());
				}
			}

			return Response.status(200).entity(mainObj.toString()).build();

		}
		@GET
		@Path("/getprod/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getprod(@PathParam("id") String id) {
			MysqlCon connection = new MysqlCon();

			con = connection.getConnection();

			try {
				stmt = con.createStatement();

				rs = stmt.executeQuery("Select * from product_type where PRODUCT_TYPE_CD ="+id);

				while (rs.next()) {
					childObj = new JSONObject();
					childObj.accumulate("PRODUCT_TYPE_CD", rs.getString("PRODUCT_TYPE_CD"));
					childObj.accumulate("NAME", rs.getString("NAME"));


					jsonArray.put(childObj);
				}

				mainObj.put("product_type", jsonArray);
			} catch (SQLException e) {
				System.out.println("SQL Exception : " + e.getMessage());
			} finally {
				try {
					con.close();
					stmt.close();
					rs.close();
				} catch (SQLException e) {
					System.out.println("Finally Block SQL Exception : " + e.getMessage());
				}
			}

			return Response.status(200).entity(mainObj.toString()).build();

		}
		

		}
	