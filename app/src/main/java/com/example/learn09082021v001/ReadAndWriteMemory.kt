package com.example.learn09082021v001

import android.content.Context
import android.widget.Toast
import java.lang.Exception
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class ReadAndWriteMemory {
    var dataMemoryLine1 = ""
    var dataMemoryLine2 = ""
    var dataMemoryLine3 = ""
    var dataMemoryLine4 = ""
    var dataMemoryLine5 = ""
    var dataMemoryLine6 = ""
    var dataMemoryLine7 = ""

    fun writeDataMemory(
        context: Context,
        fileNameSaverMemory: String,
        dataSaverMemory: String = "",
    ) {
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = context.openFileOutput(fileNameSaverMemory, Context.MODE_PRIVATE)
            fileOutputStream.write(dataSaverMemory.toByteArray())
            Toast.makeText(context, "data update complete", Toast.LENGTH_SHORT).show()
            fileOutputStream.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            println("data wite fail")
        } catch (e: Exception) {
            e.printStackTrace()
            println("data wite fail")
        }
    }

    fun readDataMemory(context: Context?, fileNameSaverMemory: String) {
        var fileInputStream: FileInputStream? = null
        if (context != null) {
            fileInputStream = context.openFileInput(fileNameSaverMemory)
        }
        val inputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null

        var i  = 1
        while ({ text = bufferedReader.readLine(); text }() != null) {
            stringBuilder.append(text)
            stringBuilder.append("\n")
            when (i) {
                1 -> dataMemoryLine1 = text.toString()
                2 -> dataMemoryLine2 = text.toString()
                3 -> dataMemoryLine3 = text.toString()
                4 -> dataMemoryLine4 = text.toString()
                5 -> dataMemoryLine5 = text.toString()
                6 -> dataMemoryLine6 = text.toString()
                7 -> dataMemoryLine7 = text.toString()
            }
            i++
        }
        Toast.makeText(context, dataMemoryLine1 + " " + dataMemoryLine2 + " "
                + dataMemoryLine3 + " " + dataMemoryLine4, Toast.LENGTH_SHORT).show()

    }


}