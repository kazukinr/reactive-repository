import com.kkagurazaka.reactive.repository.annotation.PrefsRepository;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

@PrefsRepository(NotAnnotatedEntity.class)
public interface NotAnnotatedEntityPrefsRepository {

    NotAnnotatedEntity get();

    Observable<NotAnnotatedEntity> observe();

    Flowable<NotAnnotatedEntity> observeWithBackpressure();

    void store(NotAnnotatedEntity entity);
}
