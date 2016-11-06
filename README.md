1.目标
=========================
为论证"使用zookeeper，快速、可靠、及时实现分布式数据一致性"

2.Usage
=========================
	
	STEP1.启动zookeeper Server
	STEP2.启动zkClientDemo4Registry(gradles构建工程方法不赘述)
	STEP3.启动zkClientDemo4Single(gradles构建工程方法不赘述)
	STEP4.浏览器中访问http://localhost:9000/zkclient/init
	STEP5.浏览器中访问http://localhost:9001/zkclient/init，可查看zkClientDemo4Registry控制台中watcher的打印信息
	STEP6.浏览器中访问http://localhost:9000/zkclient/lockService，可查看zkClientDemo4Single控制台中watcher的打印信息
	STEP7.浏览器中访问http://localhost:9000/zkclient/releaseService，可查看zkClientDemo4Single控制台中watcher的打印信息
	STEP8.补充说明---zkClientDemo项目中采用原生zookeeper Client API
	
3.zookeeper的知识点
================
**1.zookeeper典型场景**

订阅/负载均衡/命名服务/分布式协调

**2.基本架构概念**

集群角色(Leader/Follower/Watcher)

会话(基于TCP)

数据节点(持久znode，临时znode)

版本(version当前znode版本号/cversion当前znode的子节点版本号/aversion当前znode的ACL变更版本号?)

watcher(在znode上注册若干的watcher发送变化)

ACL(CREATE/READ/WRITE/DELETE/ADMIN)

**3.ZK搭建**

单机、集群、伪集群

**4.常用命令**
	
	./zkcli.sh -timeout 0 -server 127.0.0.1:2181
	h
	ls /
	ls /node_1
	get /node_1
	stat /node_1
	ls2 /node_1
	create -s -e /node_1 123
	quit
	set /node_1 321
	rmr /node_1
	setquota -n 2 /node_1
	listquota /node_1
	delquota -n /node_1
	history
	redo <编号>
	
reference
============================================
	
	jikexueyuan
	java distributed synchronization
	http://stackoverflow.com/questions/6445512/distributed-synchronized-execution
	http://stackoverflow.com/questions/8907278/how-can-i-synchronize-two-java-applications
	http://stackoverflow.com/questions/92452/distributed-concurrency-control
	https://github.com/adyliu/zkclient/wiki/tutorial
	
