package TaskList.entity;

import lombok.Getter;

@Getter

public enum StateType {
    COMPLETED("COMPLETED"), PENDING("PENDING"), SUSPENDED("SUSPENDED");

    final String name;

    StateType(String name){
        this.name=name;
    }


}
