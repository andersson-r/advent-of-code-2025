package day_one

import java.io.File

fun main() {

    val rotationsInput: List<String> = File("src/main/kotlin/day_one/input.txt").readLines()
    var pointedAtZero: Int = 0
    var passsedZero: Int = 0
    var pointer: Int = 50

    for (rotation in rotationsInput) {
        val direction: Char = rotation.get(0)
        val steps: Int = rotation.substring(1).toInt()
        repeat (steps) {
            if (direction == 'L') {
                pointer = ((pointer -1) % 100)
            } else {
                pointer = ((pointer + 1) % 100)
            }
            if (pointer == 0) {
                passsedZero++
            }
        }

        if (pointer == 0) {
            pointedAtZero++
        }
    }
    println("Step 1 = $pointedAtZero")
    println("Step 2 = $passsedZero")
}
