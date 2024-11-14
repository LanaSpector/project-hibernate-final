package io.sancta.sanctorum.redis;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Language {
    String language;
    Boolean isOfficial;
    BigDecimal percentage;
}
