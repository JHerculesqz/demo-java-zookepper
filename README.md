=============1.Ŀ��================
Ϊ��֤"ʹ��zookeeper�����١��ɿ�����ʱʵ�ֲַ�ʽ����һ����"

=============2.Usage================
	
	STEP1.����zookeeper Server
	STEP2.����zkClientDemo4Registry
	STEP3.����zkClientDemo4Single
	STEP4.������з���http://localhost:9000/zkclient/init
	STEP5.������з���http://localhost:9001/zkclient/init���ɲ鿴zkClientDemo4Registry����̨��watcher�Ĵ�ӡ��Ϣ
	STEP6.������з���http://localhost:9001/zkclient/lockService���ɲ鿴zkClientDemo4Single����̨��watcher�Ĵ�ӡ��Ϣ
	STEP7.������з���http://localhost:9001/zkclient/releaseService���ɲ鿴zkClientDemo4Single����̨��watcher�Ĵ�ӡ��Ϣ
	STEP8.����˵��---zkClientDemo��Ŀ�в���ԭ��zookeeper Client API
	
============3.zookeeper��֪ʶ��================
1.zookeeper���ͳ���

����/���ؾ���/��������/�ֲ�ʽЭ��

2.�����ܹ�����

��Ⱥ��ɫ(Leader/Follower/Watcher)

�Ự(����TCP)

���ݽڵ�(�־�znode����ʱznode)

�汾(version��ǰznode�汾��/cversion��ǰznode���ӽڵ�汾��/aversion��ǰznode��ACL����汾��?)

watcher(��znode��ע�����ɵ�watcher���ͱ仯)

ACL(CREATE/READ/WRITE/DELETE/ADMIN)

3.ZK�

��������Ⱥ��α��Ⱥ

4.��������
	
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
	redo <���>
	
5.reference:
	
	jikexueyuan
	java distributed synchronization
	http://stackoverflow.com/questions/6445512/distributed-synchronized-execution
	http://stackoverflow.com/questions/8907278/how-can-i-synchronize-two-java-applications
	http://stackoverflow.com/questions/92452/distributed-concurrency-control
	https://github.com/adyliu/zkclient/wiki/tutorial
	