package com.lovecws.shop.common.dao.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.lovecws.common.core.entity.DBField;
import com.lovecws.common.core.entity.DBTable;
import com.lovecws.shop.common.dao.CommonDao;

@Repository
public class CommonDaoImpl extends SqlSessionDaoSupport implements CommonDao{

	/**
	 * 注入SqlSessionTemplate实例(要求Spring中进行SqlSessionTemplate的配置).
	 * 可以调用sessionTemplate完成数据库操作.
	 */
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	@Resource
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public SqlSession getSqlSession() {
		return super.getSqlSession();
	}

	/**
	 * @return 返回数据库所有的 TABLE
	 */
	@Override
	public List<DBTable> getAllTable() {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<DBTable> list = new ArrayList<DBTable>();
		try {
			connection = sessionTemplate.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			// 获取所有类型为 TABLE 的表
			rs = metaData.getTables(null, null, null, new String[] { "TABLE" });
			while (rs.next()) {
				String TABLE_NAME = rs.getString("TABLE_NAME");
				// 去除一些系统表(以SQL_开头)
				if (!TABLE_NAME.startsWith("SQL_")) {
					list.add(new DBTable(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					//connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * @param tableName
	 * @return 获取一个表的所有字段的属性
	 */
	@Override
	public List<DBField> getAllField(String tableName) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<DBField> list = new ArrayList<DBField>();
		try {
			connection = sessionTemplate.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			rs = metaData.getColumns(null, null, tableName, null);
			while (rs.next()) {
				list.add(new DBField(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					//connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 获取一个表的所有数据
	 * @param tableName  表名
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getAll(String tableName) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			connection=sessionTemplate.getConnection();
			pst = connection.prepareStatement("SELECT *FROM " + tableName);
			rs = pst.executeQuery();
			// 获取metadata属性
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				// 循环 将一条记录保存到一个map中
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					// TODO 当把 表的数据 blob clob 保存到内存中的时候 可能会报内存溢出一场
					map.put(metaData.getColumnName(i), rs.getString(i));
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					//connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
