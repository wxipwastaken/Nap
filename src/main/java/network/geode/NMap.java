package network.geode;

import network.geode.interfaces.nmap.IClearListener;
import network.geode.interfaces.nmap.INMapListener;
import network.geode.interfaces.nmap.IPutListener;
import network.geode.interfaces.nmap.IRemoveListener;

import java.util.HashMap;

public class NMap<K, V> extends HashMap<K, V> {
    private IClearListener clearListener;
    private IPutListener<K, V> putListener;
    private IRemoveListener<Object, V> removeListener;
    private INMapListener<K, V> inMapListener;

    /**
     * Adds clear listener
     * See: {@link IClearListener#onClear()}
     */
    public void addClearListener(IClearListener clearListener) {
        this.clearListener = clearListener;
    }

    /**
     * Adds put listener
     * <p>
     * See: {@link IPutListener#onPut(K, V)}
     */
    public void addPutListener(IPutListener<K, V> putListener) {
        this.putListener = putListener;
    }

    /**
     * Adds remove listener
     * <p>
     * See: {@link IRemoveListener#onRemove(K, V)}
     */
    public void addRemoveListener(IRemoveListener<Object, V> removeListener) {
        this.removeListener = removeListener;
    }

    /**
     * Adds listener
     * <p>
     * See: {@link INMapListener}
     */
    public void addListener(INMapListener<K, V> inMapListener) {
        this.inMapListener = inMapListener;
    }

    /**
     * Removes clear listener
     * See: {@link IClearListener#onClear()}
     */
    public void removeClearListener() {
        this.clearListener = null;
    }

    /**
     * Removes put listener
     * <p>
     * See: {@link IPutListener#onPut(K, V)}
     */
    public void removePutListener() {
        this.putListener = null;
    }

    /**
     * Removes remove listener
     * <p>
     * See: {@link IRemoveListener#onRemove(K, V)}
     */
    public void removeRemoveListener() {
        this.removeListener = null;
    }

    /**
     * Removes listener
     * <p>
     * See: {@link INMapListener}
     */
    public void removeListener() {
        this.inMapListener = null;
    }

    /**
     * Puts provided key and value into this map. If privided key already exists, will update existing value and return the old one. <br>If {@link IPutListener#onPut(K, V)} listener is provided, will run its logic.
     *
     * @param key key of added entry
     * @param value value of added entry
     * @return previously associated value of {@link Object key}. Will return <b>null</b> if value didn't exist or was <b>null</b>.
     */
    @Override
    public V put(K key, V value) {
        if (inMapListener != null) inMapListener.onPut(key, value);
        else if (putListener != null) putListener.onPut(key, value);
        return super.put(key, value);
    }

    /**
     * Removes provided key (and value) from this map if it exists. <br>If {@link IRemoveListener#onRemove(K, V)} listener is provided, will run its logic.
     *
     * @param key key of entry which is going to be removed
     * @return previous associated value of {@link Object key}. Will return <b>null</b> if value didn't exist or was <b>null</b>.
     */
    @Override
    public V remove(Object key) {
        V value = super.remove(key);

        if (inMapListener != null) removeListener.onRemove(key, value);
        else if (removeListener != null) removeListener.onRemove(key, value);
        return value;
    }

    /**
     * Removes all entries from this map. <br>If {@link IClearListener#onClear()} listener is provided, will run its logic.
     */
    @Override
    public void clear() {
        if (inMapListener != null) clearListener.onClear();
        else if (clearListener != null) clearListener.onClear();
        super.clear();
    }
}
