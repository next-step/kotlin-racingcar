package racing

class InputView {
    fun get(prompt: String): Int {
        print(prompt)
        return readln().toPositiveIntOrNull() ?: retryGet(prompt)
    }
    
    fun getNames(prompt: String): List<Car> {
        print(prompt)
        val cars = readln().toCars()
        return cars.ifEmpty {
            retryGetNames(prompt)
        }
    }

    private fun retryGetNames(prompt: String): List<Car> {
        println("다시 입력해 주세요.")
        return getNames(prompt)
    }
    
    private fun String.toCars(): List<Car> {
        val names = this.split(",")
        val cars = mutableListOf<Car>()
        repeat(names.size) {
            cars.add(Car(names[it]))
        }
        
        return cars
    }

    private fun retryGet(prompt: String): Int {
        println("다시 입력해 주세요.")
        return get(prompt)
    }

    private fun String.toPositiveIntOrNull(): Int? {
        return toIntOrNull(radix = 10)?.takeIf { it > 0 }
    }
}
