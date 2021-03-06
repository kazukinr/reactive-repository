import com.kkagurazaka.reactive.repository.annotation.InMemoryRepository;
import io.reactivex.rxjava3.core.Flowable;
import org.jetbrains.annotations.Nullable;

@InMemoryRepository(InMemoryFieldEntity.class)
public interface InMemoryFieldEntityNullableFlowableRepository {

    @Nullable
    Flowable<InMemoryFieldEntity> observe();
}
