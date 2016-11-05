package com.huawei.utils;

import java.util.List;

import org.apache.zookeeper.data.Stat;

import com.github.zkclient.IZkChildListener;
import com.github.zkclient.IZkClient;
import com.github.zkclient.IZkDataListener;
import com.github.zkclient.ZkClient;

public class ZkClientUtils {
	// #region Fields

	public static IZkClient zkClient;

	// #endregion

	// #region init

	public static void init(String strUrl) {
		zkClient = new ZkClient(strUrl);
	}

	// #endregion

	// #region ls

	public static List<String> ls(String strNodePath) {
		return zkClient.getChildren(strNodePath);
	}

	// #endregion

	// #region get

	public static byte[] get(String strNodePath) {
		return zkClient.readData(strNodePath, true);
	}

	// #endregion

	// #region create

	public static void create(String strNodePath, byte[] arrNodeData) {
		zkClient.createEphemeral(strNodePath, arrNodeData);
	}

	// #endregion

	// #region set

	public static Stat set(String strNodePath, byte[] arrNodeData) {
		return zkClient.writeData(strNodePath, arrNodeData);
	}

	// #endregion

	// #region subscribe

	public static void subscribeChildChanges(String strNodePath, IZkChildListener oIZkChildListener) {
		zkClient.subscribeChildChanges(strNodePath, oIZkChildListener);
	}

	public static void subscribeDataChanges(String strNodePath, IZkDataListener oIZkDataListener) {
		zkClient.subscribeDataChanges(strNodePath, oIZkDataListener);
	}

	// #endregion

	// #region unsubscribeAll

	public static void unsubscribeAll() {
		zkClient.unsubscribeAll();
	}

	// #endregion
}
