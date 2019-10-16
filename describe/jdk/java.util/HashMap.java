基本组成原理：数组+链表+红黑树，采用取模法作为哈希函数，采用链地址法解决哈希冲突问题

基本操作：
v get(k);
put(k,v);
remove(k);

负载因子LoadFactor=0.75，表明节点数量在容器中占用的最大比例
树化阈值treeify threshold=8
去树化阈值untreeify threshold=6

node的hashcode是采用k的哈希异或v的哈希

计算hash过程：
1.如果key是null，返回0
2.如果key不是null，先计算h=key.hashCode()，返回h^(h>>>16)



v get(k)步骤：
1.计算哈希值hash
2.做取模运算寻找桶位置，简便方法是(table.length - 1) & hash，前提table的大小必须是2的倍数才能做简便操作
3.如果表不为空并且桶位置存在元素，则开始从第一个元素开始比较，就是一个单链表搜索
4.如果第一个值不相同，则分为两种TreeNode与普通Node情况处理，普通Node之间循环搜索就行

put(k,v)步骤：
1.计算哈希值hash
2.如果table为空，resize()
3.计算桶位置(table.length - 1) & hash，如果当前位置为空，直接新建节点赋值
4.如果第一个值不为空，比较是否是第一个值，如果是，就将新值覆盖旧值，返回旧值
5.如果第一个值不为空，不是第一个值，看看是否是TreeNode，转入TreeNode节点操作，否则循环搜索单链表，并且如果大小超过8，单链表树化
6.最后，检测大小是否超过负载因子*整个数组长度，进行resize



resize()步骤：双倍扩容，重新赋值


remove(k)步骤：
1.计算哈希值hash
2.如果是链表，直接单链表删除节点，如果是TreeNode，删除树节点，还需要判断是否小于6，红黑树将会链化



线程安全问题：
1.使用并发包中的ConcurrentHashMap
2.java.util.Collections.synchronizedMap(Map<K, V>)装饰器模式，代理模式













