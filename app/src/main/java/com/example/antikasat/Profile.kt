
package com.example.antikasat

import android.annotation.SuppressLint
import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.antikasat.databinding.FragmentHomeBinding
import com.example.antikasat.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

// aşağı kısım komple profil oluşturma fotoğraf yükleme gibi etkinlikler firebase ile bağlantısı var
@SuppressLint("StaticFieldLeak")
private lateinit var binding: FragmentProfileBinding
private lateinit var auth: FirebaseAuth
private lateinit var storageReference: StorageReference
private lateinit var databaseReference: DatabaseReference
private lateinit var imageUri: Uri
private lateinit var dialog: Dialog

class Profile : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var storageReference: StorageReference
    private lateinit var databaseReference: DatabaseReference
    private lateinit var imageUri: Uri

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding    .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        binding.saveBtn.setOnClickListener {
            showProgressBar()
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val bio = binding.etBio.text.toString()

            val user = User(firstName, lastName, bio)
            if (uid != null) {
                databaseReference.child(uid).setValue(user).addOnCompleteListener {
                    if (it.isSuccessful) {
                        uplodaProfilePic()
                    } else {
                        hideProgressBar()
                        Toast.makeText(requireContext(), "Profile upload failed.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun uplodaProfilePic() {
        imageUri = Uri.parse("android.resource://${requireContext().packageName}/${R.drawable.profile}")
        storageReference = FirebaseStorage.getInstance().getReference("Users/${auth.currentUser?.uid}")

        storageReference.putFile(imageUri)
            .addOnSuccessListener {
                hideProgressBar()
                Toast.makeText(requireContext(), "Profile upload successful.", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exception ->
                hideProgressBar()
                Toast.makeText(
                    requireContext(),
                    "Profile picture cannot be uploaded: ${exception.message}",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("ProfileUpload", "Profile picture cannot be uploaded", exception)
            }
    }

    private fun showProgressBar (){
        dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_wait)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }
    private fun hideProgressBar(){
        dialog.dismiss()
    }
}