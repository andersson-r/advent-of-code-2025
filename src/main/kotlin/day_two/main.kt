package day_two

import java.io.File

fun main() {

    val invalidIds = mutableListOf<Long>()
    val productIdRanges = File("src/main/kotlin/day_two/input.txt").useLines { seq ->
        seq.flatMap { it.split(",") }.toList()
    }

    for (productId in productIdRanges) {
        val (start, end) = productId.split("-").map { it.toLong() }
        for (x in start..end) {
            if (x.toString().first().digitToInt() == 0) {
                invalidIds.add(x)
            } else if (x.toString().length % 2 == 0) {
                val (left, right) = x.toString().chunked(x.toString().length / 2)
                    .map { it.toLong() }
                if (left == right) {
                    invalidIds.add(x)
                }
            }
        }

        println("Part one = ${invalidIds.sum()}")

    }
}