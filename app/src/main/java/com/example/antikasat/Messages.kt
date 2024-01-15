package com.example.antikasat

// Messages.kt
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.antikasat.databinding.FragmentMessagesBinding

class Messages : Fragment() {

    private lateinit var binding: FragmentMessagesBinding
    private lateinit var userAdapter: UserAdapter
    private val userList = mutableListOf<UserProfile>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMessagesBinding.inflate(inflater, container, false)
        val view = binding.root

        userAdapter = UserAdapter(userList) { selectedUser ->
            val intent = Intent(requireContext(), MessageActivity::class.java)
            intent.putExtra("username", selectedUser.name)
            intent.putExtra("profileImage", selectedUser.profilePhotoResId)
            startActivity(intent)
        }

        binding.recyclerViewUsers.adapter = userAdapter
        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(requireContext())

        addFakeUserData()

        return view
    }

    private fun addFakeUserData() {
        userList.add(UserProfile("Jensen Ackles", R.drawable.jensen))
        userList.add(UserProfile("Jared Padalecki", R.drawable.jared))
        userList.add(UserProfile("Misha Collins", R.drawable.misha))
        userList.add(UserProfile("Mark Sheppard", R.drawable.mark))
        userList.add(UserProfile("Jeffrey Dean Morgan", R.drawable.jeffrey))
        userList.add(UserProfile("Jim Beaver", R.drawable.jim))
        userList.add(UserProfile("Alexander Calvert", R.drawable.alexander))
        userList.add(UserProfile("Genevieve Cortese", R.drawable.geneview))
        userList.add(UserProfile("Ruth Connell", R.drawable.ruth))
        userList.add(UserProfile("Richard Speight Jr.", R.drawable.richard))
        userList.add(UserProfile("Felicia Day", R.drawable.felicia))
        // Diğer kullanıcıları ekleyin

        userAdapter.notifyDataSetChanged()
    }

    private fun getFakeMessages(): List<Messagea> {
        return listOf(
            Messagea("Jensen Ackles", "Merhaba!", "12:30 PM",R.drawable.jensen),
            Messagea("John Doe", "Nasılsın?", "01:00 PM",R.drawable.jensen),
            Messagea("username", "Selam!", "01:15 PM",R.drawable.jensen),
            Messagea("username", "İyi, teşekkürler!", "01:20 PM",R.drawable.jensen)
        )
    }
}