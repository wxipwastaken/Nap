package network.geode.interfaces.nmap;

public interface IRemoveListener<Object, V> {
    void onRemove(Object key, V value);
}
