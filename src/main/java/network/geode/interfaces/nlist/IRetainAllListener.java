package network.geode.interfaces.nlist;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface IRetainAllListener {
    void onRetainAll(@NotNull Collection<?> collection);
}
