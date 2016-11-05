package com.huawei;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.zkclient.IZkChildListener;
import com.huawei.utils.ZkClientUtils;

@RestController
public class ZkClientController {
	// #region init

	@RequestMapping("/zkclient/init")
	@ResponseBody
	public String init() {
		// 1.init
		ZkClientUtils.init("127.0.0.1:2181");

		// 2.subscribeChildChanges
		ZkClientUtils.subscribeChildChanges("/", new IZkChildListener() {
			@Override
			public void handleChildChange(String parentPath, List<String> currentChildren) {
				onChildNodeChanges(currentChildren);
			}
		});

		return "registry init ok...";
	}

	private void onChildNodeChanges(List<String> currentChildren) {
		System.out.println("============各业务服务网络情况发生变化==============");
		System.out.println("STEP1.更新registry中的lstServiceStatusVo:" + currentChildren);
		System.out.println("STEP2.更新registry中的各个lstServiceStatusVo的Data:");
		for (String strNodePath : currentChildren) {
			String strNodeData = new String(ZkClientUtils.get("/" + strNodePath));
			System.out.println(strNodePath + ":" + strNodeData);
		}
	}

	// #endregion

	// #region lockService

	@RequestMapping("/zkclient/lockService")
	@ResponseBody
	public String lockService() {
		ZkClientUtils.set("/singleSim_9001", "project1_scenario2".getBytes());
		return "lockService ok...";
	}

	// #endregion

	// #region releaseService

	@RequestMapping("/zkclient/releaseService")
	@ResponseBody
	public String releaseService() {
		ZkClientUtils.set("/singleSim_9001", "null_null".getBytes());
		return "releaseService ok...";
	}

	// #endregion
}
