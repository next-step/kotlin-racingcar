package racingcar.feedback;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilsTest {
    @Test
    void 코틀린상수() {
        assertThat(NumberUtils.FORWARD_NUMBER).isEqualTo(4);
        Car defaultCar = Car.DEFAULT_CAR;
    }
}
