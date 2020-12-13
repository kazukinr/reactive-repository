import com.kkagurazaka.reactive.repository.annotation.InMemoryRepository;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

@InMemoryRepository(NotAnnotatedEntity.class)
public interface NotAnnotatedEntityInMemoryRepository {

    NotAnnotatedEntity get();

    Observable<NotAnnotatedEntity> observe();

    Flowable<NotAnnotatedEntity> observeWithBackpressure();

    void store(NotAnnotatedEntity entity);
}
