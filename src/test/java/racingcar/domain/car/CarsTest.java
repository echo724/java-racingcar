package racingcar.domain.car;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.movement.FixedMovementStrategy;
import racingcar.domain.movement.MovementStrategy;
import racingcar.exception.InvalidNameInputException;

public class CarsTest {

    @Test
    void createCarsBySplitComma() {
        String input = "pobi,seung,char";
        Cars cars = new Cars(input);
        List<Car> carList = cars.getCars();
        Assertions.assertThat(carList.size()).isEqualTo(3);
        Assertions.assertThat(carList.get(0)).isEqualTo(new Car("pobi"));
        Assertions.assertThat(carList.get(1)).isEqualTo(new Car("seung"));
        Assertions.assertThat(carList.get(2)).isEqualTo(new Car("char"));
    }

    @Test
    void errorOnContinuousComma() {
        String input = ",,,";
        Assertions.assertThatThrownBy(() -> {
            new Cars(input);
        }).isInstanceOf(InvalidNameInputException.class);
    }

    @Test
    @DisplayName("전략에 따라 자동차들이 움직인다.")
    public void testCarsMovement() {
        // given
        Cars cars = new Cars("pobi,seung,cha");
        MovementStrategy strategy = new FixedMovementStrategy();
        // when
        cars.move(strategy);
        // then
        List<Car> carList = cars.getCars();
        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(carList.get(i).getPosition()).isEqualTo(1);
        }
    }
}