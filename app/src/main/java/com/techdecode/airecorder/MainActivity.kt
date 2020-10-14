package com.techdecode.airecorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        saveBtn.setOnClickListener{
            val id :String = idField.text.toString()
            val name :String = nameField.text.toString()
            val age : String = ageField.text.toString()
            val userData = UserData(name,age)
            val ref = FirebaseDatabase.getInstance().getReference("${id}/")
            ref.setValue(userData)
                .addOnSuccessListener {
                  Toast.makeText(this,"Data Saved Successfully",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this,"Data could not be saved",Toast.LENGTH_SHORT).show()
                }
        }
    }
}

data class UserData(val name: String, val age: String){

        constructor(): this ("","")

}