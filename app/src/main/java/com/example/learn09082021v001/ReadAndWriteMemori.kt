package com.example.learn09082021v001

import android.content.Context
import android.widget.Toast
import java.lang.Exception
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class ReadAndWriteMemori {
    var dataMemoriLine1 = ""
    var dataMemoriLine2 = ""
    var dataMemoriLine3 = ""
    var dataMemoriLine4 = ""
    var dataMemoriLine5 = ""
    var dataMemoriLine6 = ""
    var dataMemoriLine7 = ""

    fun WriteDataMemory(
        context: Context,
        fileNameSaverMemory: String,
        dataSaverMemori: String = "",
    ) {
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = context.openFileOutput(fileNameSaverMemory, Context.MODE_PRIVATE)
            fileOutputStream.write(dataSaverMemori.toByteArray())
            Toast.makeText(context, "data update complete", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            println("data wite fail")
        } catch (e: Exception) {
            e.printStackTrace()
            println("data wite fail")
        }
    }

    fun ReadDataMemori(context: Context?, fileNameSaverMemory: String) {
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
                1 -> dataMemoriLine1 = text.toString()
                2 -> dataMemoriLine2 = text.toString()
                3 -> dataMemoriLine3 = text.toString()
                4 -> dataMemoriLine4 = text.toString()
                5 -> dataMemoriLine5 = text.toString()
                6 -> dataMemoriLine6 = text.toString()
                7 -> dataMemoriLine7 = text.toString()
            }
            i++
        }
        Toast.makeText(context, dataMemoriLine1 + " " + dataMemoriLine2 + " "
                + dataMemoriLine3 + " " + dataMemoriLine4, Toast.LENGTH_SHORT).show()

    }


}