package model;

import java.io.Serializable;

public interface BaseModel<PK extends Serializable> {

    PK getId();
}
