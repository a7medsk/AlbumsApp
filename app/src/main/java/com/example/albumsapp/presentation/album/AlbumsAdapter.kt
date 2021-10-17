package com.example.albumsapp.presentation.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.albumsapp.R
import com.example.albumsapp.databinding.HolderAlbumBinding
import com.example.albumsapp.domain.model.Album
import com.example.albumsapp.presentation.loadImage
import java.util.ArrayList


/**
 *Created by haskhiri on 17/10/2021
 */
internal class AlbumsAdapter(val mListener: OnAlbumAdapterListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val albums: MutableList<Album> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderAlbumBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.holder_album, parent, false
        )
        return PhotoViewHolder(holderAlbumBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PhotoViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int): Album {
        return albums[position]
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    fun addData(list: List<Album>) {
        this.albums.clear()
        this.albums.addAll(list)
        notifyDataSetChanged()
    }


    inner class PhotoViewHolder(private val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root) {


        fun onBind(album: Album) {
            val holderAlbumBinding = dataBinding as HolderAlbumBinding
            holderAlbumBinding.albumViewModel = AlbumViewModel(album)
            holderAlbumBinding.photoProgressBar.visibility = View.VISIBLE
            holderAlbumBinding.photoImageView.loadImage(album.url, holderAlbumBinding.photoProgressBar)


            itemView.setOnClickListener {
                mListener.gotoDetailPage(holderAlbumBinding.photoImageView, album.id)
            }

        }
    }
}