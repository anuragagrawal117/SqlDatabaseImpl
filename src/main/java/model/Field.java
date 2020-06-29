package model;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
@ToString
@RequiredArgsConstructor
public class Field {

    private String fieldName;

    private Object fieldValue;

}
