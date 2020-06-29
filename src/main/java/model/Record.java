package model;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashMap;

@Getter
@Setter
@Accessors(fluent = true)
@ToString
@RequiredArgsConstructor
public class Record {

    private HashMap<String, Field> fields = new HashMap<String, Field>();
}
