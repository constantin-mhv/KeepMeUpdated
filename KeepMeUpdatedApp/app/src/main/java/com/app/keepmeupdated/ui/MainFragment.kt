package com.app.keepmeupdated.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.keepmeupdated.R
import com.app.keepmeupdated.databinding.FragmentMainBinding
import com.app.keepmeupdated.ui.history.HistoryFragment
import com.app.keepmeupdated.ui.home.HomeFragment
import com.app.keepmeupdated.ui.people.PeopleFragment
import com.app.keepmeupdated.ui.profile.ProfileFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    class TabLayoutFragment(
        val fragment: Fragment,
        val iconId: Int
    )

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val tabLayoutFragments = arrayOf(
        TabLayoutFragment(HomeFragment(), R.drawable.baseline_home_24),
        TabLayoutFragment(HistoryFragment(), R.drawable.baseline_history_toggle_off_24),
        TabLayoutFragment(PeopleFragment(), R.drawable.baseline_people_alt_24),
        TabLayoutFragment(ProfileFragment(), R.drawable.baseline_account_box_24)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("tag1", tabLayoutFragments[1].fragment.toString())
        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> tabLayoutFragments[position].fragment
                    1 -> tabLayoutFragments[position].fragment
                    2 -> tabLayoutFragments[position].fragment
                    else -> tabLayoutFragments[position].fragment // tab 4
                }
            }

            override fun getItemCount(): Int {
                return tabLayoutFragments.size
            }
        }
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(tabLayoutFragments[position].iconId); tab.icon?.alpha = 240
                }
                1 -> {
                    tab.setIcon(tabLayoutFragments[position].iconId); tab.icon?.alpha = 70
                }
                2 -> {
                    tab.setIcon(tabLayoutFragments[position].iconId); tab.icon?.alpha = 70
                }
                else -> {
                    tab.setIcon(tabLayoutFragments[position].iconId); tab.icon?.alpha = 70
                }
            }
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 240
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 70
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}