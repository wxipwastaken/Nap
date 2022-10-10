package network.geode.interfaces.nlist;

import java.util.Collection;

public interface IAddAllListener<E> {
    void onAddAll(Collection<? extends E> collection);
}
