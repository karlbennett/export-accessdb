package org.youthnet.export.domain.vb3;


import java.util.logging.Logger;


public class MetaData extends GenericDTO {


    private String type;
    private UuidUserType dtoId;
    private Logger log = Logger.getLogger(this.getClass().getName());


    public String getType() {
    }


    public void setType(String type) {
        this.type = type;
    }
}


    public void setSerializedObject(byte[] serializedObject) {
    }
this.serializedObject=serializedObject;
}
        }


public void setDigest(byte[]digest){
        this.digest=digest;
}


public UuidUserType getDtoId(){
        }


public void setDtoId(UuidUserType dtoId){
        this.dtoId=dtoId;
}
        }
