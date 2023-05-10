package uz.ghost.room.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select
import uz.ghost.room.models.Student

@Dao
interface StudentDao {
    @Query("select * from student")
    fun getAlldtudents():List<Student>

    @Insert
    fun addStudent(student: Student)

}