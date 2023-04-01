package test;

import java.sql.Connection;

import database.JDBC_Util;

public class test {
	public static void main(String[] args) {
		
		Connection con = JDBC_Util.getConnection();
		
		JDBC_Util.printInfo(con);
		
		JDBC_Util.closeConnection(con);
;	}
}
