package com.vasilevkin.catsanddogs.features.animalList.view.viewpager

//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.fragment.app.Fragment
//import com.vasilevkin.catsanddogs.R
//import com.vasilevkin.catsanddogs.models.localModels.Animal
//import com.vasilevkin.catsanddogs.utils.downloadImageInView
//
//class AnimalFragment() : Fragment() {
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
//    Bundle?): View? {
//
//        // Creates the view controlled by the fragment
//        val view = inflater.inflate(R.layout.fragment_animal, container, false)
//        val titleTextView = view.findViewById<TextView>(R.id.fragment_title_text_view)
//        val subtitleTextView = view.findViewById<TextView>(R.id.fragment_subtitle_text_view)
//        val detailsImageView = view.findViewById<ImageView>(R.id.fragment_details_image)
//
//        // Retrieve and display the animal data from the Bundle
//        val args = arguments
//        titleTextView.text = args?.getString(AnimalHelper.KEY_TITLE)
//        subtitleTextView.text = args?.getString(AnimalHelper.KEY_SUBTITLE)
//
//        downloadImageInView(this.context!!, detailsImageView,
//            args?.getString(AnimalHelper.KEY_IMAGE_URL)!!
//        )
//
//        return view
//    }
//
//    companion object {
//
//        // Method for creating new instances of the fragment
//        fun newInstance(animal: Animal): AnimalFragment {
//
//            // Store the animal data in a Bundle object
//            val args = Bundle()
//            args.putString(AnimalHelper.KEY_TITLE, animal.title)
//            args.putString(AnimalHelper.KEY_SUBTITLE, animal.subtitle)
//            args.putString(AnimalHelper.KEY_IMAGE_URL, animal.imageUrl)
//
//            // Create a new AnimalFragment and set the Bundle as the arguments
//            // to be retrieved and displayed when the view is created
//            val fragment = AnimalFragment()
//            fragment.arguments = args
//            return fragment
//        }
//    }
//
//}
