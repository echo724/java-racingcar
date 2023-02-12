package racingcar.model;

public class Car implements Comparable<Car> {
    private final CarName name;
    private final Position position;

    public Car(String carName) {
        this.name = new CarName(carName);
        this.position = new Position();
    }

    public void move(CarMovement movement) {
        if(movement.isMove()){
            this.position.increasePosition();
        }
    }

    public String getName() {
        return name.getName();
    }

    public Integer getPosition() {
        return position.getValue();
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }

}
