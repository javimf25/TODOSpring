package org.udg.pds.springtodo.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class IdObject {

    @NonNull
    private Long id;

    public IdObject (Long id){

        this.id=id;
    }
    public long getId(){

        return id;
    }

}
