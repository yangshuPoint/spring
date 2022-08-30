package com.sys.text;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUcache extends LinkedHashMap<String, Object> {

    private int initialCapacity;

    public LRUcache(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    /**
     * @param initialCapacity 初时容量   默认16
     * @param loadFactor      加载因子  默认 0.75
     * @param accessOrder     是否记录 插入的顺序
     */
    public LRUcache(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
        this.initialCapacity = initialCapacity;
    }

    /**
     * @param eldest 最老的   最少使用的
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > initialCapacity;
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    public static void main(String[] args) throws InterruptedException {
        LRUcache ucache = new LRUcache(6, 0.5f, true);
        ucache.put("1", "yang1");
        ucache.put("2", "yang2");
        ucache.put("3", "yang3");

        System.out.println("--------------------------");
        System.out.println(ucache.get("1"));
        System.out.println(ucache.get("1"));

        System.out.println("--------------------------------------------");

        ucache.put("7", "yang7");
        ucache.put("8", "yang8");
        ucache.put("4", "yang4");
        ucache.put("5", "yang5");
        System.out.println(ucache.get("8"));
        ucache.put("6", "yang6");
        for (int i = 0; i < ucache.size(); i++) {
            System.out.print(i + "------------------");

            System.out.println(ucache.get(String.valueOf(i)));
        }

    }

    
}
