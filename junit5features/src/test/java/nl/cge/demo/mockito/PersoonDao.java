package nl.cge.demo.mockito;

import java.util.List;
import java.util.Optional;

public interface PersoonDao {

    Persoon persist(Persoon persoon);

    Persoon read(Long persoonId);

    Optional<Persoon> findByName(String name);
}
