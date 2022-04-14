package com.sasanka.demoapp;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//new actuator endpoint

@Component //makes this class as a bean
@Endpoint(id="stage") //this id uses after actuator/stage  in url
public class StageEndpoint {
    Map<String,Stage> stages = new ConcurrentHashMap<>();

    @ReadOperation //http GET call will come and map here
    public Map<String, Stage> getStages() {
        return stages;
    }

    @ReadOperation
    public Stage getStage(@Selector String name){ //@Selector operates according to the given value
        return stages.get(name);
    }

    @WriteOperation
    public void setValue(@Selector String name, int stage){ //stage/name in url
        stages.put(name,new Stage(stage));
    }

    static class Stage{
        int value;

        public Stage(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
