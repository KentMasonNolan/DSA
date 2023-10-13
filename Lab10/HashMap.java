package Lab10;

public class HashMap {

    public static void main(String[] args) {
        System.out.println("CBA".hashCode());
        System.out.println("CA`".hashCode());


    }

//    public V put(K key, V value){
//        if (key == null)
//            return putForNullKey(value);
//    int hash = hash(key.hashCode());
//    int i = indexFor(hash, table.length);
//    for (Entry<K,V> e = table[i]; e != null; e=e.next){
//        Object k;
//        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
//            V oldValue = e.value;
//            e.recordAccess(this);
//            return oldValue;
//        }
//    }
//    modCount++;
//    addEntry(has,key,value,i);
//    return null;
//    }
}
