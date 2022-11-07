package racingCar.domain

import java.util.stream.Collectors
import java.util.stream.IntStream

class Cars (carNumber : Int ){

    private val cars :List<Car> = IntStream.range(0,carNumber)
                .mapToObj { index -> Car() }
                .collect(Collectors.toList())
}
