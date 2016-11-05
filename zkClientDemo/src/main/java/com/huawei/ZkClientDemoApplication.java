package com.huawei;

import java.io.IOException;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZkClientDemoApplication {
	// #region Fields

	public static ZooKeeper zooKeeper;

	// #endregion

	// #region main

	public static void main(String[] args) throws IOException, InterruptedException {
		zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new ZkClientWatcher());
		SpringApplication.run(ZkClientDemoApplication.class, args);
		Thread.sleep(Integer.MAX_VALUE);
	}

	// #endregion
}
