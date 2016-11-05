package com.huawei.provider;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;

import com.huawei.ZkClientDemoApplication;

public class ZkCreateNodeProvider {
	public static void create(String strNodePath, String strNodeData) {
		ZkClientDemoApplication.zooKeeper.create(strNodePath, strNodeData.getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL, new IStringCallback(), "createContext");
	}
}

class IStringCallback implements AsyncCallback.StringCallback {
	// #region processResult

	@Override
	public void processResult(int rc, String path, Object ctx, String name) {
		System.out.println("create ok:" + name);
	}

	// #endregion
}
