package com.ydhnwb.android_clean_arch_skeleton.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ydhnwb.android_clean_arch_skeleton.R
import com.ydhnwb.android_clean_arch_skeleton.databinding.ItemPostBinding
import com.ydhnwb.feature_post.data.dto.response.PostResponse

class PostAdapter(private val posts : MutableList<PostResponse>, private val postAdapterListener: PostAdapterListener) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(posts[position])

    override fun getItemCount() = posts.size

    fun updateData(datas : List<PostResponse>){
        posts.clear()
        posts.addAll(datas)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPostBinding.bind(itemView)

        fun bind(post: PostResponse){
            binding.postTitle.text = post.title
            binding.postBody.text = post.body
            binding.root.setOnClickListener {
                postAdapterListener.onTap(post)
            }
        }
    }
}