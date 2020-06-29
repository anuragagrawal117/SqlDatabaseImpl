import exceptions.RequiredFieldException;
import model.*;
import model.fieldtype.IntegerType;
import model.fieldtype.StringType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DatabaseImplService {


    public static Database createDatabase(String name){
        return new Database(name);
    }

    public static Table createTable(Database database, String tableName, List<AllowedField> allowedFields){
        if(database.tables().containsKey(tableName)) return database.tables().get(tableName);
        Table table = new Table(tableName);
        table.name(tableName).allowedFields(allowedFields);
        database.tables().put(tableName, table);
        return table;
    }

    public static boolean deleteTable(Database database, String tableName){
        if(!database.tables().containsKey(tableName)) return false;
        database.tables().remove(tableName);
        return true;
    }

    public static Record addRecord(Table table, HashMap<String, Field> fields){
        Record record = new Record();
        for(AllowedField allowedField: table.allowedFields()){
            if(allowedField.required() && !fields.containsKey(allowedField.fieldName())){
                throw new RequiredFieldException(allowedField.fieldName() + "required field missing!");
            }

            if(fields.containsKey(allowedField.fieldName())){
                Field field = fields.get(allowedField.fieldName());
                allowedField.fieldType().validate(field.fieldValue());
                record.fields().put(allowedField.fieldName(), field);
            }
        }
        table.records().add(record);
        return record;
    }


    public static void main(String[] args) {
        Database db1 = createDatabase("StudentDb");

        List<AllowedField> allowedFields = new ArrayList<AllowedField>();
        allowedFields.add(new AllowedField().fieldName("rollNo").fieldType(new IntegerType()).required(true));
        allowedFields.add(new AllowedField().fieldName("name").fieldType(new StringType()).required(true));
        allowedFields.add(new AllowedField().fieldName("age").fieldType(new IntegerType()).required(false));
        allowedFields.add(new AllowedField().fieldName("marks").fieldType(new IntegerType()).required(false));
        Table students = createTable(db1, "Student", allowedFields);

        HashMap<String, Field> fields = new HashMap<String, Field>();
        fields.put("rollNo", new Field()
                .fieldName("rollNo")
                .fieldValue(1));
        fields.put("name", new Field()
                .fieldName("name")
                .fieldValue("Anurag"));
        fields.put("age", new Field()
                .fieldName("age")
                .fieldValue(27));
        fields.put("marks", new Field()
                .fieldName("marks")
                .fieldValue(50));
        Record record1 = addRecord(students, fields);

        HashMap<String, Field> fields2 = new HashMap<String, Field>();
        fields2.put("rollNo", new Field()
                .fieldName("rollNo")
                .fieldValue(2));
        fields2.put("name", new Field()
                .fieldName("name")
                .fieldValue("Agrawal"));
        fields2.put("age", new Field()
                .fieldName("age")
                .fieldValue(28));
        fields2.put("marks", new Field()
                .fieldName("marks")
                .fieldValue(60));
        Record record2 = addRecord(students, fields2);


        System.out.println("Database: " + db1);
    }
}
