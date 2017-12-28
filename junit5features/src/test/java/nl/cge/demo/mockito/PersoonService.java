package nl.cge.demo.mockito;

import javax.inject.Inject;
import java.util.Optional;

public class PersoonService {

    @Inject
    private PersoonDao persoonDao;

    public Persoon createPersoon(String naam) {
        Optional<Persoon> persoon = persoonDao.findByName(naam);
        if (persoon.isPresent()) {
            return persoon.get();
        }
        Persoon newPersoon = new Persoon(naam);
        return persoonDao.persist(newPersoon);
    }
}
