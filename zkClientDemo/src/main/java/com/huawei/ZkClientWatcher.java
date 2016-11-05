package com.huawei;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;

import com.huawei.provider.ZkCreateNodeProvider;
import com.huawei.provider.ZkLsNodeProvider;

public class ZkClientWatcher implements Watcher {
	// #region process

	@Override
	public void process(WatchedEvent event) {
		if (event.getState().equals(KeeperState.SyncConnected)) {
			if (event.getType().equals(EventType.None)) {
				ZkCreateNodeProvider.create("/singleSim_8001", "");
				ZkLsNodeProvider.ls("/");
			} else {
				if (event.getType().equals(EventType.NodeChildrenChanged)) {
					ZkLsNodeProvider.ls("/");
				} else if (event.getType().equals(EventType.NodeDataChanged)) {
					ZkLsNodeProvider.ls("/singleSim_8001");
				}
			}
		}
	}

	// #endregion
}
