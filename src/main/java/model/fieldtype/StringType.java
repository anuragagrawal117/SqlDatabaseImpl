package model.fieldtype;

import exceptions.InvalidFieldException;
import model.FieldType;

public class StringType extends FieldType {

    public void validate(Object fieldValue){
        if(!(fieldValue instanceof String)){
            throw new InvalidFieldException("field value not string!");
        }
        String value = (String) fieldValue;

        if(value.length() > 20){
            throw new InvalidFieldException("field string limit exceeded!");
        }
    }

}
