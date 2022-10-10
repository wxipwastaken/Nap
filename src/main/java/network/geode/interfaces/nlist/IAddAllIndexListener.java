package network.geode.interfaces.nlist;

import java.util.Collection;

public interface IAddAllIndexListener<E> {
    void onAddAll(int index, Collection<? extends E> collection);
}
