# 问题：分析Hashtable，HashMap，ConcurrentHashMap的区别与联系。
答案：因为三者都实现了Map接口，所以我想从函数角度比较与分析一下三者的关系。
先列出分析主要方法的列表：
public interface Map<K,V> {
    int size();
    V get(Object key);
    V put(K key, V value);
}

第一个，size():实际key的数量
Hashtable:使用synchronized来保证线程安全(以下相同)，当add entry时，count = count + 1。
HashMap:线程不安全(以下相同)，当add node时，size = size + 1。
ConcurrentHashMap:线程安全(以下相同)，使用baseCount + CounterCell[].values相加返回。

第二个，V get(Object key):获取指定的键关联的值
Hashtable:key不能为null，使用hash%length来计算位置，遍历单链表，先判断hash再判断equals，逻辑清晰简单明了。
HashMap:key可以为null，这样hash等于0了。使用(length - 1 & hash)来计算位置，同样也是取余法，不过前提是length是2的倍数，这样可以提高计算效率。遍历单链表或者或者遍历红黑树，先判断hash再判断equals。
ConcurrentHashMap:key不能为null,使用cas操作先判断hash再判断equals。

第三个，V put(K key, V value):
Hashtable:key/value不能为null，如果发现已存在的键，覆盖旧值，否则创建新的键值对加入到单链表中。
HashMap:key/value可以为null，如果发现已存在的键，覆盖旧值，否则创建新的键值对加入到单链表中，还有一个阈值判断，来决定是否将单链表红黑树化。
ConcurrentHashMap:key/value不能为null，和HashMap相同，通过使用while循环+cas操作+单链表使用synchronized来保证线程安全。

PS：
1.上述涉及到了数据结构的单链表的遍历，单链表的删除节点，红黑树的操作。
2.Hashtable建议：如果线程安全，请使用ConcurrentHashMap，如果线程不安全，请使用HashMap。
