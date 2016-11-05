package com.huawei.provider;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.data.Stat;

import com.huawei.ZkClientDemoApplication;

public class ZkGetNodeProvider {
	public static void getData(String strNodePath) {
		ZkClientDemoApplication.zooKeeper.getData(strNodePath, true, new IDataCallback(), "getContext");
	}
}

class IDataCallback implements AsyncCallback.DataCallback {
	// #region processResult

	@Override
	public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
		System.out.println("get " + path + ":" + String.valueOf(data));
	}

	// #endregion
}
