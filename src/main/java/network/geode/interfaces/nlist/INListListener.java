package network.geode.interfaces.nlist;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface INListListener<E> extends IAddAllIndexListener<E>, IAddAllListener<E>, IAddIndexListener<E>, IAddListener<E>, IClearListener, IGetListener, IRemoveAllListener, IRemoveIndexListener, IRemoveListener, IRemoveRangeListener, IRetainAllListener, ISetListener<E> {
    void onAddAll(Collection<? extends E> collection);

    void onAddAll(int index, Collection<? extends E> collection);

    void onAddListener(E element);

    void onAddListener(int index, E element);

    void onClear();

    void onGetListener(int index);

    void onRemoveAll(@NotNull Collection<?> collection);

    void onRemove(int index);

    void onRemove(Object o);

    void onRemoveRange(int fromIndex, int toIndex);

    void onRetainAll(@NotNull Collection<?> collection);

    void onSetListener(int index, E element);
}
