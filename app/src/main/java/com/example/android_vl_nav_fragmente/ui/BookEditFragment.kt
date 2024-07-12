package com.example.android_vl_nav_fragmente.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android_vl_nav_fragmente.MainActivity
import com.example.android_vl_nav_fragmente.databinding.FragmentBookEditBinding

class BookEditFragment : Fragment() {

    private lateinit var vb: FragmentBookEditBinding
    private val argumente: BookEditFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentBookEditBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        val books = mainActivity.books
        var book = books.find { it.title == argumente.bookTitle }

        vb.tvBookTitle.text = argumente.bookTitle


        vb.btAdd.setOnClickListener {
            val bookTitle = vb.etBookTitle.text.toString()
            book?.title = bookTitle
            findNavController().navigateUp()
        }
    }
}