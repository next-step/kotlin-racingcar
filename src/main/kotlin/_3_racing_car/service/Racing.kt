package _3_racing_car.service

class Racing {
    fun run(input: InputDto): List<Int> = input.tracks.map {
        it.run(input.times)
    }
}
