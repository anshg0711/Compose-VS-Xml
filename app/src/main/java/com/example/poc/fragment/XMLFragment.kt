package com.example.poc.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchingdetails.repository.roomDatabase.ContactRoomDatabase
import com.example.poc.R
import com.example.poc.adapter.RecycleViewAdapter
import com.example.poc.viewModel.ContactViewModel
import com.example.poc.viewModel.ContactViewModelFactory

class XMLFragment : Fragment() {
    private lateinit var contactViewModel: ContactViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecycleViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(
            getString(R.string.XMLFragmentLifeCycle),
            "${getString(R.string.onCreateView)}   ${Thread.currentThread().name}"
        )
        val contactRoomDatabase: ContactRoomDatabase =
            ContactRoomDatabase.getInstance(requireContext())
        contactViewModel =
            ViewModelProvider(requireActivity(), ContactViewModelFactory(contactRoomDatabase)).get(
                ContactViewModel::class.java
            )
        val view = inflater.inflate(R.layout.recycler_view, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = RecycleViewAdapter(contactViewModel)
        recyclerView.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(
            getString(R.string.XMLFragmentLifeCycle),
            "${getString(R.string.onViewCreated)}   ${Thread.currentThread().name}"
        )
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(
            getString(R.string.XMLFragmentLifeCycle),
            "${getString(R.string.onAttach)}   ${Thread.currentThread().name}"
        )
    }


    override fun onStart() {
        super.onStart()
        Log.d(
            getString(R.string.XMLFragmentLifeCycle),
            "${getString(R.string.onStart)}   ${Thread.currentThread().name}"
        )
    }

    override fun onResume() {
        super.onResume()
        Log.d(
            getString(R.string.XMLFragmentLifeCycle),
            "${getString(R.string.onResume)}   ${Thread.currentThread().name}"
        )
    }

    override fun onPause() {
        super.onPause()
        Log.d(
            getString(R.string.XMLFragmentLifeCycle),
            "${getString(R.string.onPause)}   ${Thread.currentThread().name}"
        )
    }

    override fun onStop() {
        super.onStop()
        Log.d(
            getString(R.string.XMLFragmentLifeCycle),
            "${getString(R.string.onStop)}   ${Thread.currentThread().name}"
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(
            getString(R.string.XMLFragmentLifeCycle),
            "${getString(R.string.onDestroyView)}   ${Thread.currentThread().name}"
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(
            getString(R.string.XMLFragmentLifeCycle),
            "${getString(R.string.onDestroy)}   ${Thread.currentThread().name}"
        )
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(
            getString(R.string.XMLFragmentLifeCycle),
            "${getString(R.string.onDetach)}   ${Thread.currentThread().name}"
        )
    }

}