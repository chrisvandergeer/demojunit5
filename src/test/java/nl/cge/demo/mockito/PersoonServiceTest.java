package nl.cge.demo.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersoonServiceTest {

    @Mock
    private PersoonDao persoonDao;

    @InjectMocks
    private PersoonService cut;

    @Test
    public void testMe() {
        // GIVEN
        String naam = "Jan Jansen";
        String id = UUID.randomUUID().toString();
        when(persoonDao.findByName(naam)).thenReturn(Optional.empty());
        when(persoonDao.persist(any(Persoon.class))).thenAnswer(new Answer<Persoon>() {
            @Override
            public Persoon answer(InvocationOnMock invocationOnMock) throws Throwable {
                Persoon persoon = invocationOnMock.getArgument(0);
                persoon.setId(id);
                return persoon;
            }
        });

        // WHEN
        Persoon persoon = cut.createPersoon(naam);

        // THEN
        assertEquals(id, persoon.getId());
        verify(persoonDao).findByName(naam);
    }

}