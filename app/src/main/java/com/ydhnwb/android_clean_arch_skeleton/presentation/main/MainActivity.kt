package com.ydhnwb.android_clean_arch_skeleton.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ydhnwb.android_clean_arch_skeleton.R
import com.ydhnwb.android_clean_arch_skeleton.common.extensions.hide
import com.ydhnwb.android_clean_arch_skeleton.common.extensions.showToast
import com.ydhnwb.android_clean_arch_skeleton.common.extensions.visible
import com.ydhnwb.android_clean_arch_skeleton.databinding.ActivityMainBinding
import com.ydhnwb.feature_post.data.dto.response.PostResponse
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), PostAdapterListener {
    private lateinit var binding : ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        observeChanges()
    }

    private fun fetchPosts(){
        mainViewModel.fetchPost()
    }

    private fun observeChanges(){
        observeState()
        observePosts()
    }

    private fun observeState() = mainViewModel.listenToState().observe(this, { handleStateChange(it) })
    private fun observePosts() = mainViewModel.listenToPosts().observe(this, { handlePostsChange(it) })

    private fun handleStateChange(state : MainActivityState){
        when(state) {
            is MainActivityState.IsLoading -> showLoading(state.isLoading)
            is MainActivityState.ShowtToast -> showToast(state.message)
        }
    }

    private fun showLoading(isShow: Boolean) {
        if(isShow){
            binding.postProgressBar.visible()
        }else{
            binding.postProgressBar.hide()
        }
    }

    private fun handlePostsChange(posts: List<PostResponse>){
        binding.postRecyclerView.adapter?.let { adapter ->
            if(adapter is PostAdapter){
                adapter.updateData(posts)
            }
        }
    }

    private fun setupUI(){
        setupPostRecyclerView()
    }

    private fun setupPostRecyclerView(){
        binding.postRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostAdapter(mutableListOf(), this@MainActivity)
        }
    }

    override fun onResume() {
        fetchPosts()
        super.onResume()
    }

    override fun onTap(post: PostResponse) = showToast(post.title.toString())
    override fun onLongTap(post: PostResponse) = showToast(post.title.toString())

}