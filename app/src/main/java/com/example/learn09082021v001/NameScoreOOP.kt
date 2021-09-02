package com.example.learn09082021v001

import android.content.Intent
import android.os.Bundle
import java.io.Serializable;

class NameScoreOOP : Serializable {
    var NameInputandroid: String = ""
    var ScoreInPutandroid: Int = 0
    var NameInPutIOS: String = ""
    var ScoreInPutIOS: Int = 0
    fun androiScoreINC() {
        if (ScoreInPutandroid <= 8) ScoreInPutandroid = ScoreInPutandroid + 1
    }

    fun androiScoreDEC() {
        if (ScoreInPutandroid >= 1) ScoreInPutandroid = ScoreInPutandroid - 1
    }

    fun IOSScoreINC() {
        if (ScoreInPutIOS <= 8) ScoreInPutIOS = ScoreInPutIOS + 1
    }

    fun IOSScoreDEC() {
        if (ScoreInPutIOS >= 1) ScoreInPutIOS = ScoreInPutIOS - 1
    }

}

class datasaveandload {
    public fun Intent.putExtra(s: String, scoreOOP: NameScoreOOP) {

    }

    public fun Intent.getExtra(s: String, scoreOOP: NameScoreOOP) {

    }
}
