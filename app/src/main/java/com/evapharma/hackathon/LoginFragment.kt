package com.evapharma.hackathon

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class LoginFragment : Fragment() {

    private var listener: LoginFragmentInteraction? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as LoginFragmentInteraction
    }

    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = arguments?.getString("name")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val name: String? = null
        val newName: String = name?.let {
            it + "new"
        } ?: "Empty"
//        newName -> My Namenew
//        newName -> Empty

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false).apply {
//            findViewById<>()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Toast.makeText(context, "", Toast.LENGTH_LONG).show()
        view.findViewById<TextView>(R.id.tv_title).apply {
            text = name ?: "No Name Retrieved"
            setOnClickListener{
                listener?.onNameClicked("ajksdakjsdhask")
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        fun newInstance(name: String? = null): LoginFragment {
            val loginFragment = LoginFragment()
            val bundle = Bundle()
            name?.let { bundle.putString("name", name) }
            loginFragment.arguments = bundle
            return loginFragment
        }
    }
}

interface LoginFragmentInteraction {
    fun onNameClicked(name: String)
}