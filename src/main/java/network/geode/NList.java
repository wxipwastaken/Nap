package network.geode;

import network.geode.interfaces.nlist.*;

import java.util.ArrayList;
import java.util.Collection;

public class NList<E> extends ArrayList<E> {
    private IAddAllIndexListener<E> addAllIndexListener;
    private IAddAllListener<E> addAllListener;
    private IAddIndexListener<E> addIndexListener;
    private IAddListener<E> addListener;
    private IClearListener clearListener;
    private IRemoveAllListener removeAllListener;
    private IRemoveIndexListener removeIndexListener;
    private IRemoveListener removeListener;
    private IRemoveRangeListener removeRangeListener;
    private IRetainAllListener retainAllListener;
    private ISetListener<E> setListener;
    private INListListener<E> nListListener;

    public void addAddAllIndexListener(IAddAllIndexListener<E> addAllIndexListener) {
        this.addAllIndexListener = addAllIndexListener;
    }

    public void addAddAllListener(IAddAllListener<E> addAllListener) {
        this.addAllListener = addAllListener;
    }

    public void addAddIndexListener(IAddIndexListener<E> addIndexListener) {
        this.addIndexListener = addIndexListener;
    }

    public void addAddListener(IAddListener<E> addListener) {
        this.addListener = addListener;
    }

    public void addClearListener(IClearListener clearListener) {
        this.clearListener = clearListener;
    }

    public void addRemoveAllListener(IRemoveAllListener removeAllListener) {
        this.removeAllListener = removeAllListener;
    }

    public void addRemoveIndexListener(IRemoveIndexListener removeIndexListener) {
        this.removeIndexListener = removeIndexListener;
    }

    public void addRemoveListener(IRemoveListener removeListener) {
        this.removeListener = removeListener;
    }

    public void addRemoveRangeListener(IRemoveRangeListener removeRangeListener) {
        this.removeRangeListener = removeRangeListener;
    }

    public void addRetainAllListener(IRetainAllListener retainAllListener) {
        this.retainAllListener = retainAllListener;
    }

    public void addSetListener(ISetListener<E> setListener) {
        this.setListener = setListener;
    }

    public void addListener(INListListener<E> nListListener) {
        this.nListListener = nListListener;
    }


    public void removeAddAllIndexListener() {
        this.addAllIndexListener = null;
    }

    public void removeAddAllListener() {
        this.addAllListener = null;
    }

    public void removeAddIndexListener() {
        this.addIndexListener = null;
    }

    public void removeAddListener() {
        this.addListener = null;
    }

    public void removeClearListener() {
        this.clearListener = null;
    }

    public void removeRemoveAllListener() {
        this.removeAllListener = null;
    }

    public void removeRemoveIndexListener() {
        this.removeIndexListener = null;
    }

    public void removeRemoveListener() {
        this.removeListener = null;
    }

    public void removeRemoveRangeListener() {
        this.removeRangeListener = null;
    }

    public void removeRetainAllListener() {
        this.retainAllListener = null;
    }

    public void removeSetListener() {
        this.setListener = null;
    }

    public void removeListener() {
        this.nListListener = null;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (addAllIndexListener != null) addAllIndexListener.onAddAll(index, c);
        else if (nListListener != null) nListListener.onAddAll(index, c);

        return super.addAll(index, c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (addAllListener != null) addAllListener.onAddAll(c);
        else if (nListListener != null) nListListener.onAddAll(c);

        return super.addAll(c);

    }

    @Override
    public void add(int index, E element) {
        if (addIndexListener != null) addIndexListener.onAddListener(index, element);
        else if (nListListener != null) nListListener.onAddListener(index, element);

        super.add(index, element);
    }

    @Override
    public boolean add(E e) {
        if (addListener != null) addListener.onAddListener(e);
        else if (nListListener != null) nListListener.onAddListener(e);

        return super.add(e);
    }

    @Override
    public void clear() {
        if (clearListener != null) clearListener.onClear();
        else if (nListListener != null) nListListener.onClear();

        super.clear();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (removeAllListener != null) removeAllListener.onRemoveAll(c);
        else if (nListListener != null) nListListener.onRemoveAll(c);

        return super.removeAll(c);
    }

    @Override
    public E remove(int index) {
        if (removeIndexListener != null) removeIndexListener.onRemove(index);
        else if (nListListener != null) nListListener.onRemove(index);

        return super.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        if (removeListener != null) removeListener.onRemove(o);
        else if (nListListener != null) nListListener.onRemove(o);

        return super.remove(o);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        if (removeRangeListener != null) removeRangeListener.onRemoveRange(fromIndex, toIndex);
        else if (nListListener != null) nListListener.onRemoveRange(fromIndex, toIndex);

        super.removeRange(fromIndex, toIndex);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (retainAllListener != null) retainAllListener.onRetainAll(c);
        else if (nListListener != null) nListListener.onRetainAll(c);

        return super.retainAll(c);
    }

    @Override
    public E set(int index, E element) {
        if (setListener != null) setListener.onSet(index, element);
        else if (nListListener != null) nListListener.onSet(index, element);

        return super.set(index, element);
    }
}
