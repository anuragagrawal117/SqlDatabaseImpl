package model;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
@ToString
@RequiredArgsConstructor
public class AllowedField {

    private String fieldName;

    private FieldType fieldType;

    private boolean required;
}
