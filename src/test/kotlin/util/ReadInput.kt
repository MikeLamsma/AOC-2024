package util

import java.io.FileNotFoundException

fun readInput(name: String) = object {}::class.java
    .getResourceAsStream("/$name.txt")
    ?.bufferedReader()
    ?.readLines() ?: throw FileNotFoundException()
