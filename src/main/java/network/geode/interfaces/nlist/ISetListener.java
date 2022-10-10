package network.geode.interfaces.nlist;

public interface ISetListener<E> {
    void onSet(int index, E element);
}
