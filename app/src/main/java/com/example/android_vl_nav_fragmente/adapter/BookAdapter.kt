package com.example.android_vl_nav_fragmente.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.android_vl_nav_fragmente.data.model.Book
import com.example.android_vl_nav_fragmente.databinding.ListItemBookBinding
import com.example.android_vl_nav_fragmente.ui.BookEditFragment
import com.example.android_vl_nav_fragmente.ui.BookListFragmentDirections

class BookAdapter(
    val books: MutableList<Book>
): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(val vb: ListItemBookBinding): RecyclerView.ViewHolder(vb.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val viewBinding = ListItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       return BookViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.vb.tvBookTitle.text = book.title

        holder.vb.root.setOnClickListener {
            holder.itemView.findNavController().navigate(
                BookListFragmentDirections.actionBookListFragmentToBookEditFragment(book.title)
            )
        }
    }
}