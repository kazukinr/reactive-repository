import com.kkagurazaka.reactive.repository.annotation.InMemoryRepository;
import io.reactivex.rxjava3.core.Observable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@InMemoryRepository(InMemoryFieldEntity.class)
public interface InMemoryFieldEntityNullableSetterWithRx2Repository {

    @NotNull
    Observable<InMemoryFieldEntity> observe();

    void store(@Nullable InMemoryFieldEntity entity);
}
