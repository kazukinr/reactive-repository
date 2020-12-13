import com.kkagurazaka.reactive.repository.annotation.InMemoryRepository;
import io.reactivex.rxjava3.core.Observable;
import org.jetbrains.annotations.NotNull;

@InMemoryRepository(InMemoryFieldEntity.class)
public interface InMemoryFieldEntityNotTargetObservableRepository {

    @NotNull
    Observable<InMemoryNotTargetEntity> observe();
}
