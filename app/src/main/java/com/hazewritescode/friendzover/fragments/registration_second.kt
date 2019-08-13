package com.hazewritescode.friendzover.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.hazewritescode.friendzover.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [registration_second.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [registration_second.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class registration_second : Fragment() {
    // TODO: Rename and change types of parameters
    private var listener: OnSecondFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration_second, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    public fun onButtonPressed() {
        val firstNameTextBox = view?.findViewById<TextView>(R.id.firstNameTextBox)
        val lastNameTextBox = view?.findViewById<TextView>(R.id.lastNameTextBox)

        val firstName = firstNameTextBox?.text.toString()
        val lastName = lastNameTextBox?.text.toString()

        listener?.onSecondFragmentInteraction(firstName, lastName)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSecondFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnSecondFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onSecondFragmentInteraction(firstName: String, secondName: String)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment registration_second.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            registration_second().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
