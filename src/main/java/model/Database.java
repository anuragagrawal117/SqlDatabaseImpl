package model;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashMap;


@Getter
@Setter
@Accessors(fluent = true)
@RequiredArgsConstructor
@ToString
public class Database {

    private @NonNull String name;

    private HashMap<String, Table> tables = new HashMap<String, Table>();
}
