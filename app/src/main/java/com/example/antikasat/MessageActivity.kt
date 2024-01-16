package com.example.antikasat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.antikasat.databinding.ActivityMessageBinding

class MessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessageBinding
    private lateinit var messageAdapter: MessageAdapter
    private val messageList: MutableList<Messagea?> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Intent'ten verileri al
        val username = intent.getStringExtra("username")
        val profileImage = intent.getIntExtra("profileImage", 0)

        // Mesajlar için sahte veri ekle (örnek olarak)
        val fakeMessages = getFakeMessages(username)
        messageList.addAll(fakeMessages)

        binding.usernameTextView.text = username
        binding.profileImageView.setImageResource(profileImage)

        messageAdapter = MessageAdapter(messageList.filterNotNull())
        binding.recyclerViewMessages.adapter = messageAdapter
        binding.recyclerViewMessages.layoutManager = LinearLayoutManager(this)
        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }

}

    private fun getFakeMessages(username: String?): List<Messagea?> {
        return when (username) {
            "Jensen Ackles" -> listOf(
                Messagea("Jared Padalecki", "Hello!", "12:30 PM", R.drawable.jared),
                Messagea("Jared Padalecki", "Can you tell me a price about this razor?", "01:00 PM", R.drawable.jared),
                Messagea("Jensen Ackles", "Hi!", "01:15 PM", R.drawable.jensen),
                Messagea("Jensen Ackles", "Let me see... This is 5470 euros.", "01:20 PM", R.drawable.jensen),
                Messagea("Jared Padalecki", "Too much. Do me a better price.", "12:30 PM", R.drawable.jared),
                Messagea("Jensen Ackles", "Hmmm maybe 5160 euros and this is the best I can do.!", "01:15 PM", R.drawable.jensen),
                Messagea("Jared Padalecki", "I know a few things about this razor, it is not worth that amount at the moment.", "12:30 PM", R.drawable.jared),
                Messagea("Jared Padalecki", "Oook, I hope you find a buyer because I know that all your razors are here for ages", "12:30 PM", R.drawable.jared),
            )
            "Jared Padalecki" -> listOf(
                Messagea("Jim Beaver", "Hello!", "12:30 PM", R.drawable.jim    ),
                Messagea("Jim Beaver", "I'm looking for some unique pieces for my antique collection. Do you have anything interesting?", "01:00 PM", R.drawable.jim),
                Messagea("Jared Padalecki", "Hi!", "01:15 PM", R.drawable.jared),
                Messagea("Jared Padalecki", "Absolutely! We have a wide range of antiques from different periods. What specifically are you interested in?.", "01:20 PM", R.drawable.jared),
                Messagea("Jim Beaver", " I'm into vintage furniture, especially chairs and tables. Anything like that available?", "12:30 PM", R.drawable.jim),
                Messagea("Jared Padalecki", "Certainly! We have a beautiful Victorian-era chair over here and a mahogany table from the early 20th century. Let me show you.", "01:15 PM", R.drawable.jared),
                Messagea("Jim Beaver", "Oh, that chair is stunning! What's the history behind it?", "12:30 PM", R.drawable.jim),
                Messagea("Jared Padalecki", " It's a Victorian parlor chair from the late 1800s. The intricate woodwork and upholstery are all original. It's a real gem.", "12:30 PM", R.drawable.jared),
                Messagea("Jim Beaver", " Considering their rarity and condition, I can offer you a package deal of \$800 for both. What do you think?", "12:30 PM", R.drawable.jim),
                Messagea("Jared Padalecki", " You drive a hard bargain! But let's make it \$770, and I'll include free delivery. Deal?", "12:30 PM", R.drawable.jared),

            )
            "Misha Collins" -> listOf(
                Messagea("Mark Sheppard", "Hello there! Are you a collector or just browsing?!", "12:30 PM", R.drawable.mark),
                Messagea("Misha Collins", "Hi! I'm a collector, always on the lookout for unique items. Anything special in your shop?", "01:00 PM", R.drawable.misha),
                Messagea("Mark Sheppard", "Absolutely! We specialize in vintage watches and jewelry. Take a look around. Is there a particular era you're interested in?!", "01:15 PM", R.drawable.mark),
                Messagea("Misha Collins", "I'm fascinated by Art Deco pieces. Anything from that period?.", "01:20 PM", R.drawable.misha),
                Messagea("Mark Sheppard", " You're in luck! We have this stunning Art Deco diamond brooch. It's a real statement piece.", "12:30 PM", R.drawable.mark),
                Messagea("Misha Collins", "It's beautiful! Can you tell me more about it?", "01:15 PM", R.drawable.misha),
                Messagea("Mark Sheppard", "Certainly! This brooch is from the 1920s, featuring intricate geometric designs and high-quality diamonds. It's a true representation of the Art Deco style.", "12:30 PM", R.drawable.mark),
                Messagea("Misha Collins", "  I'm interested. What's the price?", "12:30 PM", R.drawable.misha),
                Messagea("Mark Sheppard", "  Given its rarity and craftsmanship, I'm offering it for \$1,200. It also comes with a certificate of authenticity.", "12:30 PM", R.drawable.mark),
                Messagea("Misha Collins", " That's a bit steep. How about \$1,000?", "12:30 PM", R.drawable.misha),
                Messagea("Mark Sheppard", " I appreciate your interest. Let's meet in the middle at \$1,100. What do you think?", "12:30 PM", R.drawable.mark),
                Messagea("Misha Collins", " Fair enough. I'll take it for \$1,100. Do you accept credit cards?", "12:30 PM", R.drawable.misha),
                Messagea("Mark Sheppard", " Certainly! We accept all major credit cards. Let me prepare the paperwork for you.", "12:30 PM", R.drawable.mark),

                )
            "Mark Sheppard" -> listOf(
                Messagea("Ruth Connell", "Good day! Are you in search of something specific or just exploring today?!", "12:30 PM", R.drawable.ruth),
                Messagea("Mark Sheppard", "Hello! I'm on the hunt for unique antique furniture. Anything noteworthy in your shop?", "01:00 PM", R.drawable.mark),
                Messagea("Ruth Connell", "Absolutely! We have a beautiful Victorian-era oak dresser that just came in. It's in excellent condition. Care to take a look?!", "01:15 PM", R.drawable.ruth),
                Messagea("Mark Sheppard", "Victorian, you say? I'm intrigued. Could you provide more details about the dresser?", "01:20 PM", R.drawable.mark),
                Messagea("Ruth Connell", "  Certainly! This dresser dates back to the late 19th century, showcasing intricate carvings and brass hardware. It's a genuine piece from the Victorian era.", "12:30 PM", R.drawable.ruth),
                Messagea("Mark Sheppard", "It looks impressive. What's the asking price?", "01:15 PM", R.drawable.mark),
                Messagea("Ruth Connell", " Given its historical value and condition, I'm offering it for \$800. I can also arrange delivery to your address", "12:30 PM", R.drawable.ruth),
                Messagea("Mark Sheppard", " That's a bit more than I budgeted. How about \$700?", "12:30 PM", R.drawable.mark),
                Messagea("Ruth Connell", "  I understand your budget considerations. Let's meet halfway at \$750. It's a steal for such a unique piece.", "12:30 PM", R.drawable.ruth),
                Messagea("Mark Sheppard", " Alright, \$750 it is", "12:30 PM", R.drawable.mark),

                )
            "Jeffrey Dean Morgan" -> listOf(
                Messagea("Felicia Day", "Hello there! Are you a collector or just browsing?!", "12:30 PM", R.drawable.felicia    ),
                Messagea("Jeffrey Dean Morgan", "Hi! I'm a collector, always on the lookout for unique items. Anything special in your shop?", "01:00 PM", R.drawable.jeffrey),
                Messagea("Felicia Day", "Absolutely! We specialize in vintage watches and jewelry. Take a look around. Is there a particular era you're interested in?!", "01:15 PM", R.drawable.felicia),
                Messagea("Jeffrey Dean Morgan", "I'm fascinated by Art Deco pieces. Anything from that period?.", "01:20 PM", R.drawable.jeffrey),
                Messagea("Felicia Day", " You're in luck! We have this stunning Art Deco diamond brooch. It's a real statement piece.", "12:30 PM", R.drawable.felicia),
                Messagea("Jeffrey Dean Morgan", "It's beautiful! Can you tell me more about it?", "01:15 PM", R.drawable.jeffrey),
                Messagea("Felicia Day", "Certainly! This brooch is from the 1920s, featuring intricate geometric designs and high-quality diamonds. It's a true representation of the Art Deco style.", "12:30 PM", R.drawable.felicia),
                Messagea("Jeffrey Dean Morgan", "  I'm interested. What's the price?", "12:30 PM", R.drawable.jeffrey),
                Messagea("Felicia Day", "  Given its rarity and craftsmanship, I'm offering it for \$1,200. It also comes with a certificate of authenticity.", "12:30 PM", R.drawable.felicia),
                Messagea("Jeffrey Dean Morgan", " That's a bit steep. How about \$1,000?", "12:30 PM", R.drawable.jeffrey),
                Messagea("Felicia Day", " I appreciate your interest. Let's meet in the middle at \$1,100. What do you think?", "12:30 PM", R.drawable.felicia),
                Messagea("Jeffrey Dean Morgan", " Fair enough. I'll take it for \$1,100. Do you accept credit cards?", "12:30 PM", R.drawable.jeffrey),
                Messagea("Felicia Day", " Certainly! We accept all major credit cards. Let me prepare the paperwork for you.", "12:30 PM", R.drawable.felicia),

                )
            "Jim Beaver" -> listOf(
                Messagea("Jim Beaver", "Good day! Are you searching for something specific, or just exploring our collection?!", "12:30 PM", R.drawable.jim),
                Messagea("Misha Collins", "Hey! I'm a collector, always on the hunt for unique pieces. Anything special you'd recommend?", "01:00 PM", R.drawable.misha),
                Messagea("Jim Beaver", "Absolutely! We specialize in antique furniture and decor. Is there a particular era or style you're interested in?", "01:15 PM", R.drawable.jim),
                Messagea("Misha Collins", "I'm into mid-century modern design. Anything along those lines?", "01:20 PM", R.drawable.misha),
                Messagea("Jim Beaver", " You're in luck! We have this gorgeous mid-century modern teak sideboard. It's a timeless piece.", "12:30 PM", R.drawable.jim),
                Messagea("Misha Collins", "It looks fantastic! Can you tell me more about its history and condition?", "01:15 PM", R.drawable.misha),
                Messagea("Jim Beaver", " Certainly! This teak sideboard is from the 1960s, known for its clean lines and functional design. It's in excellent condition, showcasing the natural beauty of teak wood.", "12:30 PM", R.drawable.jim),
                Messagea("Misha Collins", "I'm interested. What's the price you're asking for?", "12:30 PM", R.drawable.misha),
                Messagea("Jim Beaver", "Given its rarity and craftsmanship, I'm offering it for \$800. It's a great deal for a piece of this quality.", "12:30 PM", R.drawable.jim),
                Messagea("Misha Collins", "Fair enough. I'll take it for \$800.", "12:30 PM", R.drawable.misha),

                )
            "Alexander Calvert" -> listOf(
                Messagea("Richard Speight Jr.", "Hey, I'm into vintage cameras. Got anything from the '60s?", "12:30 PM", R.drawable.richard),
                Messagea("Alexander Calvert", "Absolutely! Check out this Nikon F2 from the 1960s. It's a classic in great condition.", "01:00 PM", R.drawable.alexander),
                Messagea("Richard Speight Jr.", "Cool! What's the price?", "01:15 PM", R.drawable.richard),
                Messagea("Alexander Calvert", "I'm asking \$400. Comes with a stylish leather case.", "01:20 PM", R.drawable.alexander),
                Messagea("Richard Speight Jr.", " A bit steep. How about \$350?", "12:30 PM", R.drawable.richard),
                Messagea("Alexander Calvert", "Meet me at \$375. Deal?", "01:15 PM", R.drawable.alexander),
                Messagea("Richard Speight Jr.", " Deal. Do you take cards?", "12:30 PM", R.drawable.richard),
                Messagea("Alexander Calvert", "Sure, we take all major credit cards. I'll get the paperwork ready.", "12:30 PM", R.drawable.alexander),


                )
            "Genevieve Cortese" -> listOf(
                Messagea("Jared Padalecki", "Hi! I'm looking for unique vinyl records. Anything special in your collection?", "12:30 PM", R.drawable.jared),
                Messagea("Genevieve Cortese", "Welcome! We have a rare Beatles White Album from 1968. It's in excellent condition.", "01:00 PM", R.drawable.geneview),
                Messagea("Jared Padalecki", "Nice find! What's the asking price?", "01:15 PM", R.drawable.jared),
                Messagea("Genevieve Cortese", "I'm asking \$600 for this gem..", "01:20 PM", R.drawable.geneview),
                Messagea("Jared Padalecki", "A bit high. How about \$500?", "12:30 PM", R.drawable.jared),
                Messagea("Genevieve Cortese", "Let's meet in the middle at \$550. What do you say?", "01:15 PM", R.drawable.geneview),
                Messagea("Jared Padalecki", " Deal. Do you accept digital payments?", "12:30 PM", R.drawable.jared),
                Messagea("Genevieve Cortese", "Certainly! We accept digital payments. I'll get it ready for you.", "12:30 PM", R.drawable.geneview),


                )
            "Ruth Connell" -> listOf(
                Messagea("Jared Padalecki", "Hello! I'm on the lookout for antique furniture. Anything interesting in your shop?", "12:30 PM", R.drawable.jared),
                Messagea("Ruth Connell", "Greetings! We have a beautiful Victorian-era oak dresser that just came in. It's a stunning piece with intricate carvings.", "01:00 PM", R.drawable.ruth),
                Messagea("Jared Padalecki", "I love Victorian furniture! What's the price on the dresser?", "01:15 PM", R.drawable.jared),
                Messagea("Ruth Connell", "I'm asking \$800 for this exquisite dresser.", "01:20 PM", R.drawable.ruth),
                Messagea("Jared Padalecki", "It's a bit above my budget. Can you do \$700?", "12:30 PM", R.drawable.jared),
                Messagea("Ruth Connell", "How about we settle at \$750? It's a unique piece with a lot of history.", "01:15 PM", R.drawable.ruth),
                Messagea("Jared Padalecki", " Alright, \$750 sounds fair. Do you offer delivery?", "12:30 PM", R.drawable.jared),
                Messagea("Ruth Connell", "Absolutely! We provide delivery service for an additional \$50. Would you like to proceed with that?", "12:30 PM", R.drawable.ruth),
                Messagea("Jared Padalecki", " Yes, please. Let's go ahead with the delivery.", "12:30 PM", R.drawable.jared),

                )

            "Richard Speight Jr." -> listOf(
                Messagea("Jensen Ackles", "Hey there! I'm in search of vintage cameras. Do you have any in your collection?", "12:30 PM", R.drawable.jensen),
                Messagea("Richard Speight Jr.", "Hello! We do have a few vintage cameras, including a classic Kodak from the 1960s. Are you specifically looking for any brand or type?", "01:00 PM", R.drawable.richard),
                Messagea("Jensen Ackles", "I'm a fan of Kodak cameras! How much for the 1960s Kodak?", "01:15 PM", R.drawable.jensen),
                Messagea("Richard Speight Jr.", "I'm asking \$120 for the Kodak camera. It's in great condition and still functional.", "01:20 PM", R.drawable.richard),
                Messagea("Jensen Ackles", "Sounds good! Can you share more details about its features and condition?", "12:30 PM", R.drawable.jensen),
                Messagea("Richard Speight Jr.", "Certainly! The Kodak camera has a manual focus lens and is equipped with a built-in light meter. The leather case is included, and overall, it's in excellent condition.", "01:15 PM", R.drawable.richard),
                Messagea("Jensen Ackles", " I'm sold! Would you consider \$100 for it?", "12:30 PM", R.drawable.jensen),
                Messagea("Richard Speight Jr.", "How about we meet in the middle at \$110? It's a fantastic piece of vintage photography history.", "12:30 PM", R.drawable.richard),
                Messagea("Jensen Ackles", " Deal!", "12:30 PM", R.drawable.jensen),

                )
            "Felicia Day" -> listOf(
                Messagea("Jared Padalecki", "Hi! I'm on the lookout for unique antique books. Do you have any rare editions or interesting finds", "12:30 PM", R.drawable.jared),
                Messagea("Felicia Day", "Greetings! We do have a collection of rare antique books, including a first edition of \"Pride and Prejudice\" by Jane Austen. Are you interested in literature or a specific genre?", "01:00 PM", R.drawable.felicia),
                Messagea("Jared Padalecki", "Oh, \"Pride and Prejudice\" is a classic! What's the condition of the first edition, and how much are you asking for it?", "01:15 PM", R.drawable.jared),
                Messagea("Felicia Day", "The first edition is in good condition, considering its age. I'm asking \$800 for this literary gem.", "01:20 PM", R.drawable.felicia),
                Messagea("Jared Padalecki", "That sounds intriguing! Can you tell me more about its history and any notable features?", "12:30 PM", R.drawable.jared),
                Messagea("Felicia Day", "Certainly! This first edition was published in 1813 and features the original binding and cover art. It's a rare find for collectors of Jane Austen's works.", "01:15 PM", R.drawable.felicia),
                Messagea("Jared Padalecki", "I'm fascinated! How about we settle on \$700 for it?", "12:30 PM", R.drawable.jared),
                Messagea("Felicia Day", "Given its rarity and historical value, I can go down to \$750. What do you think?", "12:30 PM", R.drawable.felicia),
                Messagea("Jared Padalecki", "Deal! I'll take it for \$750..", "12:30 PM", R.drawable.jared),

                )
            // Diğer kullanıcılar için de durumu kontrol et
            else -> emptyList()
        }
    }

