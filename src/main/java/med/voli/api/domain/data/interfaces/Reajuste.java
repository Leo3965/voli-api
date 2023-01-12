package med.voli.api.domain.data.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reajuste {
    BigDecimal valor();

    LocalDate data();

}
