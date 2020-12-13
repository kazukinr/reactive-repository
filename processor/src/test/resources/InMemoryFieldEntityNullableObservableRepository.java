import com.kkagurazaka.reactive.repository.annotation.InMemoryRepository;
import io.reactivex.rxjava3.core.Observable;
import org.jetbrains.annotations.Nullable;

@InMemoryRepository(InMemoryFieldEntity.class)
public interface InMemoryFieldEntityNullableObservableRepository {

    @Nullable
    Observable<InMemoryFieldEntity> observe();
}
