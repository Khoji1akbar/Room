package uz.ghost.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Student {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var name:String? =null
    var grade:Int? = null

    constructor(name: String?, grade: Int?) {
        this.name = name
        this.grade = grade
    }

    constructor()

}