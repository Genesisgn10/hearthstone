package com.genesis.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.genesis.extensions.loadingImage
import com.genesis.meals.R
import com.genesis.meals.databinding.ItemCardBinding
import com.genesis.presenter.model.HearthstoneUiModel
import com.genesis.extensions.findNavController

class HearthstoneAdapter(
    private val hearthstone: List<HearthstoneUiModel>
) : RecyclerView.Adapter<HearthstoneAdapter.HearViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HearViewHolder {
        val view = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HearViewHolder(view)
    }

    override fun onBindViewHolder(holder: HearViewHolder, position: Int) {
        val hearthstone = hearthstone[position]
        with(holder) {
            binding.run {
                textTitle.text = hearthstone.name
                imageIcon.loadingImage(hearthstone.img)
                card.setOnClickListener { view ->
                    view.findNavController(R.id.infoCard, CHAVE, hearthstone)
                }
            }
        }

    }

    override fun getItemCount() = hearthstone.size

    inner class HearViewHolder(val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val CHAVE = "hearthstone"
    }
}