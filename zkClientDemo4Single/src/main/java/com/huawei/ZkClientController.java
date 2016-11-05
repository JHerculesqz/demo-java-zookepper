package com.huawei;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.zkclient.IZkDataListener;
import com.huawei.utils.ZkClientUtils;

@RestController
public class ZkClientController {
	// #region init

	@RequestMapping("/zkclient/init")
	@ResponseBody
	public String init() {
		// 1.init
		ZkClientUtils.init("127.0.0.1:2181");

		// 2.reg
		ZkClientUtils.create("/singleSim_9001", "null_null".getBytes());

		// 2.subscribeDataChanges
		ZkClientUtils.subscribeDataChanges("/singleSim_9001", new IZkDataListener() {
			@Override
			public void handleDataChange(String dataPath, byte[] data) throws Exception {
				onNodeDataChanges(dataPath, data);
			}

			@Override
			public void handleDataDeleted(String dataPath) throws Exception {

			}
		});

		return "singleSim_9001 init ok...";
	}

	private void onNodeDataChanges(String dataPath, byte[] data) {
		System.out.println("=====================Registry发出lockService消息,本服务同步更新进程内数据=====================");
		System.out.println(dataPath + ":" + new String(data));
	}

	// #endregion
}
