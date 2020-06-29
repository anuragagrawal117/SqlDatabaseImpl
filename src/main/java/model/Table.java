package model;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Accessors(fluent = true)
@ToString
@RequiredArgsConstructor
public class Table {

    private @NonNull String name;

    private List<Record> records = new ArrayList<Record>();

    private List<AllowedField> allowedFields = new ArrayList<AllowedField>();

}
