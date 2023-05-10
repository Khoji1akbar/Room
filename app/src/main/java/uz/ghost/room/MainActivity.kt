package uz.ghost.room

import android.app.AlertDialog
import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.ghost.room.Adabter.Adapter
import uz.ghost.room.databinding.ActivityMainBinding
import uz.ghost.room.databinding.ItemDialogBinding
import uz.ghost.room.db.MyDbHelper
import uz.ghost.room.models.Student

class MainActivity : AppCompatActivity() {
    lateinit var myDbHelper: MyDbHelper
    lateinit var adapter: Adapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        myDbHelper = MyDbHelper.newInstance(this)

        binding.apply {
            btnAdd.setOnClickListener{
                val dialog = AlertDialog.Builder(this@MainActivity).create()
                val itemDialog = ItemDialogBinding.inflate(layoutInflater)
                dialog.setView(itemDialog.root)
                itemDialog.btnAdd.setOnClickListener {
                    val student = Student(
                        itemDialog.edtName.text.toString(),
                        itemDialog.edtNumber.text.toString().toInt()
                    )
                    myDbHelper.studentDao().addStudent(student)
                    dialog.cancel()
                    onResume()
                }

                dialog.show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        adapter  = Adapter(myDbHelper.studentDao().getAlldtudents())
        binding.rv.adapter = adapter
    }
}