package com.patrick.fittracker.classoption

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.patrick.fittracker.NavigationDirections

import com.patrick.fittracker.R
import com.patrick.fittracker.cardio.selection.CardioSelectionViewModel
import com.patrick.fittracker.databinding.CardioSelectionFragmentBinding
import com.patrick.fittracker.databinding.ClassOptionFragmentBinding
import com.patrick.fittracker.ext.getVmFactory

class ClassOptionFragment : Fragment() {

//    private lateinit var viewModel: ClassOptionViewModel
    private val viewModel by viewModels <ClassOptionViewModel> {getVmFactory()}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ClassOptionFragmentBinding.inflate(inflater, container,false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        val adapter = ClassOptionAdapter(ClassOptionAdapter.OnClickListener{
            viewModel.navigateToCardioRecord(it)
        })
        binding.recyclerViewClassOption.adapter = adapter

        viewModel.classiption.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        viewModel.navigationToClassOptionRecord.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(NavigationDirections.actionGlobalClassOptionRecordFragment(it))
                viewModel.navigateToCardioRecordDone()
            }
        })



        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel



        return binding.root
    }

}