package com.huawei.provider;

import java.util.List;

import org.apache.zookeeper.AsyncCallback;

import com.huawei.ZkClientDemoApplication;

public class ZkLsNodeProvider {
	public static void ls(String strNodePath) {
		ZkClientDemoApplication.zooKeeper.getChildren(strNodePath, true, new IChildrenCallback(), "lsContext");
	}
}

class IChildrenCallback implements AsyncCallback.ChildrenCallback {
	// #region processResult

	@Override
	public void processResult(int rc, String path, Object ctx, List<String> children) {
		System.out.println("ls Root:" + children);
		ZkGetNodeProvider.getData("/singleSim_8001");
	}

	// #endregion
}
