// HomeFragment.kt

package com.example.antikasat


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.antikasat.databinding.FragmentHomeBinding

class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeAdapter
    private val sharedPostsList = mutableListOf<SharedPost>()

    private val PICK_IMAGE_REQUEST = 1
    private var selectedImage: Bitmap? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // RecyclerView'ı oluştur ve adapörü ata
        adapter = HomeAdapter(requireContext(), sharedPostsList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Paylaşım butonuna tıklanınca SharingPost aktivitesini başlat
        val button: Button = view.findViewById(R.id.buttonshared)
        button.setOnClickListener {
            val intent = Intent(requireContext(), SharingPost::class.java)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        // Sahte veri ekleyerek RecyclerView'ı güncelle
        addFakeData()

        return view
    }

    private fun addFakeData() {
        // Sahte veri ekleme

        val fakePost1 = SharedPost("Jensen Ackles", "DETAILS\n" +
                "\n" +
                "A MAGNIFICENT OTTOMAN GILT-COPPER (TOMBAK) EWER\n" +
                "TURKEY, SECOND HALF 18TH CENTURY\n" +
                "Of tall baluster form rising from a short bevelled foot to a slightly waisted neck, one profile slightly flattened, the double curving cast spout decorated with leaves, with its original stopper, the rounded tapering lid with ribbed knop, the cast foliated loop handle joining the shoulder to the top of the neck, the body and lid with finely engraved rococo decoration, two original tombak chains joining the two suspension loops to the knop, the gilding very slightly rubbed on one side, minor old dents, otherwise in very good condition\n" +
                "12 7/8in. (37.8cm.) high", R.drawable.antique1)
        val fakePost2 = SharedPost("Jared Padalecki", "İA popular style, the Victorian parlor safe was usually beautifully decorated. Many were adorned with gold gilt, rosewood drawers, delicate paintings, or inlaid designs. Variations of this style safe are known as:\n" +
                "\n" +
                "Jewelry safe\n" +
                "Boudoir safe\n" +
                "Brothel safe\n" +
                "Tabletop parlor safe", R.drawable.antique2)
        val fakePost3 = SharedPost("Misha Collins", "One of the most multi-functional decorative objects to collect and own, mirrors serve multiple purposes beyond just the utilitarian function of evaluating one’s personal appearance. Whether you need to create more space in a room, add light to a dark environment, or simply seek to elevate an atmosphere with an air of sophistication, a well placed antique mirror could make the perfect addition to nearly any interior. While mirrors are thought of as a commonplace object in our lives, they have a surprisingly rich history, including fascinating evolutions in the manufacturing process over time, making antique mirrors sought after artifacts on the auction market to this day.", R.drawable.antique3)
        val fakePost4 = SharedPost("Mark Sheppard", "The tea plant (Camelia Sinensis) was first discovered and cultivated in southeast China over 3000 years ago. Tea leaves were initially chewed, or ground into a fine powder to be whipped with hot water in tea bowls, which were placed on lacquer or porcelain stands. By the 1st century BCE, people in China began boiling tea leaves, but it wasn't until the 14th century that today's most common preparation was established: steeping tea leaves in hot water. As this method spread across China, a purpose-made vessel in which to brew tea was developed. These early teapots were made from purple zisha clay and porcelain. One of the first written records of a teapot appears in the Yuan Dynasty (1271 – 1368), in a book describing a purple zisha teapot bought from the Chinese scholar Sun Daoming.", R.drawable.antique4)
        val fakePost5 = SharedPost("Jeffrey Dean Morgan", "I AM OFFERING FOR SALE THIS EVENING AN INTERESTING ANTIQUE HAND MADE VICTORIAN FLORAL BRONZE PHOTO FRAME, MADE APPROXIMATELY LATE PART OF 19TH CENTURY. MEASURES - 17 X 21 CM, APPROXIMATELY 7 X 8 INCHES. CONDITION - GOT WEARS AND SCRATCHES.\n" +
                "\n" +
                "\n" +
                "ITEMS ARE PRE - OWNED, ANTIQUE SHOPS FINDS, VINTAGE OR CONSIGNMENT ITEMS. I AM NOT AN EXPERT NOR DO I ATTEMPT TO BE, BUT I WILL MAKE EVERY EFFORT TO DESCRIBE ALL ITEMS CORRECTLY.\n" +
                "\n" +
                "\n" +
                "PLEASE NOTE - EVEN DESCRIBED IN EXCELLENT CONDITION ITEMS ON CERTAIN AGE USUALLY HAVE SOME NATURAL AGING TRACES.\n" +
                "\n" +
                "\n" +
                " I WILL DO MY BEST TO GIVE BUYERS EXCELLENT SERVICES.PLEASE ALLOW ME TO RESOLVE ANY PROBLEM YOU MAY HAVE PRIOR TO OPEN A ISSUE OR LEAVE FEEDBACK.\n" +
                "\n" +
                "HAPPY BIDDING", R.drawable.antique5)
        val fakePost6 = SharedPost("Jim Beaver", "Early 19th Century terracotta figure of a male deity, in the Khmer style. \n" +
                "\n" +
                "The figure sitting in a relaxed pose, with hair tied up and a serene content expression on his face. Featuring beaded bands around his neck and arms.\n" +
                "\n" +
                "It has a wonderful weathered patina that built up over many years yet still shows the defining features.\n" +
                "\n" +
                "Some old repairs, in a structurally sound and sturdy condition.\n" +
                "\n" +
                "Circa 1800.\n" +
                "\n" +
                "The Khmer Empire (also known as Kambujadesa) was located in Southeast Asia on the Indochinese Peninsula. It comprised modern-day Cambodia and much of Vietnam, Thailand, and Laos. Often considered one of the Seven Wonders of the World, Angkor Wat is located within the Khmer Empire's capital of Angkor (the spiritual heart of the once mighty Khmer Empire), located just north of the central Tonlé Sap Lako.", R.drawable.antique6)
        val fakePost7 = SharedPost("Alexander Calvert", "Copper Teapot, Turkish Teapot, Vintage Teaport, Handmade, Double Tea Maker, Authenic Pure Copper Teapot, Teapot With Wooden Handle", R.drawable.antique7)
        val fakePost8 = SharedPost("Genevieve Cortese", "Item Description\n" +
                "Original Item: Only One Available. This is a lovely percussion vest pistol, featuring a single piece brass body and a lovely \"bag\" shaped grip. The pistol was made in Liège, Belgium, almost certainly for the European and American export markets. These were quite popular for self-protection, and the small size made them easily concealable in a vest pocket. Pistols like this were equally at home on dark Streets of New York or of London in Victorian England. It features some lovely floral engraving on the sides of the lock, as well as on the tang of the receiver.\n" +
                "\n" +
                "The pistol measures about 6 ;⅝\" in overall length, with a 3\" smoothbore barrel. It is marked on the left side under the cap nipple with an E / L G / * in an Oval proof, indicating manufacture in Liège, Belgium. There are no other markings on the pistol that we can see, but this is not uncommon, as often these were sold to retailers, who would add their own markings and decorations if desired. The pistol features a very nice wooden \"bag\" style grip, which is very comfortable to hold.\n" +
                "\n" +
                "Condition of the pistol is very good, showing a lovely mellow patina on the brass, and some light oxidation on the steel moving components. The pistol is functional, though a very strong trigger pull can cause it to fire at the half cock position. The bag grip shows only light wear, with a few small\n" +
                "dents and dings.\n" +
                "A very nice early Victorian Era self defense pistol, ready to Display!", R.drawable.antique8)
        val fakePost9 = SharedPost("Ruth Connell", "This is an excellent example of a Mauser Contract, \"Red 9\"semi-automatic pistol. The trigger, safety, rear sight elevation bar and extractor have a brilliant niter blue finish. The grips have a large \"9\" filled with red paint burned into both sides. The right side of the pistol receiver is marked: \"WAFFENFABRIK MAUSER / OBERNDORF A NECKAR.\". The top of the barrel chamber is marked: \"WAFFENFABRIK / MAUSER / OBERNDORF A/N.\" There is an imperial eagle proof stamped on the front of the magazine. All components have matching serial numbers including the grips. The Mauser \"crown / U\" definitive proof mark is located on the upper left side of the receiver on the flat below the serial number and on top left side of the bolt.\n" +
                "BBL: 5-1/2 inch round\n" +
                "Stock:\n" +
                "Gauge: 9 mm P\n" +
                "Finish: blue\n" +
                "Grips: walnut\n" +
                "Serial Number: 80538\n" +
                "Condition: Excellent. The pistol retains 98% original finish with some minor spotting on the barrel and light wear on the muzzle and slide rails. The grips are excellent showing lanyard ring indentations on the inside edge of the left panel, a small ding on the right panel. The markings, all highlighted in white, remain crisp and clear. Mechanically excellent.", R.drawable.antique9)
        val fakePost10 = SharedPost("Richard Speight Jr.", "A very fine Arabian Saif of unusual form being from Yemen.\n" +
                "\n" +
                "This Arabian sword measure approx 94cms overall in the scabbard, approx 90cms out with a blade of 76cms.\n" +
                "The blade has three fullers, two narrow fullers closest to the spine and a broader fuller to the middle of the blade. All fullers terminate at approx 20cms from the hatchet style tip. The spine also narrows at this point to a false back edge. The blade remains in good condition and original polish though there are a few light stainings to the tip region and some very light piting in this region too.\n" +
                "Where the blade meets the langet and hilt, portions of the original resin securing the hilt has been excavated, for what purpose it is unknown and the blade suffers some light scratching at this point that would polish out easily.", R.drawable.antique10)
        val fakePost11 = SharedPost("Felicia Day", "Romans made coins out of flat, round discs, or ‘mints’ of pressed metal, developing a technique now known as minting – in fact, we still use the term ‘minted’ to describe someone rich today! Nowadays the minting process is all done by machines in factories, but the Romans made their minted coins entirely by hand. They were made in a workshop space known as a mint, resembling a blacksmith’s shop. Early Roman coins (from the 200s BCE) were made in bronze, but they later evolved to include silver, gold and copper in the coin-making process. The most popular and prevalent coin of the Roman Empire was the denarius, made from pressed silver; it remained in circulation for an astonishing five centuries. When making their coins, Romans used two different processes on metal – cold striking and hot striking. ", R.drawable.antique11)



        // Sahte verileri listeye ekle
        sharedPostsList.add(fakePost1)
        sharedPostsList.add(fakePost2)
        sharedPostsList.add(fakePost3)
        sharedPostsList.add(fakePost4)
        sharedPostsList.add(fakePost5)
        sharedPostsList.add(fakePost6)
        sharedPostsList.add(fakePost7)
        sharedPostsList.add(fakePost8)
        sharedPostsList.add(fakePost9)
        sharedPostsList.add(fakePost10)
        sharedPostsList.add(fakePost11)


        // Adapter'a değişikliği bildir
        adapter.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val username = data.getStringExtra("username")
            val description = data.getStringExtra("description")
            val imageBitmapString = data.getStringExtra("imageBitmap")

            if (!username.isNullOrEmpty() && !description.isNullOrEmpty() && !imageBitmapString.isNullOrEmpty()) {

                val imageResource = imageBitmapString.toIntOrNull()
                val post = SharedPost(username, description, imageResource ?: 0)
            }

        }
    }
}
