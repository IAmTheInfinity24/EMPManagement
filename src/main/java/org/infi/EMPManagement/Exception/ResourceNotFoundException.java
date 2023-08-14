package org.infi.EMPManagement.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String Message) {
        super(Message);
    }

    public ResourceNotFoundException(String s, Long eid) {
        super(s+" "+eid);
    }
}
