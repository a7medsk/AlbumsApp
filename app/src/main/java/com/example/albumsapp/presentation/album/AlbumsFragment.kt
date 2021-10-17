package com.example.albumsapp.presentation.album

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.albumsapp.R
import com.example.albumsapp.databinding.FragmentAlbumsBinding
import com.example.albumsapp.presentation.gallery.OnGalleryCallback
import dagger.hilt.android.AndroidEntryPoint
/**
 *Created by haskhiri on 17/10/2021
 */

@AndroidEntryPoint
class AlbumsFragment : Fragment(), OnAlbumAdapterListener {

    private lateinit var fragmentAlbumsBinding: FragmentAlbumsBinding
    private var adapter: AlbumsAdapter? = null
    private var mCallback: OnGalleryCallback? = null
    private  val viewModel: AlbumsViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnGalleryCallback) {
            mCallback = context
        } else throw ClassCastException(context.toString() + "must implement OnGalleryCallback!")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = AlbumsAdapter(this)
        val albumId = arguments?.let { it.getLong(KEY_ALBUM_ID) }
        viewModel.getAlbums(albumId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentAlbumsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_albums, container, false)
        fragmentAlbumsBinding.albumsViewModel = viewModel
        fragmentAlbumsBinding.photosRecyclerView.adapter = adapter

        viewModel.isLoad.observe(viewLifecycleOwner, Observer {
            it?.let { visibility ->
                fragmentAlbumsBinding.photosProgressBar.visibility = if (visibility) View.GONE else View.VISIBLE
            }
        })

        viewModel.albumListReceivedLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter?.addData(it)
            }
        })

        return fragmentAlbumsBinding.root
    }

    override fun onDetach() {
        super.onDetach()
        mCallback = null
        adapter = null
    }


    companion object {

        val KEY_ALBUM_ID = "KEY_ALBUM_ID"
        val FRAGMENT_NAME = AlbumsFragment::class.java.name


        @JvmStatic
        fun newInstance() =
            AlbumsFragment().apply {
                arguments = Bundle().apply {
                }
            }


    }

    override fun gotoDetailPage(imageView: ImageView, id: Long) {
        mCallback?.gotoDetailPageByAlbumId(imageView, id)
    }


}