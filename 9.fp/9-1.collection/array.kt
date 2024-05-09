package main.kotlin.fp.collection

fun array() {
    val array = arrayOf(100, 200)

    for (i in array.indices) {      // indices -> 0 부터 마지막 까지의 Range
        println("${i} ${array[i]}")
    }

    array.plus(300)

    for ((idx, value) in array.withIndex()) {   // index 와 값을 한번에 Range
        println("${idx} ${value}")
    }
}
