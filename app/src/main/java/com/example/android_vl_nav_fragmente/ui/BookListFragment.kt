package com.example.android_vl_nav_fragmente.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android_vl_nav_fragmente.MainActivity
import com.example.android_vl_nav_fragmente.adapter.BookAdapter
import com.example.android_vl_nav_fragmente.data.Datasource
import com.example.android_vl_nav_fragmente.data.model.Book
import com.example.android_vl_nav_fragmente.databinding.FragmentBookListBinding

class BookListFragment : Fragment() {

    private lateinit var vb: FragmentBookListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentBookListBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        var books = mainActivity.books

        vb.rvBooks.adapter = BookAdapter(books)

        vb.btAdd.setOnClickListener {
            val newBookTitle = vb.etBookTitle.text.toString()
            val book = Book(newBookTitle)
            books.add(book)
            vb.rvBooks.adapter?.notifyItemInserted(books.size - 1)
            vb.etBookTitle.setText("")
        }
    }
}