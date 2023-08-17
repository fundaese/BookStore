package com.example.bookstore.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.bookstore.MainApplication
import com.example.bookstore.R
import com.example.bookstore.common.loadImage
import com.example.bookstore.common.viewBinding
import com.example.bookstore.data.model.GetBookDetailResponse
import com.example.bookstore.databinding.FragmentDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)

    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBookDetail(args.id)
        with(binding) {

        }
    }

    private fun getBookDetail(id: Int) {
        MainApplication.bookService?.getBookDetail(id)?.enqueue(object :
            Callback<GetBookDetailResponse> {
            override fun onResponse(
                call: Call<GetBookDetailResponse>,
                response: Response<GetBookDetailResponse>
            ) {
                val result = response.body()?.book

                if (result != null) {
                    with(binding) {
                        tvName.text = result.name
                        tvAuthor.text = "Yazar: ${result.author}"
                        tvPublisher.text = "Yayımcı: ${result.publisher}"
                        tvPrice.text = "Fiyat: ${result.price} ₺"
                        ivBook.loadImage(result.imageUrl)
                    }
                }
            }

            override fun onFailure(call: Call<GetBookDetailResponse>, t: Throwable) {
                Log.e("GetBooks", t.message.orEmpty())
            }
        })
    }
}