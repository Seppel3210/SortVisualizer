package de.seppel3210.sortVisualizer.sorts

fun gnomeSort(array: Array<Int>) {
    var pos = 0
    while (pos < array.size) {
        if (pos == 0 || array[pos] >= array[pos - 1])
            pos += 1
        else {
            swap(array, pos, pos - 1)
            pos -= 1
        }
        Thread.sleep(1)
    }
}

fun swap(array: Array<Int>, a: Int, b: Int) {
    val temp = array[a]
    array[a] = array[b]
    array[b] = temp
}