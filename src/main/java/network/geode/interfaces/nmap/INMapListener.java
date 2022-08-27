package network.geode.interfaces.nmap;

public interface INMapListener<K, V> extends IClearListener, IPutListener<K, V>, IRemoveListener<Object, V> {
    void onClear();

    void onPut(K key, V value);

    void onRemove(Object key, V value);
}
