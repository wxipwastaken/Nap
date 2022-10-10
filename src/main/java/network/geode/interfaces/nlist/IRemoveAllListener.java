package network.geode.interfaces.nlist;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface IRemoveAllListener {
    void onRemoveAll(@NotNull Collection<?> collection);
}
