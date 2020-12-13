import com.kkagurazaka.reactive.repository.annotation.InMemoryRepository;
import io.reactivex.rxjava3.core.Flowable;
import org.jetbrains.annotations.NotNull;

@InMemoryRepository(InMemoryFieldEntity.class)
public interface InMemoryFieldEntityNotTargetFlowableRepository {

    @NotNull
    Flowable<InMemoryNotTargetEntity> observe();
}
