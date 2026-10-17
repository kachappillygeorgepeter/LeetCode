class MyHashSet
{
    boolean hashSet[];
    MyHashSet()
    {
        hashSet=new boolean[1000001]; // The number since the constraint is '0 <= key <= 10^6'
    }
    void add(int key)
    {
        hashSet[key] = true;
    }
    void remove(int key)
    {
        hashSet[key] = false;
    }
    boolean contains(int key)
    {
        return hashSet[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */