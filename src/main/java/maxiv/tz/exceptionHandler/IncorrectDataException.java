package maxiv.tz.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class IncorrectDataException extends RuntimeException{
    public IncorrectDataException(String m){
        super(m);
        log.error(m);
    }





}
