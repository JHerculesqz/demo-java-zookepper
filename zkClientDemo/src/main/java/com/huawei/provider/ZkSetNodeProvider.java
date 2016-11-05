package com.huawei.provider;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.data.Stat;

import com.huawei.ZkClientDemoApplication;

public class ZkSetNodeProvider {
	public static void setData(String strNodePath, String strNodeData) {
		ZkClientDemoApplication.zooKeeper.setData(strNodePath, strNodeData.getBytes(), -1, new IStatCallback(),
				"setContext");
	}
}

class IStatCallback implements AsyncCallback.StatCallback {
	// #region processResult

	@Override
	public void processResult(int rc, String path, Object ctx, Stat stat) {
		ZkLsNodeProvider.ls("/");
	}

	// #endregion
}
