package io.trydent.aoc2017

import java.nio.file.Files
import java.nio.file.Paths

interface ClassLoad

val resource = { it:String -> Files.readAllLines(Paths.get(ClassLoad::class.java.classLoader.getResource(it).toURI()))[0] }