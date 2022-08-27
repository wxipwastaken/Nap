package network.geode.interfaces.nmap;

public interface IPutListener<K, V> {
    void onPut(K key, V value);
}
