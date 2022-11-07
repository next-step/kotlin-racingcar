package racingCar.domain

import java.util.stream.Collectors
import java.util.stream.IntStream

class Cars (carNumber : Int , val strategy :MoveStrategy){

    private val cars :List<Car>  =
        IntStream.range(0,carNumber)
            .mapToObj { Car() }
            .collect(Collectors.toList())


    fun moveByStrategy() {
        cars.forEach {
            if (strategy.move()){
                it.move()
            }
        }
    }
}
