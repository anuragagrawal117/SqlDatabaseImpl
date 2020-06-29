package model.fieldtype;

import exceptions.InvalidFieldException;
import model.FieldType;

public class IntegerType extends FieldType {

    public void validate(Object fieldValue){
        if(!(fieldValue instanceof Integer)){
            throw new InvalidFieldException("field value not integer!");
        }
        Integer value = (Integer) fieldValue;

        if(value >= 1024 || value <= -1024){
            throw new InvalidFieldException("field integer limit exceeded!");
        }
    }
}
