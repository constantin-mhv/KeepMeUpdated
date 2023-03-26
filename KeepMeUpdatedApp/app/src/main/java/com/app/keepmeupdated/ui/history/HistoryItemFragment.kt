package com.app.keepmeupdated.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.keepmeupdated.MainActivity
import com.app.keepmeupdated.databinding.FragmentHistoryItemBinding

class HistoryItemFragment : Fragment() {

    private var _binding: FragmentHistoryItemBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHistoryItemBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.historyItemButton.setOnClickListener {
//            view.findNavController().navigate(R.id.action_historyItemFragment_to_mainFragment)
            (requireActivity() as MainActivity).onBackPressedDispatcher.onBackPressed()
        }
    }

}