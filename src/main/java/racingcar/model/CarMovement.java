package racingcar.model;

public class CarMovement {

    private static final String OUT_OF_MOVEMENT_RANGE_EXCEPTION = "범위 밖의 움직임 값입니다.";
    private final Integer value;

    public CarMovement(Integer value){
        this.validate(value);
        this.value = value;
    }

    private void validate(Integer value){
        if(value >= 10 || value < 0){
            throw new IllegalArgumentException(OUT_OF_MOVEMENT_RANGE_EXCEPTION);
        }
    }

    public boolean isMove(){
        return value >= 4;
    }
}
